package com.alore.bookhotel.repositoryservice;

import com.alore.bookhotel.dao.User;
import com.alore.bookhotel.dto.userdto.AddUserRequest;
import com.alore.bookhotel.dto.userdto.DeleteUserRequest;
import com.alore.bookhotel.dto.userdto.DeleteUserResponse;
import com.alore.bookhotel.dto.userdto.UpdateUserRequest;
import com.alore.bookhotel.dto.userdto.UserResponse;
import com.alore.bookhotel.entity.UserEntity;

public interface UserRepositoryService {

    public UserEntity addUser(User user);

    public void deleteUser(int userId);

    public UserEntity updateUser(User user, int userId);

    public UserEntity findUser(int userId);
}
