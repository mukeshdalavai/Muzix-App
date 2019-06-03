package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.domain.User;
import com.stackroute.exception.UserAlreadyExistException;

import java.util.List;
import java.util.Optional;

public interface UserService {


    public User saveUser(User user) throws UserAlreadyExistException;

    public List<User> getAllUser();

    public Track[] getFavouriteTracks(int userId);
}
