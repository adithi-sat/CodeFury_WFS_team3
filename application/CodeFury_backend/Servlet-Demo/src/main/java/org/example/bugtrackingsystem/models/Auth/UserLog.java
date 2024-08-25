package org.example.bugtrackingsystem.models.Auth;

import java.util.Date;

public class UserLog {
    private String userId;
    private String logDate;

    public UserLog(String userId, String logDate) {
        this.userId = userId;
        this.logDate = logDate;
    }

    public UserLog() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }
}
