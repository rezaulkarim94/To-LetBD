package com.to_letbd.to_letbd;

/**
 * Created by jack on 6/11/2017.
 */

public class AddInformation {
    String contactNO;
    String mail;
    String name;
    String location;
    String Details;
    double latitude;
    double longlatutide;

    public double getLatitude(){
        return latitude;
    }
    public void  setLatitude(double latitude){
        this.latitude=latitude;
    }
    public double getLonglatutide(){
        return longlatutide;
    }
    public void  setLonglatutide(double longlatutide){
        this.latitude=longlatutide;
    }
    public String getContactNO() {
        return contactNO;
    }

    public void setContactNO(String contactNO) {
        this.contactNO = contactNO;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public AddInformation(String contactNO, String mail, String name, String location, String details,double latitude,double longlatutide) {
        this.contactNO = contactNO;
        this.mail = mail;
        this.name = name;
        this.location = location;
        this.Details = details;
        this.latitude=latitude;
        this.longlatutide=longlatutide;
    }
}
