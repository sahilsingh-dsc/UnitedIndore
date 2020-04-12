package com.tetravalstartups.unitedindore.explore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tetravalstartups.unitedindore.R;
import com.tetravalstartups.unitedindore.explore.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    List<Category> categoryList;
    Context context;

    public CategoryAdapter(List<Category> categoryList, Context context) {
        this.categoryList = categoryList;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_item, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {
        Category category = categoryList.get(position);
        Glide.with(context).load(category.getCategory_image()).into(holder.ivCatImage);
        holder.tvCatName.setText(category.getCategory_name());
        holder.lvCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public void setfilter(ArrayList<Category> newCategoryList) {
        categoryList = new ArrayList<>();
        categoryList.addAll(newCategoryList);
        notifyDataSetChanged();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        LinearLayout lvCategory;
        ImageView ivCatImage;
        TextView tvCatName;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            lvCategory = itemView.findViewById(R.id.lvCategory);
            ivCatImage = itemView.findViewById(R.id.ivCatImage);
            tvCatName = itemView.findViewById(R.id.tvCatName);
        }
    }
}
