package com.demo.apicrud.Models.GetUserDetails;


import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseUserDetail implements Serializable
{

    @SerializedName("demo")
    @Expose
    private Demo demo;
    private final static long serialVersionUID = -369084168709555489L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseUserDetail() {
    }

    /**
     *
     * @param demo
     */
    public ResponseUserDetail(Demo demo) {
        super();
        this.demo = demo;
    }

    public Demo getDemo() {
        return demo;
    }

    public void setDemo(Demo demo) {
        this.demo = demo;
    }

}