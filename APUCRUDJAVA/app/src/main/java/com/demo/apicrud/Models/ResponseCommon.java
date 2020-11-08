package com.demo.apicrud.Models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseCommon implements Serializable
{

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("variant")
    @Expose
    private String variant;
    private final static long serialVersionUID = 5351805815044342777L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseCommon() {
    }

    /**
     *
     * @param variant
     * @param message
     */
    public ResponseCommon(String message, String variant) {
        super();
        this.message = message;
        this.variant = variant;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

}