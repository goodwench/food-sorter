package com.offmadisonave.android.foodsorter;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by lisak on 9/15/16.
 */
public class FoodLab {
    private static FoodLab sFoodLab;

    private List<Food> mFoods;

    public static FoodLab get(Context context) {
        if (sFoodLab == null) {
            sFoodLab = new FoodLab(context);
        }
        return sFoodLab;
    }

    private FoodLab(Context context) {
        mFoods = new ArrayList<>();

        //Dummy foods. We'll remove these later
//        for (int i = 0; i < 100; i++) {
//            Food food = new Food();
//            food.setTitle("Food #" + i);
//            food.setCalories("10" + i + " cals");
//            mFoods.add(food);
//        }
    }

    public void addFood(Food f) {
        mFoods.add(f);
    }

    public List<Food> getFoods() {
        return mFoods;
    }

    public Food getFood(UUID id) {
        for (Food food : mFoods) {
            if (food.getId().equals(id)) {
                return food;
            }
        }
        return null;
    }
}
