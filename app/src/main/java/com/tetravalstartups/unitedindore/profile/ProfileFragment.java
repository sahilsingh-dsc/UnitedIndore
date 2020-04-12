package com.tetravalstartups.unitedindore.profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tetravalstartups.unitedindore.R;
import com.tetravalstartups.unitedindore.merchant.BusinessMainActivity;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    private View view;
    private LinearLayout lhMyAccount;
    private String lhExpand = "unexpanded";
    private ImageView ivDropDown;
    private View divMyAccount;
    private LinearLayout lvMyAccountHider;
    private LinearLayout lhBecomeMerchant;

    public ProfileFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        init();
        return view;
    }

    private void init() {
        lhMyAccount = view.findViewById(R.id.lhMyAccount);
        ivDropDown = view.findViewById(R.id.ivDropDown);
        divMyAccount = view.findViewById(R.id.divMyAccount);
        lvMyAccountHider = view.findViewById(R.id.lvMyAccountHider);
        lhBecomeMerchant = view.findViewById(R.id.lhBecomeMerchant);

        lhMyAccount.setOnClickListener(this);
        lhBecomeMerchant.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == lhMyAccount){
            if (lhExpand.equals("expanded")){
                ivDropDown.setImageResource(R.drawable.ic_expand_more_black_24dp);
                divMyAccount.setBackgroundColor(getResources().getColor(R.color.colorBlack));
                lvMyAccountHider.setVisibility(View.GONE);
                lhExpand = "unexpanded";
            } else {
                ivDropDown.setImageResource(R.drawable.ic_expand_less_black_24dp);
                divMyAccount.setBackgroundColor(getResources().getColor(R.color.colorDividerShadeV2));
                lvMyAccountHider.setVisibility(View.VISIBLE);
                lhExpand = "expanded";
            }
        }

        if (v == lhBecomeMerchant){
            startActivity(new Intent(getContext(), BusinessMainActivity.class));
        }

    }
}