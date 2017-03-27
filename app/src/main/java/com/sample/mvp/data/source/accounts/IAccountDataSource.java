package com.sample.mvp.data.source.accounts;

import com.sample.mvp.data.models.AccountDetailsModel;

/**
 * @author Ponsuyambu
 * @since 27/3/17.
 */

public interface IAccountDataSource {

    public interface IAccountDetailsCallback {
        void onAccountDetailsReceived(AccountDetailsModel accountDetailsModel);
        void onAccountDetailError();

    }

    void getAccountDetails(String accountNumber,IAccountDetailsCallback callback);

    //Below are the addtional functionalities which has to be properly parametrized
    void getAllAccounts();
    void getAccountTransactions();
    void getAccountStatments();
}
