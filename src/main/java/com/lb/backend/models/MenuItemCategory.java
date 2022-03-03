package com.lb.backend.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="menuitemcategory")
public class MenuItemCategory {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="itemcategory")
	private String itemcategory;
	
	@Column
	@OneToMany(targetEntity = MenuItem.class, cascade = CascadeType.ALL)
	@JoinColumn(name="menuitemcategory_id", referencedColumnName= "id")
	private List<MenuItem> menuitem;
	
	
	
//	Getters and Setters

	public String getItemcategory() {
		return itemcategory;
	}

	public void setItemcategory(String itemcategory) {
		this.itemcategory = itemcategory;
	}
	
	public List<MenuItem> getMenuItemList() {
		return menuitem;
	}

}
