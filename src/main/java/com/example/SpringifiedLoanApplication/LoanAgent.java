package com.example.SpringifiedLoanApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("loanAgent")
public class LoanAgent {
    private ICreditAgency agency;
    private IErrorLog errorLog;

    @Value("${loan.minimumCreditScore}")
    private int minimumCreditScore;

    public LoanAgent() {
    }

    @Autowired
    public LoanAgent(ICreditAgency agency, IErrorLog errorLog) {
        this.agency = agency;
        this.errorLog = errorLog;
    }

    @Autowired(required = false)
    public void setAgency(ICreditAgency agency) {
        this.agency = agency;
    }

    @Autowired(required = false)
    public void setErrorLog(IErrorLog errorLog) {
        this.errorLog = errorLog;
    }


    public boolean processLoanApplication(ILoanApplication application) throws InvalidCreditScoreException {
        boolean response = false;
        String ssn = application.getSSN();
        int creditScore = agency.getCreditScore(ssn);

        if (creditScore < 200 || creditScore > 850) {
            errorLog.log(creditScore + " is not a valid credit score");
            throw new InvalidCreditScoreException(creditScore + " is not a valid credit score");
        }

        if (creditScore >= minimumCreditScore) {
            response = true;
        }



        return response;
    }

    public ICreditAgency getAgency() {
        return agency;
    }

    public int getMinimumCreditScore() {
        return minimumCreditScore;
    }

    public void setMinimumCreditScore(int minimumCreditScore) {
        this.minimumCreditScore = minimumCreditScore;
    }

    public IErrorLog getErrorLog() {
        return errorLog;
    }
}
