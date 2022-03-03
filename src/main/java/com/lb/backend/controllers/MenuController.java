package com.lb.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lb.backend.models.MenuItem;
import com.lb.backend.models.MenuItemCategory;
import com.lb.backend.repositories.MenuItemCategoryRepository;
import com.lb.backend.repositories.MenuItemsRepository;

@RestController
@RequestMapping("/api/v1/")
public class MenuController {
	
	@Autowired
	private MenuItemsRepository menuitemsRepo;
	
	@Autowired 
	private MenuItemCategoryRepository menuitemcategoryRepo;
	
	@GetMapping("allmenuitems")
	public List<MenuItemCategory> getAllMenuItemCategory(){
		return menuitemcategoryRepo.findAll();
	}
	
	@GetMapping("menuitem")
	public List<MenuItem> getAllMenuItems(){
		return menuitemsRepo.findAll();
	}

}
