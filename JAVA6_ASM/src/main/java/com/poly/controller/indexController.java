package com.poly.controller;

import java.util.List;

import javax.management.InvalidApplicationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.KhachHang;
import com.poly.entity.Loaisanpham;
import com.poly.entity.SanPham;
import com.poly.service.DuplicateEntryException;
import com.poly.service.KhachHangService;
import com.poly.service.LoaiSP_Service;
import com.poly.service.SanPhamService;
import com.poly.service.impl.KhachHangServiceImpl;

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
	KhachHangServiceImpl khvip;
	
    @Autowired
    private HttpSession httpSession;
    
    @Autowired
	HttpServletRequest request;
    @Autowired
	HttpServletResponse response;

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
		
		// Lấy thông tin khách hàng từ session
	    String taiKhoan = (String) httpSession.getAttribute("taiKhoan");
	    if (taiKhoan != null) {
	        KhachHang khachHang = khsv.findByTaiKhoan(taiKhoan);
	        if (khachHang != null) {
	            String hoTen = khachHang.getHoTen();
	            model.addAttribute("hoTen", hoTen);
	        }
	    }
		return "/home/index";
	}

	@RequestMapping("/chitietsanpham")
	public String chitietsanpham(Model model) {
		return "/home/chitietsanpham";
	}

	@RequestMapping("/giohang")
	public String giohang(Model model) {
		return "home/testGioHang";
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
	
//	@GetMapping("/DangKy")
//	public String DangKy2(Model model) {
//		return "/home/DangKy";
//	}

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
	
	@GetMapping("/login")
	public String login(Model model) {
		return "/home/DangNhap";
	}
	
//	@PostMapping("/login")
//	public String processLogin(@RequestParam("taiKhoan") String taiKhoan,
//	                           @RequestParam("matKhau") String matKhau,
//	                           HttpServletRequest request,
//	                           HttpSession httpSession,
//	                           Model model) {
//	    KhachHang khachHang = khsv.findByTaiKhoan(taiKhoan);
//	    if (khachHang != null && khachHang.getMatKhau().equals(matKhau)) {
//	        // Xử lý đăng nhập thành công
//	        httpSession.setAttribute("khachHang", khachHang); // Lưu đối tượng tài khoản vào session
//	            // Yêu cầu đến từ trang web
//	            return "redirect:/index/form"; // Chuyển hướng đến trang chủ sau khi đăng nhập thành công
//	        
//	    } else {
//	        // Xử lý đăng nhập thất bại
//	        model.addAttribute("message", "Tên tài khoản hoặc mật khẩu không đúng đó");
//	        return "home/DangNhap"; // Trả về lại view của form đăng nhập với thông báo lỗi
//	    }
//	}
	
	@PostMapping("/login") // Xử lý click button Đăng nhập
	public String login(@RequestParam String taiKhoan, @RequestParam String matKhau,
			 Model model,  @RequestParam(value = "ghiNho", required = false) boolean ghiNho, 
            HttpServletResponse response) {
		String viewName = null;
		try {
			  viewName = khvip.login(taiKhoan, matKhau, ghiNho, model, response);
		    
			
//			userService.login(taiKhoan, matKhau, ghiNho, model, response);
//			return "redirect:/index/form";// Nếu đúng user,pass quay về trang chủ
		} catch (Exception e) {
//			model.addAttribute("errorMessage",  e.getMessage());
//			request.setAttribute("view", "DangNhap");
//			response.setCharacterEncoding("UTF-8");
//			return "index_Main";// Nếu sai ở lại trang đăng nhập
		}
		  return viewName ;
	}
	  
	  @RequestMapping("/logout")
	    public String processLogout(HttpSession httpSession) {
	        // Xóa thông tin tài khoản khỏi session
	        httpSession.removeAttribute("taiKhoan");
	        
	        // Chuyển hướng đến trang chủ sau khi đăng xuất
	        return "redirect:/index/dangnhap";
	    }
	  
	  @PostMapping("/signup") // Ấn button đăng kí
		public String register(@ModelAttribute("khachhang") KhachHang khachhang, BindingResult bindingResult, Model model, @RequestParam("nhapLaiMatKhau") String nhapLaiMatKhau) {
		    if (bindingResult.hasErrors()) {
		        return "/index/DangKi";
		    }

		    // Kiểm tra tài khoản và email đã tồn tại trong cơ sở dữ liệu hay chưa
		    if (khvip.existsByTaiKhoan(khachhang.getTaiKhoan())) {
		        model.addAttribute("taiKhoanError", "Tài khoản đã tồn tại");
		        return "/index/DangKy";
		    }
//		    if (khvip.existsByEmail(khachhang.getEmail())) {
//		        model.addAttribute("emailError", "Email đã tồn tại");
//		        return "index_Main";
//		    }
		    
		    // Kiểm tra mật khẩu và nhập lại mật khẩu có trùng nhau hay không
		    if (!khachhang.getMatKhau().equals(nhapLaiMatKhau)) {
		        model.addAttribute("matKhauError", "Mật khẩu và nhập lại mật khẩu không trùng khớp");
		        request.setAttribute("view", "DangKi");
				response.setCharacterEncoding("UTF-8");
		        return "index_Main";
		    }

		    try {
				khvip.register(khachhang);
			} catch (InvalidApplicationException e) {
				  model.addAttribute("errorMessage", e.getMessage());
				  request.setAttribute("view", "DangKi");
				 response.setCharacterEncoding("UTF-8");
			      return "index_Main";
			} catch (DuplicateEntryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return "redirect:/index/XacNhan";// Qua trang xác nhận pass
		}
	  
		@GetMapping("/XacNhan") // Qua trang xác nhận
		public String verify(Model model) {
			return "/home/nhapmaXN";
		}
		
		@PostMapping("/XacNhan") // Xử lý button đăng nhập
		public String verify(@RequestParam("code") String code, Model model) {
			try {
				khvip.verify(code);
				return "redirect:/index/XacNhanOk";
			} catch (Exception e) {
				 model.addAttribute("errorMessage", "Sai mã xác nhận");
				 request.setAttribute("view", "nhapmaXN");
				response.setCharacterEncoding("UTF-8");
				return "index/XacNhan";
			}
		}
		
		// Xác nhận thành công
		@GetMapping("/XacNhanOk") // Qua trang xác nhận
		public String XacNhanOk() {	
			return "/home/XacNhanOk";
		}
		
		@GetMapping("/QuenMatKhau") // Qua trang xác nhận
		public String Quenmatkhau() {	
			return "/home/QuenMatKhau";
		}
		
		@PostMapping("/QuenMatKhau")
		public String resetPassword(@RequestParam("email") String email, Model model) {
			try {
				khvip.resetPassword(email);
				model.addAttribute("message", "Mật khẩu mới đã được gửi đến địa chỉ email của bạn.");
				request.setAttribute("view", "QuenMatKhau");
				request.setCharacterEncoding("UTF-8");
			} catch (Exception e) {
				request.setAttribute("view", "QuenMatKhau");
		        model.addAttribute("error","Email của bạn chưa được đăng kí!");

			}
			return "/home/QuenMatKhau";
		}
}
