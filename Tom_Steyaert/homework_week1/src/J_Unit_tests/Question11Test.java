package J_Unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import FloatVariables.OurFloatVariables;
import junit.framework.Assert;

public class Question11Test {

	@Test
	public void canAccessFloats() {
		OurFloatVariables floats = new OurFloatVariables();
		Assert.assertEquals("We check to see if we are getting the float 5 from our "
				+ "FloatVariables package",5, floats.float1, 0);
		
	}

}
