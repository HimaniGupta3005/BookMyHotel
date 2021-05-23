package com.alore.bookhotel.dto.userdto;

import com.alore.bookhotel.dao.Gender;
import com.alore.bookhotel.dao.User;

import lombok.NonNull;

public class UpdateUserRequest {

    @NonNull
    private int id;

    private User user;

    public UpdateUserRequest(@NonNull int id, User user) {
        this.id = id;
        this.user = user;
    }

    public UpdateUserRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setName(User user) {
        this.user = user;
    }

}
