package com.tetravalstartups.unitedindore.explore.presenter;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.tetravalstartups.unitedindore.explore.model.Category;

import java.util.ArrayList;

public class CategoryPresenter {
    private Context context;
    private Categories categories;

    public CategoryPresenter(Context context, Categories categories) {
        this.context = context;
        this.categories = categories;
    }

    public interface Categories {
        void success (ArrayList<Category> response);

        void catSuccess (String response);

        void error (String response);

        void fail (String response);

        void noData (String response);
    }

    public void fetchCategory(){
        final ArrayList<Category> categoryList = new ArrayList<>();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Query query = db.collection("UI_EXPLORE_CATEGORY");
        query.orderBy("category_name", Query.Direction.ASCENDING).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            if (task.getResult() != null){
                                for (DocumentSnapshot snapshot : task.getResult()){
                                    com.tetravalstartups.unitedindore.explore.model.Category category = new com.tetravalstartups.unitedindore.explore.model.Category();
                                    category.setCategory_id(snapshot.getString("category_id"));
                                    category.setCategory_image(snapshot.getString("category_image"));
                                    category.setCategory_name(snapshot.getString("category_name"));
                                    category.setCategory_desc(snapshot.getString("category_desc"));
                                    categoryList.add(category);
                                    categories.success(categoryList);
                                }
                            } else {
                                categories.noData("Category Not Found");
                            }
                        } else {
                            categories.error("ECP_Q_UN :: Something went wrong. Please try after some time.");
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        categories.fail("ECP_Q_UN :: "+e.getMessage());
                    }
                });
    }

}
