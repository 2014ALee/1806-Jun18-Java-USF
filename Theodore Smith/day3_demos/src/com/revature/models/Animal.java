package com.revature.models;

public abstract class Animal {
	
	public int numberOfLives = 1;
	
	public Animal() {
		System.out.println("Animal Constructor called!");
	
	}
	
	public abstract void makeSound();
	
	public void exist( ) {
		System.out.println("The animal exisiting ...);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Animal other = (Animal) obj;
		if (numberOfLives != other.numberOfLives)
			return false;
		return true;
	}
	
	
	

}
