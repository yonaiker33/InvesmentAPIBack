package examen.inversionesYonaikerMorillo.response;

public class InvestmentSummary {
    private double finalAmount;
    private double investmentProfit;

    public InvestmentSummary() {
    }

    public InvestmentSummary(double finalAmount, double investmentProfit) {
        this.finalAmount = finalAmount;
        this.investmentProfit = investmentProfit;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public double getInvestmentProfit() {
        return investmentProfit;
    }

    public void setInvestmentProfit(double investmentProfit) {
        this.investmentProfit = investmentProfit;
    }
}
