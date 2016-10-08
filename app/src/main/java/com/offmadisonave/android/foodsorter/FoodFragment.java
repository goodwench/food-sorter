package com.offmadisonave.android.foodsorter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by lisak on 9/15/16.
 */
public class FoodFragment extends Fragment {

    private static final String ARG_FOOD_ID = "food_id";
    private Food mFood;
    private EditText mTitleField;
    private EditText mServingField;
    private EditText mCaloriesField;
    private EditText mFatField;
    private EditText mCholesterolField;
    private EditText mSodiumField;
    private EditText mCarbsField;
    private EditText mFiberField;
    private EditText mSugarsField;
    private EditText mProteinField;

    public static FoodFragment newInstance(UUID foodId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_FOOD_ID, foodId);

        FoodFragment fragment = new FoodFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID foodId = (UUID) getArguments().getSerializable(ARG_FOOD_ID);
        mFood = FoodLab.get(getActivity()).getFood(foodId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_food, container, false);
        mTitleField = (EditText)v.findViewById(R.id.food_title);
        mTitleField.setText(mFood.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //This space intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                mFood.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //This one too
            }



        });

        mCaloriesField = (EditText)v.findViewById(R.id.food_calories);
        mCaloriesField.setText(mFood.getCalories());
        mCaloriesField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //This space intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                mFood.setCalories(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //This one too
            }



        });

        mServingField = (EditText)v.findViewById(R.id.food_serving);
        mServingField.setText(mFood.getServing());
        mServingField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //This space intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                mFood.setServing(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //This one too
            }
        });

        mFatField = (EditText)v.findViewById(R.id.food_fat);
        mFatField.setText(mFood.getFat());
        mFatField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //This space intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                mFood.setFat(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //This one too
            }
        });

        mCholesterolField = (EditText)v.findViewById(R.id.food_cholesterol);
        mCholesterolField.setText(mFood.getCholesterol());
        mCholesterolField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //This space intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                mFood.setCholesterol(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //This one too
            }
        });

        mSodiumField = (EditText)v.findViewById(R.id.food_sodium);
        mSodiumField.setText(mFood.getSodium());
        mSodiumField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //This space intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                mFood.setSodium(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //This one too
            }
        });

        mCarbsField = (EditText)v.findViewById(R.id.food_carbs);
        mCarbsField.setText(mFood.getCarbs());
        mCarbsField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //This space intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                mFood.setCarbs(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //This one too
            }
        });

        mFiberField = (EditText)v.findViewById(R.id.food_fiber);
        mFiberField.setText(mFood.getFiber());
        mFiberField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //This space intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                mFood.setFiber(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //This one too
            }
        });

        mSugarsField = (EditText)v.findViewById(R.id.food_sugars);
        mSugarsField.setText(mFood.getSugars());
        mSugarsField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //This space intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                mFood.setSugars(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //This one too
            }
        });

        mProteinField = (EditText)v.findViewById(R.id.food_protein);
        mProteinField.setText(mFood.getProtein());
        mProteinField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //This space intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                mFood.setProtein(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //This one too
            }
        });
        return v;




    }
}
