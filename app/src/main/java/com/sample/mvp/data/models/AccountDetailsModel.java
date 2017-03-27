package com.sample.mvp.data.models;

/**
 * @author Ponsuyambu
 * @since 27/3/17.
 */

public class AccountDetailsModel {
    private String accountName;
    private String accountNumber;
    private String accountBalance;

    public AccountDetailsModel(String accountName, String accountNumber, String accountBalance) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountBalance() {
        return accountBalance;
    }
}
