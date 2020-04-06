package it.project.mortgage;

public class DiscountCurve {
	
	private double interestRate;

	public DiscountCurve(double interestRate) {
		super();
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	/*
	 * 
	 */
	public double getDiscountFactor(int months) {
		return Math.pow(1 + this.interestRate, -months);
	}

}