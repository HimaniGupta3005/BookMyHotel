package com.alore.bookhotel.service;

import com.alore.bookhotel.dao.User;
import com.alore.bookhotel.dto.userdto.AddUserRequest;
import com.alore.bookhotel.dto.userdto.DeleteUserRequest;
import com.alore.bookhotel.dto.userdto.DeleteUserResponse;
import com.alore.bookhotel.dto.userdto.UpdateUserRequest;
import com.alore.bookhotel.dto.userdto.UserResponse;
import com.alore.bookhotel.entity.UserEntity;
import com.alore.bookhotel.repositoryservice.UserRepositoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositoryService userRepositoryService;

    @Override
    public UserResponse addUser(AddUserRequest addUserRequest) {

        if (addUserRequest.getUser() == null)
            return null;
        UserEntity userEntity = userRepositoryService.addUser(addUserRequest.getUser());
        if (userEntity != null) {

            UserResponse userResponse = new UserResponse(userEntity.getId(), userEntity.getName(),
                    userEntity.getGender());
            return userResponse;
        }

        return null;
    }

    @Override
    public DeleteUserResponse deleteUser(DeleteUserRequest user) {

        userRepositoryService.deleteUser(user.getId());
        DeleteUserResponse response = new DeleteUserResponse("Successfully deleted");
        return response;
    }

    @Override
    public UserResponse updateUser(UpdateUserRequest updateUserRequest) {

        UserEntity userEntity = userRepositoryService.updateUser(updateUserRequest.getUser(),
                updateUserRequest.getId());

        UserResponse response = null;
        if (userEntity != null) {
            response = new UserResponse(userEntity.getId(), userEntity.getName(), userEntity.getGender());
        }

        return response;
    }

    @Override
    public UserResponse getUser(int id) {

        UserEntity userEntity = userRepositoryService.findUser(id);

        UserResponse response = null;
        if (userEntity != null) {
            response = new UserResponse(userEntity.getId(), userEntity.getName(), userEntity.getGender());
        }

        return response;

    }

}
