package it.project.mortgage;

public class TestMortgagePlan {

	public static void main(String[] args) {
		
		ItalianMortgagePlan italian = new ItalianMortgagePlan(10, 0.01, 100000);
		italian.getMortgagePlan();
		System.out.println(italian.getInstalment(5));
		
		//FrenchMortgagePlan french = new FrenchMortgagePlan(10, 0.01, 100000);
		//french.getMortgagePlan();
		//System.out.println(french.getInstalment());
		
		//GermanMortgagePlan german = new GermanMortgagePlan(10, 0.01, 100000);
		//german.getMortgagePlan();
		//System.out.println(german.getInstalment());
		
	}

}
