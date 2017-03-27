package com.sample.mvp.views;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sample.mvp.R;
import com.sample.mvp.data.source.accounts.AccountsRepository;
import com.sample.mvp.databinding.BindingAccountDetails;
import com.sample.mvp.presenters.AccountDetailsPresenter;
import com.sample.mvp.vpcontracts.IAccountDetailsContract;

/**
 * @author Ponsuyambu
 * @since 27/3/17.
 */

public class AccountDetailsFragment extends Fragment implements IAccountDetailsContract.IAccountDetailsView {

    private BindingAccountDetails binding;
    private ProgressDialog dialog;
    private IAccountDetailsContract.IAccountDetailsPresenter accountDetailsPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("Loading data...");
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        accountDetailsPresenter = new AccountDetailsPresenter(new AccountsRepository(),this);
        accountDetailsPresenter.getAccountDetails("12345678");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account_details,container,false);
        return binding.getRoot();
    }

    @Override
    public void showProgressDialog() {
        dialog.show();
    }

    @Override
    public void hideProgressDialog() {
        dialog.hide();
    }

    @Override
    public void updateAccountNumber(String accountNumber) {
        binding.tvAccountNumber.setText(accountNumber);
    }

    @Override
    public void updateAccountBalance(String balance) {
        binding.tvAccountBalance.setText(balance);
    }

    @Override
    public void updateAccountName(String accountName) {
        binding.tvAccountName.setText(accountName);
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), "Error occurred ", Toast.LENGTH_SHORT).show();
    }
}
