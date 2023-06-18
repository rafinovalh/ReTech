package com.rt.retech.model;



public class Products {
    private int id;
    private int seller_id;
    private String name;
    private String description;
    private double price;
    private Status_Products status_products;

    private boolean is_negotiable;

    /**
     * Get ID
     * @return id
     */
    public int getId(){
        return id;
    }

    /**
     * Get SELLER_ID
     * @return seller_id
     */
    public int getSeller_id(){
        return seller_id;
    }

    /**
     * Get NAME
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * Get DESCRIPTION
     * @return description
     */
    public String getDescription(){
        return description;
    }

    /**
     * Get PRICE
     */
    public double getPrice(){
        return price;
    }

    /**
     * Get STATUS_PRODUCTS
     * @return status_products
     */
    public Status_Products getStatus_products(){
        return status_products;
    }

    public boolean getIs_Negotiable(){return is_negotiable;}

    private String doubleToString(double price){
        return  String.valueOf(price);
    }
}
