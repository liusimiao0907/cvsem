package com.system.po;

import java.util.Date;

public class employeeCustom {
    private Integer ID;
    private String username;
    private String gender;
    private String phone;
    private String id_card;
    private Date birthday;
    private Date hire_date;
    private Date resign_date;
    private String description;

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

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public Date getResign_date() {
        return resign_date;
    }

    public void setResign_date(Date resign_date) {
        this.resign_date = resign_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
