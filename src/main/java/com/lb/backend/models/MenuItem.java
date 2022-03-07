package com.lb.backend.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menuitems")
public class MenuItem {
	
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="menuitemcategory_id")
	private int menuitemcategory_id;
	@Column(name="itemname")
	private String itemname;
	@Column(name="itemdesc")
	private String itemdesc;
	@Column(name="itemprice")
	private int itemprice;
	
//	Getters and Setters
	
	public int getId() {
		return id;
	}
	
	public void setMenuItemCategoryId(int menuitemcategory_id) {
		this.menuitemcategory_id = menuitemcategory_id;
	}
	
	public int getMenuItemCategoryId() {
		return menuitemcategory_id;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	
	public String getItemdesc() {
		return itemdesc;
	}

	public void setItemdesc(String itemdesc) {
		this.itemdesc = itemdesc;
	}

	public int getItemprice() {
		return itemprice;
	}

	public void setItemprice(int itemprice) {
		this.itemprice = itemprice;
	}

	
}
