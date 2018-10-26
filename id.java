package com.example.shalin.donatetoday;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Shalin on 23-07-2018.
 */

public class id {

    @SerializedName("$oid")
    private String oid;

    public String getoid() {
        return oid;
    }

    public void setoid(String oid) {
        this.oid = oid;
    }

}
