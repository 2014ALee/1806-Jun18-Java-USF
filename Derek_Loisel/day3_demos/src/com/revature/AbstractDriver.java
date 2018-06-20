package com.revature;

import com.revature.models.Animal;
import com.revature.models.Cat;
import com.revature.models.InterfaceA;
import com.revature.models.InterfaceB;
import com.revature.models.InterfaceImpl;

public class AbstractDriver {

	
	public static void main(String[] args) {
	
		Cat myCat = new Cat();
		Cat yourCat = new Cat(8, "sphinx");
		Cat hisCat = new Cat(5, "Persian");
		Cat herCat = new Cat(2, "savannah", true);
		
		Animal myAnimal = new Cat();
		
		System.out.println(myCat.getBreed());
		System.out.println(yourCat.isHasFur());
		System.out.println(hisCat.isHasFur());
		herCat.makeSound();
		
		myAnimal.makeSound(); // this gives us meowwwww too because it keeps the animal fields but gets the cat methods
		
		InterfaceImpl implA = new InterfaceImpl();
		implA.doSomethingElse();
		
		InterfaceA implB = new InterfaceImpl();
		implB.doSomethingElse();
		
		InterfaceImpl implC = new InterfaceImpl();
		implC.doSomething();
		
		InterfaceA implD = new InterfaceImpl();
		implD.doSomething();
		
		InterfaceB implE = new InterfaceImpl();
		implE.doSomethingCrazy();
		
		
		
	}
	
}

