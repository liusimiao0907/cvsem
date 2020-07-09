package com.system.po;

import java.util.Date;

public class volunteerCustom {
    private Integer ID;
    private String name;
    private String gender;
    private String phone;
    private String id_card;
    private Date birthday;
    private Date checkin_date;
    private Date checkout_date;
    private String description;

    public Integer getID() {
        return ID;
    }
    public void setID(Integer id) {
        this.ID = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
