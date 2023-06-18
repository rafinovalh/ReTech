package com.rt.retech.model;

public class Transactions {
    private int id;
    private int product_id;
    private int buyer_id;
    private int seller_id;
    private double price_deal;

    /**
     * Get ID
     * @return id
     */
    public int getId(){
        return id;
    }

    /**
     * Get PRODUCT_ID
     * @return product_id
     */
    public int getProduct_id(){
        return product_id;
    }

    /**
     * Get BUYER_ID
     * @return buyer_id
     */
    public int getBuyer_id(){
        return buyer_id;
    }

    /**
     * Get SELLER_ID
     * @return seller_id
     */
    public int getSeller_id(){
        return seller_id;
    }

    /**
     * Get PRICE_DEAL
     * @return price_deal
     */
    public double getPrice_deal(){
        return price_deal;
    }

    private String doubleToString(double price_deal){
        return  String.valueOf(price_deal);
    }
}
