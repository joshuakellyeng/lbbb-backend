package com.lb.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lb.backend.models.Applicant;
import com.lb.backend.repositories.ApplicantRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/")
public class ApplicantController {

	@Autowired
	private ApplicantRepository applicantRepo;
	
	@GetMapping("allapplicants")
	public List<Applicant> getAllApplicants() {
		return applicantRepo.findAll();
	}
}
