package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.SanPham;

public interface SanphamDAO extends JpaRepository<SanPham, Integer> {
	// tìm theo tên sản phẩm
//	Page<SanPham> findAllBytenSpLike(String keywords, Pageable pageable);
//	    
//    //sắp xếp sản phẩm theo giá giảm dần
//    @Query("SELECT s FROM SanPham s WHERE s.tenSp LIKE %:tenSp% ORDER BY s.giaSp DESC")
//    Page<SanPham> findAllBytenSpLikeOrderBygiaSpDesc(@Param("tenSp") String tenSp, Pageable pageable);
//    @Query("SELECT s FROM SanPham s ORDER BY s.giaSp DESC")
//    Page<SanPham> findAllByOrderBygiaSpDesc(Pageable pageable);
//
//	@Query("SELECT s FROM SanPham s WHERE s.tenSp LIKE %:tenSp% AND s.loaisanpham.idLoai = :idLoai ORDER BY s.giaSp DESC")
//	Page<SanPham> findAllBytenSpContainingAndLoaisanpham_idLoaiOrderBygiaSpDesc(@Param("tenSp") String tenSp, @Param("idLoai") Integer idLoai, Pageable pageable);
//
//	@Query("SELECT s FROM SanPham s WHERE s.loaisanpham.idLoai = :idLoai ORDER BY s.giaSp DESC")
//	Page<SanPham> findAllByLoaisanpham_idLoaiOrderBygiaSpDesc(@Param("idLoai") Integer idLoai, Pageable pageable);
//    
//	// sắp xếp sản phẩm theo giá tăng dần
//	Page<SanPham> findAllBytenSpContainingAndLoaisanpham_IdLoaiOrderByGiaSpAsc(String tenSp, int idLoai, Pageable pageable);
//	Page<SanPham> findAllByLoaisanpham_idLoaiOrderByGiaSpAsc(int idLoai, Pageable pageable);
//	Page<SanPham> findAllByOrderByGiaSpAsc(Pageable pageable);
//	Page<SanPham> findAllBytenSpContainingOrderByGiaSpAsc(String tenSp, Pageable pageable);
//	Page<SanPham> findAllBytenSpContainingOrderByGiaSpDesc(String string, Pageable pageable);

	@Query("SELECT sp FROM SanPham sp WHERE sp.loaisanpham.idLoai=?1")
	List<SanPham> findByLoaisanphamId(Integer cid);
	
}
