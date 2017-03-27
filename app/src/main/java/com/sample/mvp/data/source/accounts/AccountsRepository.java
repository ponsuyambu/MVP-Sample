package com.sample.mvp.data.source.accounts;

import android.os.AsyncTask;

import com.sample.mvp.data.models.AccountDetailsModel;

/**
 * @author Ponsuyambu
 * @since 27/3/17.
 */

public class AccountsRepository implements IAccountDataSource {


    AsyncTask asyncTask;

    @Override
    public void getAccountDetails(String accountNumber, final IAccountDataSource.IAccountDetailsCallback callback) {
        //Does the network call and returns the data.

        //To simulate, I simply used async task here.
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                AccountDetailsModel model = new AccountDetailsModel("Ponsuyambu Velladurai","BE12 3456 7890 1234","EUR 400");
                callback.onAccountDetailsReceived(model);
            }
        }.execute();
    }

    @Override
    public void getAllAccounts() {

    }

    @Override
    public void getAccountTransactions() {

    }

    @Override
    public void getAccountStatments() {

    }
}
