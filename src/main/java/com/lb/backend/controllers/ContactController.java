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
import com.lb.backend.models.Contact;
import com.lb.backend.repositories.ContactRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/")
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepo;
	
	@GetMapping("allcontacts")
	public List<Contact> getAllContacts() {
		return contactRepo.findAll();
	}
	
	@PostMapping("allcontacts")
	public Contact createContact(@RequestBody Contact contact) {
		return contactRepo.save(contact);
	}
	
	@DeleteMapping("allcontacts/{id}")
	public ResponseEntity<String> deleteContact(@PathVariable int id) {
		contactRepo.findById(id)
		.orElseThrow(()-> new ResourceNotFoundException("Contact Not Found."));
		
		String message = "Contact has been deleted.";
		
		contactRepo.deleteById(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
			
	}
}
