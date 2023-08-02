package com.poly.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entities.SanPham;

public interface SanphamDAO extends JpaRepository<SanPham, Integer> {
	// tìm theo tên sản phẩm
	Page<SanPham> findAllBytenSpLike(String keywords, Pageable pageable);
	    
    //sắp xếp sản phẩm theo giá giảm dần
    @Query("SELECT s FROM SanPham s WHERE s.tenSp LIKE %:tenSp% ORDER BY s.giaSp DESC")
    Page<SanPham> findAllBytenSpLikeOrderBygiaSpDesc(@Param("tenSp") String tenSp, Pageable pageable);
    @Query("SELECT s FROM SanPham s ORDER BY s.giaSp DESC")
    Page<SanPham> findAllByOrderBygiaSpDesc(Pageable pageable);

	@Query("SELECT s FROM SanPham s WHERE s.tenSp LIKE %:tenSp% AND s.loaisanpham.idLoai = :idLoai ORDER BY s.giaSp DESC")
	Page<SanPham> findAllBytenSpContainingAndLoaisanpham_idLoaiOrderBygiaSpDesc(@Param("tenSp") String tenSp, @Param("idLoai") Integer idLoai, Pageable pageable);

	@Query("SELECT s FROM SanPham s WHERE s.loaisanpham.idLoai = :idLoai ORDER BY s.giaSp DESC")
	Page<SanPham> findAllByLoaisanpham_idLoaiOrderBygiaSpDesc(@Param("idLoai") Integer idLoai, Pageable pageable);
    
	// sắp xếp sản phẩm theo giá tăng dần
	Page<SanPham> findAllBytenSpContainingAndLoaisanpham_IdLoaiOrderByGiaSpAsc(String tenSp, int idLoai, Pageable pageable);
	Page<SanPham> findAllByLoaisanpham_idLoaiOrderByGiaSpAsc(int idLoai, Pageable pageable);
	Page<SanPham> findAllByOrderByGiaSpAsc(Pageable pageable);
	Page<SanPham> findAllBytenSpContainingOrderByGiaSpAsc(String tenSp, Pageable pageable);
	Page<SanPham> findAllBytenSpContainingOrderByGiaSpDesc(String string, Pageable pageable);

//	SanPham findByIdSp(Integer idSp);
	

	
}
