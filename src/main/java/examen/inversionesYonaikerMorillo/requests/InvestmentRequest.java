package examen.inversionesYonaikerMorillo.requests;

public class InvestmentRequest {

    private double investmentAmount;
    private double annualContribution;
    private double annualContributionIncrease;
    private int investmentYears;
    private double investmentReturn;

    public double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public double getAnnualContribution() {
        return annualContribution;
    }

    public void setAnnualContribution(double annualContribution) {
        this.annualContribution = annualContribution;
    }

    public double getAnnualContributionIncrease() {
        return annualContributionIncrease;
    }

    public void setAnnualContributionIncrease(double annualContributionIncrease) {
        this.annualContributionIncrease = annualContributionIncrease;
    }

    public int getInvestmentYears() {
        return investmentYears;
    }

    public void setInvestmentYears(int investmentYears) {
        this.investmentYears = investmentYears;
    }

    public double getInvestmentReturn() {
        return investmentReturn;
    }

    public void setInvestmentReturn(double investmentReturn) {
        System.out.println("A: " + investmentReturn);
        this.investmentReturn = investmentReturn;
    }
}
