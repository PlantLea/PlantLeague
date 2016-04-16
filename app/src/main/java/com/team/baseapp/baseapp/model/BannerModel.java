package com.team.baseapp.baseapp.model;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.entity.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理轮播 model
 * Created by lynnzc on 16-4-16.
 */
public class BannerModel {
    private ImageModel imageModel;

    public BannerModel() {
        initImage();
    }

    private void initImage() {
        Image image = new Image();
        image.setAvatar("暂时没有");
        image.setImages(getImages());
        imageModel = new ImageModel(image);
    }

    public ImageModel getImageModel() {
        return imageModel;
    }

    public void setImageModel(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    private List<Integer> getImages() {
        List<Integer> images = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            //TODO 加入轮播资源
            images.add(R.mipmap.ic_launcher);
        }
        return images;
    }
}
