package com.nocountry.grupo10.service.impl;


import com.nocountry.grupo10.service.UserService;
import com.nocountry.grupo10.model.entity.AppUser;
import com.nocountry.grupo10.repository.AppUserRepository;
import java.text.MessageFormat;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
    private static final String USER_ID_NOT_FOUND = "User id {0} not found.";
    
    @Autowired
    private AppUserRepository userRepository;
    
    public AppUser getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException(MessageFormat.format(USER_ID_NOT_FOUND, id)));
    }
}
