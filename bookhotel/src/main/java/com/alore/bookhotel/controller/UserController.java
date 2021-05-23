package com.alore.bookhotel.controller;

import com.alore.bookhotel.dao.User;
import com.alore.bookhotel.dto.userdto.AddUserRequest;
import com.alore.bookhotel.dto.userdto.DeleteUserRequest;
import com.alore.bookhotel.dto.userdto.DeleteUserResponse;
import com.alore.bookhotel.dto.userdto.UpdateUserRequest;
import com.alore.bookhotel.dto.userdto.UserResponse;
import com.alore.bookhotel.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/BookMyHotel")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserResponse> addUser(@RequestBody AddUserRequest addUserRequest) {

        if (addUserRequest != null) {

            UserResponse response = userService.addUser(addUserRequest);
            if (response != null)
                return ResponseEntity.ok().body(response);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/user")
    public ResponseEntity<DeleteUserResponse> deleteUser(@RequestBody DeleteUserRequest deleteUserRequest) {

        if (deleteUserRequest != null) {
            DeleteUserResponse response = userService.deleteUser(deleteUserRequest);
            if (response != null)
                return ResponseEntity.ok().body(response);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/user")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UpdateUserRequest updateUserRequest) {

        if (updateUserRequest != null) {
            UserResponse response = userService.updateUser(updateUserRequest);
            if (response != null)
                return ResponseEntity.ok().body(response);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/user")
    public ResponseEntity<UserResponse> updateUser(@RequestParam int id) {

        if (id > 0) {
            UserResponse response = userService.getUser(id);
            if (response != null)
                return ResponseEntity.ok().body(response);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
