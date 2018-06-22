package com.revature.models;

public class Cat extends Animal {
	
	public int numberOfLives;
	private String breed;
	private boolean hasFur;
	
	public Cat(int numberOfLives, String breed, boolean hasFur) {
		super();
		this.numberOfLives = numberOfLives;
		this.breed = breed;
		this.hasFur = hasFur;
	}

	public Cat(int numberOfLives, String breed) {
		super();
		this.numberOfLives = numberOfLives;
		this.breed = breed;
		this.hasFur = breed.equalsIgnoreCase("sphinx") ? false : true;
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

	public boolean getHasFur() {
		return hasFur;
	}

	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result + (hasFur ? 1231 : 1237);
		result = prime * result + numberOfLives;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		if (hasFur != other.hasFur)
			return false;
		if (numberOfLives != other.numberOfLives)
			return false;
		return true;
	}

	@Override
	public void makeSound() {
		System.out.println("Meow!");
	}

}
