package com.sample.mvp.presenters;

import com.sample.mvp.data.models.AccountDetailsModel;
import com.sample.mvp.data.source.accounts.IAccountDataSource;
import com.sample.mvp.vpcontracts.IAccountDetailsContract;

/**
 * @author Ponsuyambu
 * @since 27/3/17.
 */

public class AccountDetailsPresenter implements IAccountDetailsContract.IAccountDetailsPresenter,IAccountDataSource.IAccountDetailsCallback {

    private IAccountDataSource accountsRepository;
    private IAccountDetailsContract.IAccountDetailsView accountDetailsView;

    public AccountDetailsPresenter(IAccountDataSource accountsRepository, IAccountDetailsContract.IAccountDetailsView accountDetailsView) {
        this.accountsRepository = accountsRepository;
        this.accountDetailsView = accountDetailsView;
    }

    @Override
    public void getAccountDetails(String accountNumber) {
        accountDetailsView.showProgressDialog();
        accountsRepository.getAccountDetails(accountNumber,this);
    }

    @Override
    public void onAccountDetailsReceived(AccountDetailsModel accountDetailsModel) {
        accountDetailsView.updateAccountBalance(accountDetailsModel.getAccountBalance());
        accountDetailsView.updateAccountName(accountDetailsModel.getAccountName());
        accountDetailsView.updateAccountNumber(accountDetailsModel.getAccountNumber());
        accountDetailsView.hideProgressDialog();
    }

    @Override
    public void onAccountDetailError() {
        accountDetailsView.showError();
        accountDetailsView.hideProgressDialog();
    }
}
