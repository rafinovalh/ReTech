package com.rt.retech.model;

public class Bids {
    private int id;
    private int product_id;
    private int buyer_id;
    private double price_offered;
    private Status_Bids status_bids;

    /**
     * Get ID
     * @return id
     */
    public int getId(){
        return id;
    }

    /**
     * GET PRODUCT_ID
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
     * Get PRICE_OFFERED
     * @return price_offered
     */
    public double getPrice_offered(){
        return  price_offered;
    }

    /**
     * Get STATUS_BIDS
     * @return status_bids
     */
    public Status_Bids getStatus_bids(){
        return status_bids;
    }

    private String doubleToString(double price_offered){
        return  String.valueOf(price_offered);
    }
}
