package com.kefas.EWallet.services;

import com.kefas.EWallet.dtos.requestDtos.ActivateUserDto;
import com.kefas.EWallet.dtos.requestDtos.ChangePasswordDto;
import com.kefas.EWallet.dtos.requestDtos.UserLoginDto;
import com.kefas.EWallet.dtos.requestDtos.UserSignupDto;
import com.kefas.EWallet.dtos.responseDtos.UserResponseDto;

public interface UserServices {
    UserResponseDto signup(UserSignupDto userDto);

    String sendToken(String userEmail, String mailSubject);

    UserResponseDto activateUser(ActivateUserDto activateUserDto);

    UserResponseDto login(UserLoginDto userLoginDto);

//    String forgotPassword(String email);

    String resetPassword(ChangePasswordDto changePasswordDto);

    String logout(String token);

    UserResponseDto updatePassword(ChangePasswordDto changePasswordDto);
}
