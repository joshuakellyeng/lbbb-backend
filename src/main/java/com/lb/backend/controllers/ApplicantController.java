package com.lb.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lb.backend.exception.ResourceNotFoundException;
import com.lb.backend.models.Applicant;
import com.lb.backend.repositories.ApplicantRepository;

@RestController
@CrossOrigin(origins = "https://lb-burgerbar.netlify.app")
@RequestMapping("/api/v1/")
public class ApplicantController {

	@Autowired
	private ApplicantRepository applicantRepo;
	
	@GetMapping("allapplicants")
	public List<Applicant> getAllApplicants() {
		return applicantRepo.findAll();
	}
	
	@PostMapping("allapplicants")
	public Applicant createApplicant(@RequestBody Applicant applicant) {
		return applicantRepo.save(applicant);
	}
	
	@DeleteMapping("allapplicants/{id}")
	public ResponseEntity<String> deleteApplicant(@PathVariable int id) {
		applicantRepo.findById(id)
		.orElseThrow(()-> new ResourceNotFoundException("Applicant Not Found."));
		
		String message = "Applicant has been deleted.";
		
		applicantRepo.deleteById(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
			
	}
}
