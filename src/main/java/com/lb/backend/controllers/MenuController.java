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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lb.backend.exception.ResourceNotFoundException;
import com.lb.backend.models.MenuItem;
import com.lb.backend.models.MenuItemCategory;
import com.lb.backend.repositories.MenuItemCategoryRepository;
import com.lb.backend.repositories.MenuItemsRepository;

@RestController
@CrossOrigin(origins = "https://lb-burgerbar.netlify.app")
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
	@GetMapping("allmenuitems/{id}")
	public ResponseEntity<MenuItem> getMenuItemById(@PathVariable int id) {
		MenuItem foundmenuitem = menuitemsRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Menu item not found."));
			return ResponseEntity.ok(foundmenuitem);
	}
	
	
	//Creates Menu Items
	@PostMapping("allmenuitems")
	public MenuItem createMenuItem(@RequestBody MenuItem menuitem) {
		return menuitemsRepo.save(menuitem);
	}
	
	//Updating Menu Items
	@PutMapping("allmenuitems/{id}")
	public ResponseEntity<MenuItem> updateMenuItem(@PathVariable int id, @RequestBody MenuItem newMenuItemInfo) {
		MenuItem foundMenuItem = menuitemsRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Menu item not found."));
		
		foundMenuItem.setMenuItemCategoryId(newMenuItemInfo.getMenuItemCategoryId());
		foundMenuItem.setItemname(newMenuItemInfo.getItemname());
		foundMenuItem.setItemdesc(newMenuItemInfo.getItemdesc());
		foundMenuItem.setItemprice(newMenuItemInfo.getItemprice());
		
		MenuItem updatedMenuItem = menuitemsRepo.save(foundMenuItem);
		
		return ResponseEntity.ok(updatedMenuItem);
		
	}
	
	
	//Deletes Menu Items
	@DeleteMapping("allmenuitems/{id}")
	public ResponseEntity<String> deleteMenuItem(@PathVariable int id) {
		//find menu item we want to delete
		menuitemsRepo.findById(id)
			.orElseThrow(()-> new ResourceNotFoundException("Menu Item Not Found."));
		
		String message = "Menu Item has been deleted.";
		
		menuitemsRepo.deleteById(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
		
	}

}
