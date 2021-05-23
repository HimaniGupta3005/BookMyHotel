package com.alore.bookhotel.repositoryservice;

import java.util.Optional;

import com.alore.bookhotel.dao.User;
import com.alore.bookhotel.dto.userdto.AddUserRequest;
import com.alore.bookhotel.dto.userdto.DeleteUserRequest;
import com.alore.bookhotel.dto.userdto.DeleteUserResponse;
import com.alore.bookhotel.dto.userdto.UpdateUserRequest;
import com.alore.bookhotel.dto.userdto.UserResponse;
import com.alore.bookhotel.entity.UserEntity;
import com.alore.bookhotel.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class UserRepositoryServiceImpl implements UserRepositoryService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    @Qualifier("modelMapper")
    private ModelMapper modelMapper;

    @Override
    public UserEntity addUser(User user) {

        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        userRepo.save(userEntity);
        return userEntity;

    }

    @Override
    public void deleteUser(int userId) {

        userRepo.deleteById(userId);
    }

    @Override
    public UserEntity findUser(int userId) {

        Optional<UserEntity> optionalUserEntity = userRepo.findById(userId);

        if (optionalUserEntity.isPresent()) {
            return optionalUserEntity.get();
        }
        return null;
    }

    @Override
    public UserEntity updateUser(User user, int userId) {

        Optional<UserEntity> optionalUserEntity = userRepo.findById(userId);

        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            if (user.getGender() != null)
                userEntity.setGender(user.getGender());
            if (user.getName() != null || !user.getName().equals(""))
                userEntity.setName(user.getName());
            userRepo.save(userEntity);
            return userEntity;

        }

        return null;
    }

}
