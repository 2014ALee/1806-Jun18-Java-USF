package com.revature.utility.question.eighteen;

/*
 * Methods overriding the abstract class.
 * Used string methods because the problem did not
 * explicitly forbid this.
 */
public class OurConcreteClass extends OurAbstractClass {
	@Override
	public boolean hasUpperCase(String input) {
		return !input.equals(input.toLowerCase());
	}

	@Override
	public String makeUpperCase(String input) {
		return input.toUpperCase();
	}

	@Override
	public String printAddByTen(String input) {
		/*
		 * Handling non-integer inputs.
		 * Otherwise, parsing input as int to add
		 * by 10.
		 */
		try {
			int number = Integer.parseInt(input);
			number += 10;
			return "" + number;
		}
		// When user doesn't enter a proper number.
		catch (NumberFormatException e) {
			return "Unable to parse " + input
					+ " as int.";
		}

	}

}
