package com.dichothue.phanhoi.controller;

import com.dichothue.phanhoi.repository.PhanHoi_NCC_Repository;
import com.dichothue.phanhoi.model.PhanHoi_NCC;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")

public class PhanHoi_NCC_Controller {

	@Autowired
	private PhanHoi_NCC_Repository phanhoiNCCRepository;
	
	@GetMapping("/phanhoincc")
	public List<PhanHoi_NCC> getAllPhanHoiNCC(){
		return phanhoiNCCRepository.findAll();
	}
	
	@GetMapping("/phanhoincc/{idncc}")
	public ResponseEntity<PhanHoi_NCC> getPhanHoiById(@PathVariable("id") int id){
		Optional<PhanHoi_NCC> phanhoi = phanhoiNCCRepository.findById(id);
		
		if(phanhoi.isPresent()) {
			return new ResponseEntity<>(phanhoi.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/phanhoincc")
	public PhanHoi_NCC createPhanHoiNCC(@Valid @RequestBody PhanHoi_NCC phanhoiNCC) {
		return phanhoiNCCRepository.save(phanhoiNCC);
	}
	
}

