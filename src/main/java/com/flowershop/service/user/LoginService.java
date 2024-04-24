package com.flowershop.service.user;

import com.flowershop.entity.user.TUser;

public interface LoginService {
    public TUser login(String email, String password);
}
