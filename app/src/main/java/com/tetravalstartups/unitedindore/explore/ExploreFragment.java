package com.tetravalstartups.unitedindore.explore;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tetravalstartups.unitedindore.R;
import com.tetravalstartups.unitedindore.explore.model.Category;
import com.tetravalstartups.unitedindore.explore.presenter.CategoryPresenter;

import java.util.ArrayList;
import java.util.List;

public class ExploreFragment extends Fragment implements CategoryPresenter.Categories {

    private View view;
    private ProgressBar progressBar;
    private RecyclerView recyclerExplore;
    private CategoryPresenter categoryPresenter;
    private EditText etSearchCategory;
    private CategoryAdapter categoryAdapter;
    private ArrayList<Category> categoryArrayList;

    public ExploreFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_explore, container, false);
        init();
        return view;
    }

    private void init() {
        progressBar = view.findViewById(R.id.progressBar);
        recyclerExplore = view.findViewById(R.id.recyclerCategory);
        etSearchCategory = view.findViewById(R.id.etSearchCategory);
        recyclerExplore.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerExplore.setItemAnimator(new DefaultItemAnimator());
        recyclerExplore.setNestedScrollingEnabled(false);
        categoryPresenter = new CategoryPresenter(getContext(), ExploreFragment.this);
        categoryPresenter.fetchCategory();

        categoryArrayList = new ArrayList<>();

        etSearchCategory.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ArrayList<Category> categoryList = new ArrayList<>();
                for (Category category : categoryArrayList){
                    String cat_desc = category.getCategory_desc().toLowerCase().replace(" ", "");
                    if (cat_desc.contains(s))
                        categoryList.add(category);
                }
                categoryAdapter.setfilter(categoryList);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void success(ArrayList<Category> response) {
        categoryArrayList = response;
        categoryAdapter = new CategoryAdapter(response, getContext());
        categoryAdapter.notifyDataSetChanged();
        recyclerExplore.setAdapter(categoryAdapter);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void catSuccess(String response) {
    }

    @Override
    public void error(String response) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(getContext(), ""+response, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void fail(String response) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(getContext(), ""+response, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void noData(String response) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(getContext(), ""+response, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        categoryPresenter.fetchCategory();
    }

    @Override
    public void onResume() {
        super.onResume();
        categoryPresenter.fetchCategory();
    }
}
