package com.system.po;

import java.util.Date;

public class oldpersonCustom {
    private Integer ID;
    private String username;
    private String gender;
    private String phone;
    private String id_card;
    private Date birthday;
    private Date checkin_date;
    private Date checkout_date;
    private String room_number;

    public Integer getID() {
        return ID;
    }
    public void setID(Integer id) {
        this.ID = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getId_card() {
        return id_card;
    }
    public void setId_card(String idCard) {
        this.id_card = idCard;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public Date getCheckin_date() {
        return checkin_date;
    }
    public void setCheckin_date(Date checkinDate) {
        this.checkin_date = checkinDate;
    }
    public Date getCheckout_date() {
        return checkout_date;
    }
    public void setCheckout_date(Date checkoutDate) {
        this.checkout_date = checkoutDate;
    }
    public String getRoom_number() {
        return room_number;
    }
    public void setRoom_number(String roomNumber) {
        this.room_number = roomNumber;
    }
}
