package examen.inversionesYonaikerMorillo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import examen.inversionesYonaikerMorillo.requests.InvestmentRequest;
import examen.inversionesYonaikerMorillo.response.InvestmentResponse;
import examen.inversionesYonaikerMorillo.response.InvestmentResult;
import examen.inversionesYonaikerMorillo.response.InvestmentSummary;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("api/investment")
public class InvestmentController {
    @PostMapping
    public InvestmentResponse calculateInvestment(@RequestBody InvestmentRequest request) {
            double investmentAmount = request.getInvestmentAmount();
            double annualContribution = request.getAnnualContribution();
            double annualContributionIncrease = request.getAnnualContributionIncrease();
            int investmentYears = request.getInvestmentYears();
            double investmentReturn = request.getInvestmentReturn();

        if (investmentAmount <= 0 || annualContribution <= 0 || annualContributionIncrease < 0 || investmentYears <= 0 || investmentReturn < 0) {
            throw new HttpMessageNotReadableException("No es posible procesar su solicitud con los datos proporcionados.");
        }

        List<InvestmentResult> investmentResults = new ArrayList<>();
        double initialBalance = investmentAmount;

        for (int year = 0; year < investmentYears; year++) {
            InvestmentResult investmentResult = new InvestmentResult();
            investmentResult.setYear(year + 1);
            investmentResult.setInitialBalance(initialBalance);
            investmentResult.setContribution(annualContribution);

            if (year > 0) {
                double previousContribution = investmentResults.get(year - 1).getContribution();
                annualContribution = previousContribution * (1 + annualContributionIncrease / 100);
                investmentResult.setContribution(annualContribution);
                initialBalance = investmentResults.get(year - 1).getFinalBalance();
            }

            double investmentReturnPercentage = investmentReturn / 100;
            double investmentEarnings = (initialBalance + annualContribution) * investmentReturnPercentage;
            double finalBalance = initialBalance + annualContribution + investmentEarnings;

            investmentResult.setEarnings(investmentEarnings);
            investmentResult.setFinalBalance(finalBalance);

            investmentResults.add(investmentResult);
            initialBalance = finalBalance;
        }

        double finalBalance = investmentResults.get(investmentResults.size() - 1).getFinalBalance();
        double investmentProfit = finalBalance - investmentAmount - investmentResults.stream().mapToDouble(InvestmentResult::getContribution).sum();

        InvestmentSummary investmentSummary = new InvestmentSummary(finalBalance, investmentProfit);

        return new InvestmentResponse(investmentSummary, investmentResults);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("Error", "No es posible procesar su solicitud con los datos proporcionados.");
        return error;
    }
}