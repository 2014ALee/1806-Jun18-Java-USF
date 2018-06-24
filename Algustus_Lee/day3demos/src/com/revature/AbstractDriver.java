package com.revature;
import com.revature.models.Animal;
import com.revature.models.Cat;
import com.revature.models.InterfaceA;
import com.revature.models.InterfaceImpl;
public class AbstractDriver {
	public static void main (String[] args)
	{
		Cat myCat = new Cat();
		Cat yourCat = new Cat(8, "Sphinx");
		Cat hisCat = new Cat(5, "Persian");
		Cat herCat = new Cat(2, "Savannah", true);
		
		Animal myAnimal = new Cat();
		
		System.out.println(myCat.getBreed());
		System.out.println(yourCat.isHasFur());
		System.out.println(hisCat.isHasFur());
		herCat.makeSound();
		
		myAnimal.makeSound();
		
		InterfaceImpl implA = new InterfaceImpl();
		implA.doSomethingElse();
		
		InterfaceA implB = new InterfaceImpl();
		implB.doSomething();
	}
}
