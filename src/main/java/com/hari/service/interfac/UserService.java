package com.hari.service.interfac;

import com.hari.dto.LoginRequest;
import com.hari.dto.Response;
import com.hari.entity.User;

public interface UserService {
    Response register(User user);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUserBookingHistory(String userId);

    Response deleteUser(String userId);

    Response getUserById(String userId);

    Response getMyInfo(String email);
}
