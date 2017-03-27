package com.sample.mvp.presenters;

import com.sample.mvp.data.models.AccountDetailsModel;
import com.sample.mvp.data.source.accounts.IAccountDataSource;
import com.sample.mvp.vpcontracts.IAccountDetailsContract;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.eq;

/**
 * @author Ponsuyambu
 * @since 27/3/17.
 */


public class AccountsDetailsPresenterTest {
    private AccountDetailsPresenter presenter;//Object to be tested

    @Mock
    private IAccountDataSource dataSource;

    @Mock
    private IAccountDetailsContract.IAccountDetailsView accountDetailsView;

    @Mock
    private AccountDetailsModel accountDetailsModel;

    @Captor
    private ArgumentCaptor<IAccountDataSource.IAccountDetailsCallback> mIAccountDetailsCallback;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Mockito.when(accountDetailsModel.getAccountBalance()).thenReturn("EUR 400");
        Mockito.when(accountDetailsModel.getAccountName()).thenReturn("Pons");
        Mockito.when(accountDetailsModel.getAccountNumber()).thenReturn("BE12345");
        presenter = new AccountDetailsPresenter(dataSource,accountDetailsView);
    }
    @Test
    public void getAccountDetails_ProgressDialogShown(){
        presenter.getAccountDetails("1234567890");
        Mockito.verify(accountDetailsView).showProgressDialog();
    }

    @Test
    public void getAccountDetails_ProgressDialogHidden(){
        presenter.getAccountDetails("1234567890");
        Mockito.verify(dataSource).getAccountDetails(eq("1234567890"),mIAccountDetailsCallback.capture());
        mIAccountDetailsCallback.getValue().onAccountDetailsReceived(accountDetailsModel);
        Mockito.verify(accountDetailsView).hideProgressDialog();
    }

    @Test
    public void getAccountDetails_AccountBalanceShown(){
        presenter.getAccountDetails("1234567890");
        Mockito.verify(dataSource).getAccountDetails(eq("1234567890"),mIAccountDetailsCallback.capture());
        mIAccountDetailsCallback.getValue().onAccountDetailsReceived(accountDetailsModel);
        Mockito.verify(accountDetailsView).updateAccountBalance(eq(accountDetailsModel.getAccountBalance()));
    }
}
