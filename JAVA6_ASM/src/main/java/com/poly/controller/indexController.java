package com.poly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.KhachHang;
import com.poly.entity.Loaisanpham;
import com.poly.entity.SanPham;
import com.poly.service.KhachHangService;
import com.poly.service.LoaiSP_Service;
import com.poly.service.SanPhamService;

@CrossOrigin("*")
@Controller
@RequestMapping("index")
public class indexController {
	@Autowired
	private SanPhamService spservice;
	@Autowired
	private LoaiSP_Service loaiSPServiece;
	
	@Autowired
	KhachHangService khsv;
	
    @Autowired
    private HttpSession httpSession;

	@GetMapping("/form")
	public String index(Model model) {
		// Hiển thị sản phẩm
		List<SanPham> list = spservice.findAll();
		model.addAttribute("items", list);
		// Hiển thị tên tiêu đề
		model.addAttribute("title", "Trang chủ");
		// Hiển thị loại sản phẩm trên thanh NAVBAR
		List<Loaisanpham> listLoai = loaiSPServiece.findAll();
		model.addAttribute("loaiSP", listLoai);
		return "/home/index";
	}

	@RequestMapping("/chitietsanpham")
	public String chitietsanpham(Model model) {
		return "/home/chitietsanpham";
	}

	@RequestMapping("/giohang")
	public String giohang(Model model) {
		return "/home/testGioHang";
	}

	@RequestMapping("/dathang")
	public String dathang(Model model) {
		return "/home/dathang";
	}

	@RequestMapping("/donhang")
	public String donhang(Model model) {
		return "/home/donhang";
	}

	@RequestMapping("/dangnhap")
	public String DangNhap(Model model) {
		model.addAttribute("message", "Vui lòng đăng nhập đi!");
		return "/home/DangNhap";
	}

	@RequestMapping("/DangKy")
	public String DangKy(Model model) {
		return "/home/DangKy";
	}

	@RequestMapping("/DoiMatKhau")
	public String DoiMatKhau(Model model) {
		return "/home/DoiMatKhau";
	}

	@RequestMapping("/CapNhatTaiKhoan")
	public String CapNhatTaiKhoan(Model model) {
		return "/home/CapNhatTaiKhoan";
	}

	@RequestMapping("/QuenMatKhau")
	public String QuenMatKhau(Model model) {
		return "/home/QuenMatKhau";
	}
	
	  @PostMapping("/login")
	    public String processLogin(@RequestParam("taiKhoan") String taiKhoan,
	                               @RequestParam("matKhau") String matKhau,
	                               HttpServletRequest request,
	                               Model model) {
	        KhachHang khachHang = khsv.findByTaiKhoan(taiKhoan);
	        if (khachHang != null && khachHang.getMatKhau().equals(matKhau)) {
	            // Xử lý đăng nhập thành công
	            httpSession.setAttribute("taiKhoan", taiKhoan); // Lưu tên tài khoản vào session

	            // Kiểm tra header "X-Requested-With" để xác định xem yêu cầu đến từ trang web hay từ RESTful API
	            String requestedWithHeader = request.getHeader("X-Requested-With");
	            if (StringUtils.hasText(requestedWithHeader) && requestedWithHeader.equals("XMLHttpRequest")) {
	                // Yêu cầu đến từ RESTful API
	                return "redirect:/api/auth/success"; // Chuyển hướng đến thành công API endpoint
	            } else {
	                // Yêu cầu đến từ trang web
	            	return "redirect:/index/form"; // Chuyển hướng đến trang chủ sau khi đăng nhập thành công
	            }
	        } else {
	            // Xử lý đăng nhập thất bại
	            model.addAttribute("message", "Tên tài khoản hoặc mật khẩu không đúng đó");
	            return "home/DangNhap"; // Trả về lại view của form đăng nhập với thông báo lỗi
	        }
	    }
	  
	  @PostMapping("/logout")
	    public String processLogout(HttpSession httpSession) {
	        // Xóa thông tin tài khoản khỏi session
	        httpSession.removeAttribute("taiKhoan");
	        
	        // Chuyển hướng đến trang chủ sau khi đăng xuất
	        return "redirect:/index/dangnhap";
	    }
}
