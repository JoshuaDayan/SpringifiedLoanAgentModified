package com.example.SpringifiedLoanApplication;

public class LoanApplication implements ILoanApplication {

    String ssn;

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getSSN() {
        return ssn;
    }
}
