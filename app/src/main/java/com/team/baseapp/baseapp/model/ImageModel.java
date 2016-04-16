package com.team.baseapp.baseapp.model;

import com.team.baseapp.baseapp.entity.Image;

/**
 * 处理图片 model
 * Created by lynnzc on 16-4-16.
 */
public class ImageModel {
    private Image image;

    public ImageModel(Image image) {
        this.image = image;
    }

    /**
     * 获取资源
     *
     * @param position
     * @return
     */
    public int getImageAt(int position) {
        if (!checkLists() && position < getImageCount()) {
            //不存在或者越界
            return 0;
        }
        //返回resId R.drawable.xxx etc.
        return image.getImages().get(position);
    }

    /**
     * 返回照片资源数量
     *
     * @return
     */
    public int getImageCount() {
        return checkLists() ? image.getImages().size() : 0;
    }

    public boolean checkImage() {
        return image != null;
    }

    public boolean checkLists() {
        return checkImage() && image.getImages() != null;
    }
}
