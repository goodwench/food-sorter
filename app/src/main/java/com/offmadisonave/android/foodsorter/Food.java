package com.offmadisonave.android.foodsorter;

import java.util.UUID;

/**
 * Created by lisak on 9/15/16.
 */
public class Food {
    private UUID mId;
    private String fId;
    private String mTitle;
    private String mServing;
    private String mCalories;
    private String mFat;
    private String mCholesterol;
    private String mSodium;
    private String mCarbs;
    private String mFiber;
    private String mSugars;
    private String mProtein;

    public Food() {
        //Generate Unique Identifier
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String toString() {
        return mTitle;
    }



    public String getfId() {
        return fId;
    }

    public void setfId(String fId) {
        this.fId = fId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getServing() {
        return mServing;
    }

    public void setServing(String serving) {
        mServing = serving;
    }

    public String getCalories() {
        return mCalories;
    }

    public void setCalories(String calories) {
        mCalories = calories;
    }

    public String getFat() {
        return mFat;
    }

    public void setFat(String fat) {
        mFat = fat;
    }

    public String getCholesterol() {
        return mCholesterol;
    }

    public void setCholesterol(String cholesterol) {
        mCholesterol = cholesterol;
    }

    public String getSodium() {
        return mSodium;
    }

    public void setSodium(String sodium) {
        mSodium = sodium;
    }

    public String getCarbs() {
        return mCarbs;
    }

    public void setCarbs(String carbs) {
        mCarbs = carbs;
    }

    public String getFiber() {
        return mFiber;
    }

    public void setFiber(String fiber) {
        mFiber = fiber;
    }

    public String getSugars() {
        return mSugars;
    }

    public void setSugars(String sugars) {
        mSugars = sugars;
    }

    public String getProtein() {
        return mProtein;
    }

    public void setProtein(String protein) {
        mProtein = protein;
    }



}
