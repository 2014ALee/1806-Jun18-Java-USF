package answers.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import answers.Question8;

class Question8Test {

	@Test
	public void testPalidrone() {
		ArrayList<String> arr = new ArrayList<>();
		
		arr.add("bob");
		arr.add("phil");
		arr.add("lol");
		arr.add("hi");
		arr.add("Hih");
		
		ArrayList<String> palis = new ArrayList<>();
		
		palis.add("bob");
		palis.add("lol");
		palis.add("Hih");
		
		assertEquals(palis, Question8.sortPali(arr));
	}

}
