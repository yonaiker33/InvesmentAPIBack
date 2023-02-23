package examen.inversionesYonaikerMorillo.response;
import java.util.List;

public class InvestmentResponse {
    private InvestmentSummary investmentSummary;
    private List<InvestmentResult> investmentResults;

    public InvestmentResponse() {
    }

    public InvestmentResponse(InvestmentSummary investmentSummary, List<InvestmentResult> investmentResults) {
        this.investmentSummary = investmentSummary;
        this.investmentResults = investmentResults;
    }

    public InvestmentSummary getInvestmentSummary() {
        return investmentSummary;
    }

    public void setInvestmentSummary(InvestmentSummary investmentSummary) {
        this.investmentSummary = investmentSummary;
    }

    public List<InvestmentResult> getInvestmentResults() {
        return investmentResults;
    }

    public void setInvestmentResults(List<InvestmentResult> investmentResults) {
        this.investmentResults = investmentResults;
    }
}
