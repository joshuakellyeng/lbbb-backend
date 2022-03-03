package com.lb.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="burgerbattle")
public class BurgerBattleBurger {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String burgername;
	
	@Column 
	private String burgerdesc;
	
	@Column 
	private int burgerprice;
	
//	Getters and Setters 
	

	public int getId() {
		return id;
	}

	public String getBurgername() {
		return burgername;
	}

	public void setBurgername(String burgername) {
		this.burgername = burgername;
	}

	public String getBurgerdesc() {
		return burgerdesc;
	}

	public void setBurgerdesc(String burgerdesc) {
		this.burgerdesc = burgerdesc;
	}

	public int getBurgerprice() {
		return burgerprice;
	}

	public void setBurgerprice(int burgerprice) {
		this.burgerprice = burgerprice;
	}

	
	

	
	
}
