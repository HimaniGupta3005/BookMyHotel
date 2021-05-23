package com.alore.bookhotel.dto.userdto;

public class DeleteUserRequest {

    private int id;

    public DeleteUserRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DeleteUserRequest(int id) {
        this.id = id;
    }

}
