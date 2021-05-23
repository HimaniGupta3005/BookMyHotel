package com.alore.bookhotel.service;

import com.alore.bookhotel.dao.User;
import com.alore.bookhotel.dto.userdto.AddUserRequest;
import com.alore.bookhotel.dto.userdto.DeleteUserRequest;
import com.alore.bookhotel.dto.userdto.DeleteUserResponse;
import com.alore.bookhotel.dto.userdto.UpdateUserRequest;
import com.alore.bookhotel.dto.userdto.UserResponse;

public interface UserService {

    public UserResponse addUser(AddUserRequest user);

    public UserResponse getUser(int id);

    public DeleteUserResponse deleteUser(DeleteUserRequest user);

    public UserResponse updateUser(UpdateUserRequest user);

}
