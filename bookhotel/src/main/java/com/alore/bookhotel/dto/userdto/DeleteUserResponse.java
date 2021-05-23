package com.alore.bookhotel.dto.userdto;

public class DeleteUserResponse {

    private String message;

    public DeleteUserResponse() {

    }

    public DeleteUserResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
