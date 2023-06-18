package com.rt.retech.model;

public class Buyer {
    private int id;
    private String username;
    private String password;
    private String email;
    private int phone;


    /**
     * Get ID
     * @return id
     */
    public int getId(){
        return id;
    }

    /**
     * Get USERNAME
     * @return username
     */
    public String getUsername(){
        return username;
    }

    /**
     * Get PASSWORD
     * @return password
     */
    public String getPassword(){
        return password;
    }

    /**
     * Get EMAIL
     * @return email
     */
    public String getEmail(){
        return email;
    }

    /**
     * Get PHONE
     * @return phone
     */
    public int getPhone(){
        return phone;
    }
}
