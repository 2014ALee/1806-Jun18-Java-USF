package J_Unit_tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

import org.junit.Test;

import homework_week1.questions.Question20;

public class Question20Test {

	@Test(expected = FileNotFoundException.class)
	public void fileReadingDoesNotWork() throws FileNotFoundException, IOException {

	Question20.readFromFile("notOurData.txt");
		
	}

	@Test
	public void fileReadingWorks() throws FileNotFoundException, IOException {

	Question20.readFromFile("Data.txt");
		
	}


}
