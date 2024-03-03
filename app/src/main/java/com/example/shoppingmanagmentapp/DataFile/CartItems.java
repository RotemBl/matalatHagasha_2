package com.example.shoppingmanagmentapp.DataFile;

public class CartItems {
    private String itemName;
    private int quantity;
    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public CartItems(String itemName, int quantity, int image) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.image = image;
    }

    // Getter and setter methods for itemName
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // Getter and setter methods for quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
