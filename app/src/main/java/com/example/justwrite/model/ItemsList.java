package com.example.justwrite.model;

public class ItemsList {
    private  int mImage;
    private String mText1;
    private  String mText2;

    public ItemsList(int image, String text1, String text2){
        mImage = image;
        mText1 = text1;
        mText2 = text2;
    }

    public int getmImage() {
        return mImage;
    }
    public String getmText1(){
        return mText1;
    }
    public String getmText2(){
        return mText2;
    }

}

