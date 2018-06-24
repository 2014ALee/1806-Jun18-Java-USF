package com.revature;

import com.revature.models.EagerSingleton;
import com.revature.models.LazyLockedSingleton;
import com.revature.models.LazySingleton;
import com.revature.models.OnDemandSingleton;

public class SingletonDriver {
	
	public static void main(String[] args) {

		System.out.println("+-------------------------------------------------------------+");
		System.out.println("+           SINGLETON DESIGN PATTERN IMPLEMENTATIONS          +");

		// LAZILY-INITIALIZED SINGLETON
		System.out.println("+-------------------------------------------------------------+");
		System.out.println("Lazily-initialized singleton (not thread-safe):\n");

		/* 
		 * This does not work! Since the no-args constructor for OnDemandSingleton
		 * class is marked as private. We instead must access it through the public
		 * getInstance() method.
		 */
		//LazySingleton ex1_1 = new LazySingleton();

		LazySingleton ex1_1 = LazySingleton.getInstance();
		LazySingleton ex1_2 = LazySingleton.getInstance();
		System.out.println("ex1_1 == ex1_2? " + (ex1_1 == ex1_2)); // prints true -> they are the same object!

		// Show the default value for both LazySingleton references (0)
		System.out.println("ex1_1.getValue() = " + ex1_1.getValue());
		System.out.println("ex1_2.getValue() = " + ex1_2.getValue());

		// Change 'value' using the public setter and see it reflect in both references
		ex1_1.setValue(10);
		System.out.println("ex1_1.getValue() = " + ex1_1.getValue());
		System.out.println("ex1_2.getValue() = " + ex1_2.getValue());


		//--------------------------------------------------------------------------------------------
		// LAZILY-INITIALIZED SINGLETON WITH DOUBLE CHECK LOCKING
		System.out.println("\n+-------------------------------------------------------------+");
		System.out.println("Lazily-initialized singleton with double check locking (thread-safe):\n");

		//LazyLockedSingleton ex1_1 = new LazyLockedSingleton();

		LazyLockedSingleton ex2_1 = LazyLockedSingleton.getInstance();
		LazyLockedSingleton ex2_2 = LazyLockedSingleton.getInstance();
		System.out.println("ex2_1 == ex2_2? " + (ex2_1 == ex2_2)); // prints true

		// Show the default value for both LazyLockedSingleton references (0)
		System.out.println("ex2_1.getValue() = " + ex2_1.getValue());
		System.out.println("ex2_2.getValue() = " + ex2_2.getValue());

		// Change 'value' using the public setter and see it reflect in both references
		ex2_1.setValue(100);
		System.out.println("ex2_1.getValue() = " + ex2_1.getValue());
		System.out.println("ex2_2.getValue() = " + ex2_2.getValue());


		//--------------------------------------------------------------------------------------------
		// EAGERLY-INITIALIZED SINGLETON
		System.out.println("\n+-------------------------------------------------------------+");
		System.out.println("Eagerly-initialized singleton (not thread-safe):\n");

		//LazySingleton ex3_1 = new EagerSingleton();

		EagerSingleton ex3_1 = EagerSingleton.getInstance();
		EagerSingleton ex3_2 = EagerSingleton.getInstance();
		System.out.println("ex3_1 == ex3_2? " + (ex3_1 == ex3_2)); // prints true

		// Show the default value for both LazyLockedSingleton references (0)
		System.out.println("ex3_1.getValue() = " + ex3_1.getValue());
		System.out.println("ex3_2.getValue() = " + ex3_2.getValue());

		// Change 'value' using the public setter and see it reflect in both references
		ex3_1.setValue(1000);
		System.out.println("ex3_1.getValue() = " + ex3_1.getValue());
		System.out.println("ex3_2.getValue() = " + ex3_2.getValue());


		//--------------------------------------------------------------------------------------------
		// INITIALIZATION-ON-DEMAND HOLDER IDIOM
		System.out.println("\n+-------------------------------------------------------------+");
		System.out.println("Initialization-on-demand holder idiom (thread-safe):\n");

		//OnDemandSingleton ex4 = new OnDemandSingleton();

		OnDemandSingleton ex4_1 = OnDemandSingleton.getInstance();
		OnDemandSingleton ex4_2 = OnDemandSingleton.getInstance();
		System.out.println("ex4_1 == ex4_2? " + (ex4_1 == ex4_2)); // prints true

		// Show the default value for both OnDemandSingleton references (0)
		System.out.println("ex4_1.getValue() = " + ex4_1.getValue());
		System.out.println("ex4_2.getValue() = " + ex4_2.getValue());

		// Change 'value' using the public setter and see it reflect in both references
		ex4_1.setValue(10000);
		System.out.println("ex4_1.getValue() = " + ex4_1.getValue());
		System.out.println("ex4_2.getValue() = " + ex4_2.getValue());

	}

}
