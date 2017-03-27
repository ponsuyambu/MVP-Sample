package com.sample.mvp.vpcontracts;

/**
 * @author Ponsuyambu
 * @since 27/3/17.
 */

public interface IAccountDetailsContract {
    interface IAccountDetailsView {
        void showProgressDialog();
        void hideProgressDialog();
        void updateAccountNumber(String accountNumber);
        void updateAccountBalance(String balance);
        void updateAccountName(String accountName);
        void showError();
    }
    interface IAccountDetailsPresenter {
        void getAccountDetails(String accountNumber);
    }
}
