package com.revature;

import com.revature.models.Animal;
import com.revature.models.Cat;
import com.revature.models.InterfaceA;
import com.revature.models.InterfaceImpl;

public class AbstractDriver {

	public static void main(String[] args) {
		Cat myCat = new Cat();
		Cat yourCat = new Cat(8,"Sphinx");
		Cat hisCat = new Cat (5, "Person");
		Cat herCat = new Cat (2, "Savannah", true);		
		
		
		//we get the fields of animal, and the methods of cat
		Animal myAnimal = new Cat();
		System.out.println(myCat.getBreed());
		System.out.println(yourCat.getHasFur());
		System.out.println(hisCat.getHasFur());
		herCat.makeSound();
		myAnimal.makeSound();
		
		InterfaceImpl implA = new InterfaceImpl();
	//	implA.doSomethingElse();
		
	//	InterfaceA implB = new InterfaceImpl();
	//	implB.doSomethingElse();
		
		
		
		
	}
	
}
