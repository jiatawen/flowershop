package com.flowershop.service.user;

import com.flowershop.entity.user.TUser;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    public TUser login(String email, String password);
}
