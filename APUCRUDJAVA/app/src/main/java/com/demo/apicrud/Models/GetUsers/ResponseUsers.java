package com.demo.apicrud.Models.GetUsers;


import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseUsers implements Serializable
{

    @SerializedName("demos")
    @Expose
    private List<Demo> demos = null;
    private final static long serialVersionUID = -6108136110501144114L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseUsers() {
    }

    /**
     *
     * @param demos
     */
    public ResponseUsers(List<Demo> demos) {
        super();
        this.demos = demos;
    }

    public List<Demo> getDemos() {
        return demos;
    }

    public void setDemos(List<Demo> demos) {
        this.demos = demos;
    }

}