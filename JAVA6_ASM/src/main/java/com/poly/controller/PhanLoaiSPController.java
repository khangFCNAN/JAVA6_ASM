package com.poly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.poly.entity.Loaisanpham;
import com.poly.entity.SanPham;
import com.poly.service.LoaiSP_Service;
import com.poly.service.SanPhamService;

@CrossOrigin("*")
@Controller
@RequestMapping("/PhanLoaiSP")
public class PhanLoaiSPController {
    @Autowired
    private LoaiSP_Service loaiSPService;
    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("/sanpham")
    public String listSanPham(
            Model model,
            @RequestParam(value = "cid", required = false) Optional<Integer> cid,
            @RequestParam(value = "search", required = false) String searchInput,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "8") int size) {

        List<SanPham> list;
        int totalItems;

        if (cid.isPresent() && cid.get() != null) {
            // Lấy danh sách sản phẩm thuộc loại sản phẩm có ID tương ứng với giá trị của "cid"
            list = sanPhamService.findByLoaisanphamId(cid.get());
            totalItems = list.size();
        } else if (searchInput != null && !searchInput.isEmpty()) {
            // Lấy danh sách sản phẩm dựa trên tên sản phẩm tìm kiếm
            list = sanPhamService.findByTenSpContaining(searchInput);
            totalItems = list.size();
        } else {
            // Hiển thị tất cả sản phẩm
            list = sanPhamService.findAll();
            totalItems = list.size();
        }
        
        // Tính toán số trang và sublist của danh sách sản phẩm dựa trên trang hiện tại và số lượng sản phẩm trên mỗi trang
        int startIndex = Math.min((page - 1) * size, totalItems);
        int endIndex = Math.min(startIndex + size, totalItems);
        if (endIndex > totalItems) {
            endIndex = totalItems; // Đảm bảo endIndex không vượt quá số lượng sản phẩm thực tế
        }
        list = list.subList(startIndex, endIndex);

        // Thêm danh sách sản phẩm vào đối tượng Model với tên "items"
        model.addAttribute("items", list);

        // Hiển thị tên tiêu đề
        model.addAttribute("title", "Danh sách sản phẩm");

        // Hiển thị loại sản phẩm trên thanh NAVBAR
        List<Loaisanpham> listLoai = loaiSPService.findAll();
        model.addAttribute("loaiSP", listLoai);

        // Tính toán số trang và truyền vào Model
        int totalPages = (int) Math.ceil((double) totalItems / size);
        model.addAttribute("totalPages", totalPages);

        // Truyền vào Model trang hiện tại
        model.addAttribute("currentPage", page);

        return "/home/sanpham";
    }
}