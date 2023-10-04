package com.rafeed.wcteaminfodemo.SecurityConfiguration.Authentication.RequestAndResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    @Email
    private String email;
    private String password;
}
