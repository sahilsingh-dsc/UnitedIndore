package com.tetravalstartups.unitedindore.merchant.ledger;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tetravalstartups.unitedindore.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LedgerFragment extends Fragment {

    public LedgerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ledger, container, false);
    }
}
