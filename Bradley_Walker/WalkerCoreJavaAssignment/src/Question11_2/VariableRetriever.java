package Question11_2;

import Question11_1.VariableContainer;

public class VariableRetriever {

	public static void main(String[] args) {
		float[] vars = retrieveVars();
		System.out.println(vars[0] + " " + vars[1]);
	}
	
	public static float[] retrieveVars() {
		float[] vars = {VariableContainer.pi, VariableContainer.e};
		return vars;
	}

}
