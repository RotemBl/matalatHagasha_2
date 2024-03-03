package com.example.shoppingmanagmentapp.DataFile;

public class DataModle {
    private String itemName;
    private int quantity;
    private int image;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public DataModle(String itemName, int quantity, int image) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.image = image;
    }





}
