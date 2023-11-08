package com.example.SpringifiedLoanApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Bean(name = "errorLog")
    public ErrorLog getErrorLog() {
        ErrorLog errorLog = new ErrorLog();
        return errorLog;

    }

    @Bean(name = "loanApplication")
    public LoanApplication getLoanApplication() {
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setSsn("111-11-1111");
        return loanApplication;
    }

    @Bean(name = "agency")
    public ICreditAgency getAgency() {
        CreditAgency agency = new CreditAgency();
        return agency;
    }

    @Bean(name = "loanAgent")
    public LoanAgent setLoanAgent() {
        LoanAgent loanAgent = new LoanAgent();
        loanAgent.setAgency(getAgency());
        loanAgent.setMinimumCreditScore(600);
        loanAgent.setErrorLog(getErrorLog());
        return loanAgent;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();

    }
}
