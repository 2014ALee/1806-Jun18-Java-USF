package com.revature;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class DatatxtTest {

	@Test
	public void test() {
		
		try {
			Datatxt.datatxt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
