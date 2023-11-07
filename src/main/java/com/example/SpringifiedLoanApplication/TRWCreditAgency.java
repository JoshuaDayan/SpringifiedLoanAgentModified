package com.example.SpringifiedLoanApplication;

public class TRWCreditAgency implements ICreditAgency {
    int creditScore;
    public int getCreditScore(String ssn) {
        return creditScore;
    }

    public void setCreditScore(int creditScore){
        this.creditScore = creditScore;
    }
}
