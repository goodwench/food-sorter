package com.offmadisonave.android.foodsorter;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class FoodListFragment extends Fragment {
    private static final String TAG = "FoodListFragment";
    private RecyclerView mFoodRecyclerView;
    private List<Food> mFoods = new ArrayList<>();
    private FoodAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        new FetchItemsTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
           Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_food_list, container, false);

        mFoodRecyclerView = (RecyclerView) view
                .findViewById(R.id.food_recycler_view);
        mFoodRecyclerView.setLayoutManager( new GridLayoutManager(getActivity(), 3));

        setupAdapter();

        return view;
    }

    private void setupAdapter() {
        if(isAdded()) {
            mFoodRecyclerView.setAdapter(new FoodAdapter(mFoods));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_food_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_new_food:
                Food food = new Food();
                FoodLab.get(getActivity()).addFood(food);
                Intent intent = FoodPagerActivity
                        .newIntent(getActivity(), food.getId());
                startActivity(intent);
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    private void updateUI() {
        FoodLab foodLab = FoodLab.get(getActivity());
        List<Food> foods = foodLab.getFoods();

        if(mAdapter == null) {
            mAdapter = new FoodAdapter(foods);
            mFoodRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }

    }

    private class FoodHolder extends RecyclerView.ViewHolder {

        private TextView mTitleTextView;
        private TextView mServingsTextView;
        private TextView mCaloriesTextView;
        private TextView mFatTextView;
        private TextView mCholesterolTextView;
        private TextView mSodiumTextView;
        private TextView mCarbsTextView;
        private TextView mFiberTextView;
        private TextView mSugarsTextView;
        private TextView mProteinTextView;


        public FoodHolder(View itemView) {
            super(itemView);

            mTitleTextView = (TextView) itemView;
            mServingsTextView = (TextView) itemView;
        }

        public void bindFoodItem(Food item) {
            mTitleTextView.setText(item.toString());
            
        }
    }

    private class FoodAdapter extends RecyclerView.Adapter<FoodHolder> {

        private List<Food> mFoods;

        public FoodAdapter(List<Food> foods) {
            mFoods = foods;
        }

        @Override
        public FoodHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            TextView textView = new TextView(getActivity());
            return new FoodHolder(textView);
        }

        @Override
        public void onBindViewHolder(FoodHolder foodHolder, int position) {
            Food foodItem = mFoods.get(position);
            foodHolder.bindFoodItem(foodItem);

        }

        @Override
        public int getItemCount() {
            return mFoods.size();
        }
    }

    private class FetchItemsTask extends AsyncTask<Void,Void, List<Food>> {
        @Override
        protected List<Food> doInBackground(Void... params) {
           return new FoodFetcher().fetchItems();



        }

        @Override
        protected void onPostExecute(List<Food> items) {
            mFoods = items;
            setupAdapter();
        }


    }

}
