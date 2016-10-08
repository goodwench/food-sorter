package com.offmadisonave.android.foodsorter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

/**
 * Created by lisak on 9/16/16.
 */
public class FoodPagerActivity extends AppCompatActivity {
    private static final String EXTRA_FOOD_ID =
            "com.offmadisonave.android.foodsorter.food_id";

    private ViewPager mViewPager;
    private List<Food> mFoods;

    public static Intent newIntent(Context packageContext, UUID foodId) {
        Intent intent = new Intent(packageContext, FoodPagerActivity.class);
        intent.putExtra(EXTRA_FOOD_ID, foodId);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_pager);

        UUID foodId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_FOOD_ID);

        mViewPager = (ViewPager) findViewById(R.id.activity_food_pager_view_pager);

        mFoods = FoodLab.get(this).getFoods();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {

            @Override
            public Fragment getItem(int position) {
                Food food = mFoods.get(position);
                return FoodFragment.newInstance(food.getId());
            }

            @Override
            public int getCount() {
                return mFoods.size();
            }
        });

        for (int i = 0; i < mFoods.size(); i++) {
            if (mFoods.get(i).getId().equals(foodId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }



    }
}
