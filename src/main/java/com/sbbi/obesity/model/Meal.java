package com.sbbi.obesity.model;


import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the meal database table.
 * 
 */
@Entity
@Table(name="meal")
@NamedQuery(name="Meal.findAll", query="SELECT m FROM Meal m")
public class Meal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	//bi-directional many-to-one association to MealFood
	@OneToMany(mappedBy="meal")
	private List<MealFood> mealFoods;

	//bi-directional many-to-one association to Photo
	@OneToMany(mappedBy="meal")
	private List<Photo> photos;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to TypeMeal
	@ManyToOne
	@JoinColumn(name="type_meal")
	private TypeMeal typeMeal;

	public Meal() {
		mealFoods = new ArrayList<MealFood>();
		photos = new ArrayList<Photo>();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public Meal setDate(Date date) {
		this.date = date;
		return this;
	}

	public List<MealFood> getMealFoods() {
		return this.mealFoods;
	}

	public void setMealFoods(List<MealFood> mealFoods) {
		this.mealFoods = mealFoods;
	}

	public void addMealFood(List<MealFood> mealFoodList) {
		this.mealFoods = mealFoodList;
	}

	public MealFood removeMealFood(MealFood mealFood) {
		getMealFoods().remove(mealFood);
		mealFood.setMeal(null);

		return mealFood;
	}

	public List<Photo> getPhotos() {
		return this.photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public Photo addPhoto(Photo photo) {
		getPhotos().add(photo);
		photo.setMeal(this);

		return photo;
	}

	public Photo removePhoto(Photo photo) {
		getPhotos().remove(photo);
		photo.setMeal(null);

		return photo;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TypeMeal getTypeMeal() {
		return this.typeMeal;
	}

	public void setTypeMeal(TypeMeal typeMealBean) {
		this.typeMeal = typeMealBean;
	}

}