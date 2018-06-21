package com.revature.models;

public class Cat extends Animal{

	private int numberOfLives;
	private String breed;
	private Boolean hasFur;
	
	public Cat() {
		this.numberOfLives = 9;
		this.breed = "Domestic Shorthair";
		this.hasFur = true;
	}
	
	public Cat(int numberOfLives, String breed) {
		this.numberOfLives = numberOfLives;
		this.breed = breed;
		
		if(breed.equalsIgnoreCase("Sphinx")) {
			this.hasFur=false;
		} else {
			this.hasFur=true;
		}
		
		//ternary operator for simple if/else statements
		//this.hasFur = (breed.equalsIgnoreCase("Sphinx")) ? false : true;
		
	}
	
	public Cat(int numberOfLives, String breed, Boolean hasFur) {
		super(); //not required since it's implied
		this.numberOfLives = numberOfLives;
		this.breed = breed;
		this.hasFur = hasFur;
	}

	public int getNumberOfLives() {
		return numberOfLives;
	}

	public void setNumberOfLives(int numberOfLives) {
		this.numberOfLives = numberOfLives;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Boolean getHasFur() {
		return hasFur;
	}

	public void setHasFur(Boolean hasFur) {
		this.hasFur = hasFur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result + ((hasFur == null) ? 0 : hasFur.hashCode());
		result = prime * result + numberOfLives;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		if (hasFur == null) {
			if (other.hasFur != null)
				return false;
		} else if (!hasFur.equals(other.hasFur))
			return false;
		if (numberOfLives != other.numberOfLives)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cat [numberOfLives=" + numberOfLives + ", breed=" + breed + ", hasFur=" + hasFur + "]";
	}

	@Override
	public void makeSound() {
		System.out.println("Meow");	
	}
	
	
	
	
}
