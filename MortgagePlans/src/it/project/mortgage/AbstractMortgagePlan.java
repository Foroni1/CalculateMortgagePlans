package it.project.mortgage;

public abstract class AbstractMortgagePlan implements MortgagePlan {

	@Override
	public void getMortgagePlan() {

	}

	public double getShareInterest(int numberOfResidualMonths) {
		return 0;
	}

	@Override
	public double getShareInterest() {
		return 0;
	}

	public double getShareCapital(int numberOfResidualMonths) {
		return 0;
	}

	@Override
	public double getShareCapital() {
		return 0;
	}

	public double getInstalment(int numberOfResidualMonths) {
		return 0;
	}

	@Override
	public double getInstalment() {
		return 0;
	}

	public double getResidualDebt(int numberOfResidualMonths) {
		return 0;
	}

	public double getMaturityYears() {
		return 0;
	}

	public void setMaturityYears(double maturityYears) {

	}

	public double getInterestRate() {
		return 0;
	}

	public void setInterestRate(double interestRate) {

	}

	public double getDebtAmount() {
		return 0;
	}

	public void setDebtAmount(double debtAmount) {

	}

}
