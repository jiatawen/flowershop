package com.flowershop.service.impl.user;

import com.flowershop.service.user.GetHexService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class GetHexServiceImpl implements GetHexService {
    @Override
    public String getHex(String str) {
        String s = DigestUtils.md5DigestAsHex(str.getBytes());
        System.out.println(s);
        return s;
    }
}
