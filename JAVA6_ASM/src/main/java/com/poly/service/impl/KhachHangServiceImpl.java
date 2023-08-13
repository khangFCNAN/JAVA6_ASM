package com.poly.service.impl;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.management.InvalidApplicationException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.poly.dao.KhachhangDAO;
import com.poly.entity.KhachHang;
import com.poly.service.DuplicateEntryException;
import com.poly.service.KhachHangService;

@Service
public class KhachHangServiceImpl implements KhachHangService{
	@Autowired
	KhachhangDAO khdao;
	@Autowired
	KhachHangService khsv;
	
	@Autowired
	HttpSession session;

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public List<KhachHang> findAll() {
		return khdao.findAll();
	}

	@Override
	public KhachHang findTkAndMk(String taiKhoan, String matKhau) {
		return khdao.findByTaiKhoanAndMatKhau(taiKhoan, matKhau);
	}

	@Override
	public KhachHang findByUsername(KhachHang taiKhoan) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public KhachHang create(KhachHang khachHang) {
		return khdao.save(khachHang);
	}
	

    @Override
    public KhachHang findByTaiKhoan(String taiKhoan) {
        return khdao.findByTaiKhoan(taiKhoan);
    }
	
	public List<KhachHang> getAdministrators() {
		return khdao.getAdministrators();
	}

	@Override
	public KhachHang findById(String taiKhoan) {
		// TODO Auto-generated method stub
		return null;
	}
	
	 public boolean existsByTaiKhoan(String taiKhoan) {
	        return khdao.existsByTaiKhoan(taiKhoan);
	    }
	
	 public boolean existsByEmail(String email) {
	        return khdao.existsByEmail(email);
	   }
	
	//vinh them
	public void register(KhachHang khachhang) throws InvalidApplicationException, DuplicateEntryException {
	    // kiểm tra tính hợp lệ của dữ liệu đầu vào
	    if (khachhang.getTaiKhoan().isEmpty()) {
	        throw new InvalidApplicationException("Tài khoản không được để trống");
	    }
	    if (khachhang.getMatKhau().isEmpty()) {
	        throw new InvalidApplicationException("Mật khẩu không được để trống");
	    }
	    if (!isValidEmail(khachhang.getEmail())) {
	        throw new InvalidApplicationException("Email không hợp lệ");
	    }

	    // kiểm tra tài khoản và email đã tồn tại trong cơ sở dữ liệu hay chưa
	    if (khdao.existsByTaiKhoan(khachhang.getTaiKhoan())) {
	        throw new DuplicateEntryException("Tài khoản đã tồn tại");
	    }
//	    if (khdao.existsByEmail(khachhang.getEmail())) {
//	        throw new DuplicateEntryException("Email đã tồn tại");
//	    }

	    // lưu thông tin khách hàng vào cơ sở dữ liệu
	    khachhang.setAdmin(false);
	    khachhang.setTrangThai(false);
	    String maXacNhan = generateVerificationCode();
	    khachhang.setMaXacNhan(maXacNhan); // lưu mã xác nhận vào đối tượng User
	    khdao.save(khachhang); // lưu đối tượng User vào cơ sở dữ liệu
	    sendVerificationEmail(khachhang, maXacNhan);
	}
	

	public boolean isValidEmail(String email) {
	    String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
	    return email.matches(regex);
	}
	
	private String generateVerificationCode() {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			sb.append(chars.charAt(random.nextInt(chars.length())));
		}
		return sb.toString();
	}
	
	private void sendVerificationEmail(KhachHang khachhang, String maXacNhan) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(khachhang.getEmail());
		msg.setSubject("Vui lòng xác nhận tài khoản của bạn");
		msg.setText("Mã xác nhận được gửi đến tài khoản của bạn là: " + maXacNhan);
		javaMailSender.send(msg);
	}
	

	@Transactional
	public void verify(String code) {
		KhachHang khachhang = khdao.findBymaXacNhan(code);
		if (khachhang == null) {
			throw new RuntimeException("Mã xác nhận không hợp lệ");
		}
		if (khachhang.isTrangThai()) {
			throw new RuntimeException("Tài khoản đã được xác nhận trước đó");
		}
		khachhang.setTrangThai(true);
		khachhang.setMaXacNhan(null); // Xóa mã xác nhận khỏi đối tượng User
		khdao.save(khachhang);
	}
	
	public void resetPassword(String email) {
		KhachHang khachHang = khdao.findByEmail(email);
		khachHang.setTrangThai(true);
		if (khachHang == null) {
			throw new RuntimeException("Không tìm thấy khách hàng với email " + email);
		}
		String newPassword = "";
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			int randomNumber = random.nextInt(10);
			newPassword += Integer.toString(randomNumber);
		}
		khachHang.setMatKhau(newPassword);
		khdao.save(khachHang);
		// TODO: Gửi email thông báo về mật khẩu mới cho khách hàng
		String subject = "Thông báo mật khẩu mới cho tài khoản " + khachHang.getTaiKhoan();
		String text = "Mật khẩu mới của bạn là: " + newPassword;
		sendNewPass(email, subject, text);
	}
	
	private void sendNewPass(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		javaMailSender.send(message);
	}
	
	public String login(String taiKhoan, String matKhau, boolean ghiNho, Model model, HttpServletResponse response) throws IOException {
	    KhachHang khachHang = khdao.findByTaiKhoanAndMatKhau(taiKhoan, matKhau);
	    if (khachHang == null) {	
	        throw new RuntimeException("Tên đăng nhập hoặc mật khẩu không đúng");
	    }
	    if (!khachHang.isTrangThai()) {
	        throw new RuntimeException("Tài khoản của bạn đã chưa được xác minh, vui lòng kiểm tra mail hoặc chọn vào quên mật khẩu");
	    }

	    // Lưu thông tin đăng nhập vào session
	    session.setAttribute("khachhang", khachHang);

	    // Lưu tài khoản vào cookie nếu người dùng chọn checkbox "Ghi nhớ tôi"
	 // Mã hóa tài khoản trước khi lưu vào cookie nếu checkbox "Ghi nhớ tôi" được chọn
	    if (ghiNho) {
	        String encodedTaiKhoan = URLEncoder.encode(khachHang.getTaiKhoan(), "UTF-8");
	        Cookie cookie = new Cookie("taiKhoan", encodedTaiKhoan);
	        System.out.println(encodedTaiKhoan);
	        cookie.setMaxAge(120);
	        cookie.setPath("/");
	        response.addCookie(cookie);
	    } else {
	        Cookie cookie = new Cookie("taiKhoan", null);
	        cookie.setMaxAge(0);
	        cookie.setPath("/");
	        response.addCookie(cookie);
	    }
	    
	 // Kiểm tra nếu tài khoản là admin, chuyển hướng đến giao diện admin
	    if (khachHang.isAdmin()) {
	        model.addAttribute("khachHang", khachHang);
	        // Trả về tên của view cho giao diện admin
	        return "homeAD/indexAD";
	    }

	    // Trả về tên của view cho giao diện khách hàng
	    return "redirect:/index/form";
	}
	

	
}
