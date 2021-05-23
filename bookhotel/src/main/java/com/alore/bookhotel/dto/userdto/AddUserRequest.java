package com.alore.bookhotel.dto.userdto;

import com.alore.bookhotel.dao.Gender;
import com.alore.bookhotel.dao.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NonNull;

public class AddUserRequest {

    private User user;

    public AddUserRequest() {

    }

    public AddUserRequest(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
