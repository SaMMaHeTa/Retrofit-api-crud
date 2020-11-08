package com.demo.apicrud.Models.GetUserDetails;


import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Demo implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("contact")
    @Expose
    private String contact;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    private final static long serialVersionUID = -4745466553804583280L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Demo() {
    }

    /**
     *
     * @param createdAt
     * @param city
     * @param contact
     * @param name
     * @param id
     * @param updatedAt
     */
    public Demo(Integer id, String name, String contact, String city, String createdAt, String updatedAt) {
        super();
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.city = city;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
