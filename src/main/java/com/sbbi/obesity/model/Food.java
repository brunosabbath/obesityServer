package com.sbbi.obesity.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="food")
@NamedQuery(name="Food.findAll", query="SELECT f FROM Food f")
public class Food implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private double carbohydrate;

	private double cholesterol;

	private double energy;
	
	private double fattyAcidsMonounsaturated;
	
	private double fattyAcidsPolyunsaturated;

	private double fattyAcidsSaturated;

	private double fattyAcidTrans;

	private double fiber;

	private double lipid;

	private String name;

	private double protein;

	private double sugar;

	//bi-directional many-to-many association to Meal
	@ManyToMany
	@JoinTable(
		name="mealFood"
		, joinColumns={
			@JoinColumn(name="foodId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="mealId")
			}
		)
	private List<Meal> meals;

	public Food() {
	}

	public int getId() {
		return this.id;
	}

	public Food setId(int id) {
		this.id = id;
		return this;
	}

	public double getCarbohydrate() {
		return this.carbohydrate;
	}

	public Food setCarbohydrate(double carbohydrate) {
		this.carbohydrate = carbohydrate;
		return this;
	}

	public double getCholesterol() {
		return this.cholesterol;
	}

	public Food setCholesterol(double cholesterol) {
		this.cholesterol = cholesterol;
		return this;
	}

	public double getEnergy() {
		return this.energy;
	}

	public Food setEnergy(double energy) {
		this.energy = energy;
		return this;
	}

	public double getFattyAcidsMonounsaturated() {
		return this.fattyAcidsMonounsaturated;
	}

	public Food setFattyAcidsMonounsaturated(double fattyAcidsMonounsaturated) {
		this.fattyAcidsMonounsaturated = fattyAcidsMonounsaturated;
		return this;
	}

	public double getFattyAcidsPolyunsaturated() {
		return this.fattyAcidsPolyunsaturated;
	}

	public Food setFattyAcidsPolyunsaturated(double fattyAcidsPolyunsaturated) {
		this.fattyAcidsPolyunsaturated = fattyAcidsPolyunsaturated;
		return this;
	}

	public double getFattyAcidsSaturated() {
		return this.fattyAcidsSaturated;
	}

	public Food setFattyAcidsSaturated(double fattyAcidsSaturated) {
		this.fattyAcidsSaturated = fattyAcidsSaturated;
		return this;
	}

	public double getFattyAcidTrans() {
		return this.fattyAcidTrans;
	}

	public Food setFattyAcidTrans(double fattyAcidTrans) {
		this.fattyAcidTrans = fattyAcidTrans;
		return this;
	}

	public double getFiber() {
		return this.fiber;
	}

	public Food setFiber(double fiber) {
		this.fiber = fiber;
		return this;
	}

	public double getLipid() {
		return this.lipid;
	}

	public Food setLipid(double lipid) {
		this.lipid = lipid;
		return this;
	}

	public String getName() {
		return this.name;
	}

	public Food setName(String name) {
		this.name = name;
		return this;
	}

	public double getProtein() {
		return this.protein;
	}

	public Food setProtein(double protein) {
		this.protein = protein;
		return this;
	}

	public double getSugar() {
		return this.sugar;
	}

	public Food setSugar(double sugar) {
		this.sugar = sugar;
		return this;
	}

	public List<Meal> getMeals() {
		return this.meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
	
	public void changeAmountGrams(double grams){
		grams = grams / 100;
		this.energy *= grams;
		this.protein *= grams;
		this.lipid *= grams;
		this.carbohydrate *= grams;
		this.fiber *= grams;
		this.sugar *= grams;
		this.fattyAcidsSaturated *= grams;
		this.fattyAcidsMonounsaturated *= grams;
		this.fattyAcidsPolyunsaturated *= grams;
		this.fattyAcidTrans *= grams;
		this.cholesterol *= grams;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + 
				" energy: " + this.energy + 
				" protein: " + this.protein + 
				" lipids: " + this.lipid;
	}

}