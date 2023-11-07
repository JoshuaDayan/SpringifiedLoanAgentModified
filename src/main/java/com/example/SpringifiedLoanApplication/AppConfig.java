package com.example.SpringifiedLoanApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name="agency")
    public ICreditAgency getAgency() {
        ICreditAgency agency = new TRWCreditAgency();
        return agency;
    }

    @Bean(name="loanAgent")
    public LoanAgent setLoanAgent() {
        LoanAgent loanAgent = new LoanAgent();
        loanAgent.setAgency(getAgency());
        loanAgent.setMinimumCreditScore(600);
        return loanAgent;
    }
    
}
