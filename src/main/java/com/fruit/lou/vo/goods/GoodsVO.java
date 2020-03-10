package com.fruit.lou.vo.goods;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-03-01 16:43
 */
public class GoodsVO {

    private int id;

    private String name;

    private float originalPrice;

    private float price;

    private String pic;

    private String subTitle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("original_price")
    public float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(float originalPrice) {
        this.originalPrice = originalPrice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @JsonProperty("sub_title")
    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
