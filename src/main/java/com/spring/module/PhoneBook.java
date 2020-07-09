package com.spring.module;

import java.util.List;

public class PhoneBook {
    private int id;
    private String friendName;
    private String phoneNumber;
    private int phoneBookOwnerId;

    public PhoneBook() {
    }

    public PhoneBook(int id, String friendName, String phoneNumber, int phoneBookOwnerId) {
        this.id = id;
        this.friendName = friendName;
        this.phoneNumber = phoneNumber;
        this.phoneBookOwnerId = phoneBookOwnerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneBookOwnerId() {
        return phoneBookOwnerId;
    }

    public void setPhoneBookOwnerId(int phoneBookOwnerId) {
        this.phoneBookOwnerId = phoneBookOwnerId;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "id=" + id +
                ", friendName=" + friendName +
                ", phoneNumber=" + phoneNumber +
                ", phoneBookOwnerId=" + phoneBookOwnerId +
                '}';
    }
}
