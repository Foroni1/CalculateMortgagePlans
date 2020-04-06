package it.project.mortgage;

public interface MortgagePlan {
	
	//Get the list of all the instalments
	public void getMortgagePlan();
	
	//Get share interest in models with variable share interest
	public double getShareInterest(int numberOfResidualMonths);
	
	//Get share interest in models with fixed share interest
	public double getShareInterest();
	
	//Get share capital in models with variable share capital
	public double getShareCapital(int numberOfResidualMonths);
	
	//Get share capital in models with fixed share capital
	public double getShareCapital();
	
	//Get instalment in models with variable instalments
	public double getInstalment(int numberOfResidualMonths);
	
	//Get instalment in models with fixed instalments
	public double getInstalment();
	
	//Get the residual debt 
	public double getResidualDebt(int numberOfResidualMonths);
	
	//Get the maturity in years
	public double getMaturityYears();
	
	//Set the maturity in years
	public void setMaturityYears(double maturityYears);
	
	//Get the interest rate
	public double getInterestRate();
	
	//Set the interest rate
	public void setInterestRate(double interestRate);
	
	//Get the amount of the debt 
	public double getDebtAmount();
	
	//Set the amount of the debt
	public void setDebtAmount(double debtAmount);

}
