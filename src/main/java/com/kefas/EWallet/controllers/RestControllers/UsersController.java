package com.kefas.EWallet.controllers.RestControllers;

import com.kefas.EWallet.dtos.requestDtos.ChangePasswordDto;
import com.kefas.EWallet.dtos.responseDtos.ApiResponse;
import com.kefas.EWallet.dtos.responseDtos.UserResponseDto;
import com.kefas.EWallet.services.UserServices;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/")
public class UsersController {

    private final UserServices userServices;

    @GetMapping("hello")
    public String sayHello() {

        return "Hello";
    }

    @Operation(summary = "Updates a logged in user password, generates a new Bearer token and blacklists the old token")
    @PostMapping("/update-password")
    public ResponseEntity<ApiResponse<UserResponseDto>> updatePassword(@RequestBody ChangePasswordDto changePasswordDto, @RequestHeader("Authorization") String token) {
        if (token.startsWith("Bearer")) {
            token = token.replace("Bearer", "").replace("\\s", "");
        }
        changePasswordDto.setVerificationToken(token);
        return ResponseEntity.ok(new ApiResponse<>("Password updated",true, userServices.updatePassword(changePasswordDto)));
    }
    @Operation(summary = "Blacklists the users token")
    @GetMapping("/logout")
    public ResponseEntity<ApiResponse<String>> logout(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(new ApiResponse<>(userServices.logout(token), true, null));
    }

}
