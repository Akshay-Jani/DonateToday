package com.example.shalin.donatetoday;

/**
 * Created by Shalin on 02-09-2018.
 */

public class User {

    private id _id;
    private String name;
    private String catagory;
    private String pname;
    private String bloodgroup;
    private String address;
    private String number;
    private String hnumber;
    public String himage;

    public id get_id() {return _id; }

    public void set_id(id _id) {
        this._id = _id;
    }


    public String getName() {return name; }

    public void setName(String name) {
        this.name = name;
    }


    public String getCatagory() {return catagory; }

    public void setCatagory(String catagory) { this.catagory = catagory; }

    public String getUname() {return pname; }

    public void setUname(String pname) { this.pname = pname; }

    public String getBgrp() {return bloodgroup; }

    public void setBgrp(String bloodgroup) { this.bloodgroup = bloodgroup; }

    public String getAddress() {return address; }

    public void setAddress(String address) { this.address = address; }

    public String getNumber() {return number; }

    public void setNumber(String number) { this.number = number; }

    public String getHnumber() {return hnumber; }

    public void setHnumber(String hnumber) { this.hnumber = hnumber; }

    public String getHimage() {return himage;}

    public void setHimage(String himage) {this.himage = himage;}

}
