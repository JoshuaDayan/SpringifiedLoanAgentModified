package com.example.SpringifiedLoanApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

@SpringBootApplication
public class SpringifiedLoanApplication {

	public static void main(String[] args) throws InvalidCreditScoreException {
		//	SpringApplication.run(SpringifiedLoanApplication.class, args);

		ArrayList<String> ssnList = new ArrayList<>();
		ssnList.add("111-11-1111");
		ssnList.add("222-22-2222");
		ssnList.add("333-33-3333");
		ssnList.add("444-44-4444");
		ssnList.add("555-55-5555");
		ssnList.add("999-99-9999");

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		LoanAgent loanAgent = applicationContext.getBean("loanAgent", LoanAgent.class);

		LoanApplication loanApplication = applicationContext.getBean("loanApplication", LoanApplication.class);
		for (String ssn : ssnList) {
			try {
				loanApplication.setSsn(ssn);
				boolean result = loanAgent.processLoanApplication(loanApplication);
			} catch (InvalidCreditScoreException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}