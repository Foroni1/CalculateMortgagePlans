package it.project.mortgage;

import java.text.DecimalFormat;
import java.util.Formatter;

public class ItalianMortgagePlan extends AbstractMortgagePlan {
	
	private int maturityYears;
	private double interestRate;
	private double debtAmount;
	
	public ItalianMortgagePlan(int maturityYears, double interestRate, double debtAmount) {
		super();
		this.maturityYears = maturityYears;
		this.interestRate = interestRate;
		this.debtAmount = debtAmount;
	}
	
	public void getMortgagePlan() {
		
		DecimalFormat df = new DecimalFormat("####.##");
		Formatter f = new Formatter();
		
		System.out.println("Italian Mortage");
		System.out.println();
		System.out.printf("%-25s %-20s %-20s %-20s %-20s\n", 
				"Number of instalment", "Instalment",
				"Share capital", "Share Interest", "Residual debt");
		System.out.printf("%-25s %-20s %-20s %-20s %-20s\n", 
				0, 0, 0, 0, debtAmount);
		
		String share = df.format(getShareCapital());
		
		for(int i = 1; i <= maturityYears * 12; i++) {
			
			int numberOfResidualMonths = maturityYears * 12 + 1 - i;
			String instalment = df.format(getInstalment(numberOfResidualMonths));
			String interest = df.format(getShareInterest(numberOfResidualMonths));
			String residual = df.format(getResidualDebt(numberOfResidualMonths - 1));
			
			System.out.printf("%-25s %-20s %-20s %-20s %-20s\n", 
					i, instalment,
					share, interest, residual);
		}

	}
	
	public double getShareInterest(int numberOfResidualMonths) {
		double monthlyRate = Math.pow(1 + this.interestRate, 1.0 / 12.0) - 1;
		double shareInterest = numberOfResidualMonths * getShareCapital() * monthlyRate;
		
		return shareInterest;
	}

	public double getShareCapital() {
		double shareCapital = this.debtAmount / (this.maturityYears * 12);
		
		return shareCapital;
	}

	public double getInstalment(int numberOfResidualMonths) {
		double instalment = getShareInterest(numberOfResidualMonths) + getShareCapital();
		
		return instalment;
	}
	
	public double getResidualDebt(int numberOfResidualMonths) {
		double residualDebt = getShareCapital() * (numberOfResidualMonths - 1);
		
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
