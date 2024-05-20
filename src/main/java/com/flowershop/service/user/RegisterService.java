package com.flowershop.service.user;

import com.flowershop.entity.user.TUser;

public interface RegisterService {
    public Integer register(TUser user, String code);
}
