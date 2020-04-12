package com.lawencon.covid.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lawencon.covid.model.Covid;
import com.lawencon.covid.service.CovidService;

@RestController
@RequestMapping("/covid")
@CrossOrigin("*")
public class CovidController extends BaseController<Covid> {

	
	@Autowired
	private CovidService covid_service;
	
	@GetMapping("/listcovid")
	public ResponseEntity<?> listCovids() {
		List<Covid> listCovid = new ArrayList<>();
		try {
			listCovid  = covid_service.viewCovid();
			return new ResponseEntity<>(listCovid, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listCovid, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/incovid")
	public ResponseEntity<?> insertCovid(@RequestBody String content) {
		String pesan = "";
		try {
			Covid covids = readValue(content, Covid.class);
			pesan  = covid_service.insertCovid(covids);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/upcovid")
	public ResponseEntity<?> updateCovid(@RequestBody String content) {
		String pesan = "";
		try {
			Covid covids = readValue(content, Covid.class);
			pesan  = covid_service.updateCovid(covids);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/delcovid")
	public ResponseEntity<?> deleteCovid(@RequestBody String content) {
		String pesan = "";
		try {
			Covid covids = readValue(content, Covid.class);
			pesan  = covid_service.deleteCovid(covids);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/viewall")
	public ResponseEntity<?> viewsALLCovid() {
		List<Integer> listCovid = new ArrayList<>();
		try {
			listCovid  = covid_service.viewsTotal();
			return new ResponseEntity<>(listCovid, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listCovid, HttpStatus.BAD_REQUEST);
		}
		
	}
}
