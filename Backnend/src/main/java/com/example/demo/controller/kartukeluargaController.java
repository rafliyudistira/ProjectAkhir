package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.kartukeluargamodel;
import com.example.demo.service.IkartukeluargaService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/kartukeluarga")
public class kartukeluargaController {
	
	@Autowired
	IkartukeluargaService ikartukeluargaService;
	
	@PostMapping("/insert")
	public kartukeluargamodel insertKartukeluarga(@RequestBody kartukeluargamodel kartukeluarga) {
		return ikartukeluargaService.insertKartukeluarga(kartukeluarga);
	}
	@GetMapping("/getAll")
	public List<kartukeluargamodel> getaAllkartu(){
		return ikartukeluargaService.getAllkartu();
	}
	@PutMapping("/update/{id}")
	public kartukeluargamodel updateKartu(@PathVariable long id, @RequestBody kartukeluargamodel kartukeluarga) {
		return ikartukeluargaService.updateKartu(id, kartukeluarga);
	}
	@DeleteMapping("/delete/{id}")
	public kartukeluargamodel deleteKartu (@PathVariable long id) {
		return ikartukeluargaService.deleteKartu(id);
	}
	@GetMapping("/getKartuById/{id}")
	public kartukeluargamodel getKartuById (@PathVariable long id) {
		return ikartukeluargaService.getKartuById(id);
	}

}
