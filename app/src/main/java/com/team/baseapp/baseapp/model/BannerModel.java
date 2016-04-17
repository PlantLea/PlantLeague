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
    private ImageModel dotModel;

    public BannerModel() {
        initImage();
        initDot();
    }

    private void initImage() {
        Image image = new Image();
        image.setAvatar(R.mipmap.ic_launcher);
        image.setImages(getImages());
        imageModel = new ImageModel(image);
    }

    private void initDot() {
        Image image = new Image();
        image.setAvatar(R.mipmap.ic_launcher);
        image.setImages(getDots());
        dotModel = new ImageModel(image);
    }

    public ImageModel getImageModel() {
        return imageModel;
    }

    public void setImageModel(ImageModel imageModel) {
        this.imageModel = imageModel;
        //refresh dot
        initDot();
    }

    private List<Integer> getImages() {
        List<Integer> images = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            //TODO 加入轮播资源
            images.add(R.mipmap.ic_launcher);
        }
        return images;
    }

    /**
     * 根据image展现的数量, 加入dots
     *
     * @return
     */
    private List<Integer> getDots() {
        List<Integer> dots = new ArrayList<>();
        for (int i = 0; i < imageModel.getImageCount(); i++) {
            dots.add(R.drawable.selector_point);
        }
        return dots;
    }

    public int getImageCount() {
        return imageModel == null ? 0 : imageModel.getImageCount();
    }

    public int getDotCount() {
        return dotModel == null ? 0 : dotModel.getImageCount();
    }

    public int getImageAt(int position) {
        return imageModel == null ? 0 : imageModel.getImageAt(position);
    }

    public int getDotAt(int position) {
        return dotModel == null ? 0 : dotModel.getImageAt(position);
    }
}
