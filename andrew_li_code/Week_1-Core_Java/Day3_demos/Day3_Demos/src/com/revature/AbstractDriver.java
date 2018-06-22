package com.revature;

import com.revature.models.*;

public class AbstractDriver {
	public static void main(String[] args) {
		Cat cat = new Cat(9, "Kitten");
		Cat cat2 = new Cat(8, "Big Cat");
	
		Animal cat3 = new Animal() {
			@Override
			public void makeSound() {
				System.out.println("Hisssss!!!");
			}
		
		};
		Animal cat4 = new Cat(7, "Kat");
		System.out.println(cat4.numberOfLives);
		System.out.println((
				(Cat) cat4).numberOfLives);
		InterfaceImpl implA = new InterfaceImpl();
		implA.doSomethingElse();
	}

}
