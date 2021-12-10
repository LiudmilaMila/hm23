package com.speranskaya;

import java.time.LocalTime;

public class CallLog {
    private String contactName;
    private String phoneNumber;
    private LocalTime time;

    public CallLog(String contactName, String phoneNumber, LocalTime time) {
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
        this.time = time;
    }

    public String getContactName() {
        return contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalTime getTime() {
        return time;
    }

}
