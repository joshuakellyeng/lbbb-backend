package com.lb.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lb.backend.exception.ResourceNotFoundException;
import com.lb.backend.models.MenuItem;
import com.lb.backend.models.MenuItemCategory;
import com.lb.backend.repositories.MenuItemCategoryRepository;
import com.lb.backend.repositories.MenuItemsRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/")
public class MenuController {
	
	@Autowired 
	private MenuItemCategoryRepository menuitemcategoryRepo;
	
	@Autowired
	private MenuItemsRepository menuitemsRepo;
	
	//lists all items by category
	@GetMapping("allmenuitems")
	public List<MenuItemCategory> getAllMenuItemCategory(){
		return menuitemcategoryRepo.findAll();
	}
	
	//gets item by specific id
	@GetMapping("menuitem/{id}")
	public ResponseEntity<MenuItem> getMenuItemById(@PathVariable int id) {
		MenuItem foundmenuitem = menuitemsRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Menu item not found."));
			return ResponseEntity.ok(foundmenuitem);
	}

}
