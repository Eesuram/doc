package com.personal.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Privilege implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1321498696007393662L;

	@Id
	private Long id;
	private String name;
	private String description;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Privilege [id=" + id + ", name=" + name + ", description="
				+ description + "]";
	}
	
	
}
