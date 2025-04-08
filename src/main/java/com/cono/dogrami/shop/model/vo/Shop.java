package com.cono.dogrami.shop.model.vo;

public class Shop implements java.io.Serializable{
    private static final long serialVersionUID = 2025877150326301535L;

    private int shop_no;
    private String site_name;
    private String site_url;
    private String site_image;
    private String site_image_rename;

    public Shop() {
    }

    public Shop(int shop_no, String site_name, String site_url, String site_image, String site_image_rename) {
        this.shop_no = shop_no;
        this.site_name = site_name;
        this.site_url = site_url;
        this.site_image = site_image;
        this.site_image_rename = site_image_rename;
    }

    public int getShop_no() {
        return shop_no;
    }

    public void setShop_no(int shop_no) {
        this.shop_no = shop_no;
    }

    public String getSite_name() {
        return site_name;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }

    public String getSite_url() {
        return site_url;
    }

    public void setSite_url(String site_url) {
        this.site_url = site_url;
    }

    public String getSite_image() {
        return site_image;
    }

    public void setSite_image(String site_image) {
        this.site_image = site_image;
    }

    public String getSite_image_rename() {
        return site_image_rename;
    }

    public void setSite_image_rename(String site_image_rename) {
        this.site_image_rename = site_image_rename;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shop_no=" + shop_no +
                ", site_name='" + site_name + '\'' +
                ", site_url='" + site_url + '\'' +
                ", site_image='" + site_image + '\'' +
                ", site_image_rename='" + site_image_rename + '\'' +
                '}';
    }
}
