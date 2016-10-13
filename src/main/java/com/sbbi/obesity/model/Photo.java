package com.sbbi.obesity.model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the Photo database table.
 * 
 */
@Entity
@Table(name="photo")
@NamedQuery(name="Photo.findAll", query="SELECT p FROM Photo p")
public class Photo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String path;

	//bi-directional many-to-one association to Meal
	@ManyToOne
	@JoinColumn(name="mealId")
	private Meal meal;

	public Photo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Meal getMeal() {
		return this.meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

}