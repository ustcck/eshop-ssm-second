package com.taotao.portal.pojo;

import com.taotao.pojo.TbItem;

/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/22 0:47.
 */
public class ItemInfo extends TbItem {
    public String[] getImages() {
        String image = getImage();
        if (image != null) {
            String[] images = image.split(",");
            return images;
        }
        return null;
    }
}
