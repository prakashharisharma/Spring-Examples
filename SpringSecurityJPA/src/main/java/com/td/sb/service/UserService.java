package com.td.sb.service;

import com.td.sb.model.User;

public interface UserService {

    User findByUsername(String username);
}