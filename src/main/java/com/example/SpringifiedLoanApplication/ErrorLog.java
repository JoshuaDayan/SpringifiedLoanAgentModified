package com.example.SpringifiedLoanApplication;

public class ErrorLog implements IErrorLog{
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
