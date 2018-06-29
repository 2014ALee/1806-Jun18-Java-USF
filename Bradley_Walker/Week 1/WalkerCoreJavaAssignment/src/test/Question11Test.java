package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Question11Test {
	
	@Test
	public void testRetrieveVars() {
		float[] vars = {3.14f, 2.7f};
		assertEquals("Testing variable retrieval", true, Arrays.equals(vars, Question11_2.VariableRetriever.retrieveVars()));
	}

}
