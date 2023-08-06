package com.poly.RestAPIController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.poly.entity.Thuonghieu;
import com.poly.service.ThuongHieuService;

@CrossOrigin("*")
@RestController
@RequestMapping("/thuongHieu")
public class ThuongHieuRestAPIController {

	@Autowired
	ThuongHieuService thsvc;

	@GetMapping("{idTh}")
	public Thuonghieu getOne2(@PathVariable("idTh") Integer idTh) {
		return thsvc.findById(idTh);
	}

	@GetMapping("/list")
	public List<Thuonghieu> getAll(Model model) {
		return thsvc.findAll();
	}

	@GetMapping("/edit/{idTh}")
	public Thuonghieu getOne(@PathVariable("idTh") Integer idTh) {
		return thsvc.findById(idTh);
	}

	@PostMapping("/create")
	public Thuonghieu create(@RequestBody Thuonghieu thuonghieu) {
		return thsvc.create(thuonghieu);
	}

	@PutMapping("/update/{idTh}")
	public Thuonghieu update(@PathVariable("idTh") Integer idTh, @RequestBody Thuonghieu thuonghieu) {
		return thsvc.update(thuonghieu);
	}

	@DeleteMapping("/delete/{idTh}")
	public void delete(@PathVariable("idTh") Integer idTh) {
		thsvc.delete(idTh);
	}
}
