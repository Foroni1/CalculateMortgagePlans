package it.project.mortgage;

import java.text.DecimalFormat;
import java.util.Formatter;

public class FrenchMortgagePlan extends AbstractMortgagePlan {
	
	private int maturityYears;
	private double interestRate;
	private double debtAmount;
	
	public FrenchMortgagePlan(int maturityYears, double interestRate, double debtAmount) {
		super();
		this.maturityYears = maturityYears;
		this.interestRate = interestRate;
		this.debtAmount = debtAmount;
	}
	
	public void getMortgagePlan() {
		
		DecimalFormat df = new DecimalFormat("####.##");
		Formatter f = new Formatter();
		
		System.out.println("French Mortage");
		System.out.println();
		System.out.printf("%-25s %-20s %-20s %-20s %-20s\n", 
				"Number of instalment", "Instalment",
				"Share capital", "Share Interest", "Residual debt");
		System.out.printf("%-25s %-20s %-20s %-20s %-20s\n", 
				0, 0, 0, 0, debtAmount);
		
		String instalment = df.format(getInstalment());
		
		double sum = 0;
		
		for(int i = 1; i <= maturityYears * 12; i++) {
			
			int numberOfResidualMonths = maturityYears * 12 - i + 1;
			
			String capital = df.format(getShareCapital(numberOfResidualMonths));
			String interest = df.format(getShareInterest(numberOfResidualMonths));
			String residual = df.format(getResidualDebt(numberOfResidualMonths));
			
			System.out.printf("%-25s %-20s %-20s %-20s %-20s\n", 
					i, instalment,
					capital, interest, residual);
			
		}

	}
	
	public double getShareInterest(int numberOfResidualInstalments) {
		double rate = Math.pow(1 + this.interestRate, 1.0/12.0) - 1;
		double shareInterest = getResidualDebt(numberOfResidualInstalments + 1) * rate;
		
		return shareInterest;
	}

	public double getShareCapital(int numberOfResidualInstalments) {
		double rate = Math.pow(1 + this.interestRate, 1.0/12.0) - 1;
		DiscountCurve dc = new DiscountCurve(rate);
		double shareCapital = getInstalment() * dc.getDiscountFactor(numberOfResidualInstalments);
		
		return shareCapital;
	}

	public double getInstalment() {
		
		double monthlyRate = Math.pow(1 + this.interestRate, 1.0/12.0) - 1;
		DiscountCurve dc = new DiscountCurve(monthlyRate);
		;
		double instalment = this.debtAmount * monthlyRate / (1 - dc.getDiscountFactor(this.maturityYears * 12));
		
		return instalment;
	}
	
	public double getResidualDebt(int numberOfResidualInstalments) {
		int monthsPassed = this.maturityYears * 12 - numberOfResidualInstalments; 
		double residualDebt = this.debtAmount;
		for(int i = 0; i <= monthsPassed; i++) {
			int currentResidualMonths = this.maturityYears * 12 - i;
			residualDebt = Math.abs(residualDebt - getShareCapital(currentResidualMonths));
		}
		
		return residualDebt;
	}
	
	public double getMaturityYears() {
		return maturityYears;
	}
	
	public void setMaturityYears(int maturityYears) {
		this.maturityYears = maturityYears;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public double getDebtAmount() {
		return debtAmount;
	}
	
	public void setDebtAmount(double debtAmount) {
		this.debtAmount = debtAmount;
	}

}

