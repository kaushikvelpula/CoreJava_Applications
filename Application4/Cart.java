package com.evergent.CoreJAVA.kaushik.Application4;

class Cart {
    private String item;
    private int price;

    // Constructor for Cart
    public Cart() {
        this.item = "";
        this.price = 0;
    }

    public void setItem(String item, int price) {
        this.item = item;
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public int getPrice() {
        return price;
    }
}
