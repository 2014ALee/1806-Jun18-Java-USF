package com.revature;

import static com.revature.Question12.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class Question12Test {

	@Test
	public void testMain() {
		main(new String[0]);
		assertEquals("array[0] is 1", getValue(0), 1);
		assertEquals("array[8] is 9", getValue(8), 9);
		assertEquals("array[29] is 30", getValue(29), 30);
		assertEquals("array[76] is 77", getValue(76), 77);
		assertEquals("array[93] is 94", getValue(93), 94);
		assertEquals("Printed string is 2 through 50", "2\n4\n6\n8\n"
				+ "10\n12\n14\n16\n18\n20\n22\n24\n26\n28\n30\n32\n"
				+ "34\n36\n38\n40\n42\n44\n46\n48\n50\n52\n54\n56\n"
				+ "58\n60\n62\n64\n66\n68\n70\n72\n74\n76\n78\n80\n"
				+ "82\n84\n86\n88\n90\n92\n94\n96\n98\n100\n",
				getPrinted());
		System.out.println("Array stores ints in order");
	}
}
