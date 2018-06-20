package com.revature;

import com.revature.models.Animal;
import com.revature.models.Cat;
import com.revature.models.InterfaceImpl;

public class AbstractDriver {

	public static void main(String[] args) {
		
		Cat myCat = new Cat();
		Cat yourCat = new Cat(8, "sphinx");
		Cat hisCat = new Cat(5, "persian");
		Cat herCat = new Cat (2, "savannah", true);
		
		Animal myAnimal = new Cat();
		System.out.println(myCat.getBreed());
		System.out.println(yourCat.isHasFur());
		System.out.println(hisCat.isHasFur());
		herCat.makeSound();
		
		myAnimal.makeSound();
		
		InterfaceImpl implA = new InterfaceImpl(); 
		implA.doSomethingElse();
	}
	
	
}
