package com.offmadisonave.android.foodsorter;

import android.support.v4.app.Fragment;

/**
 * Created by lisak on 9/15/16.
 */
public class FoodListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new FoodListFragment();
    }
}
