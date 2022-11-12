package com.rafeed.wcteaminfodemo.SecurityConfiguration.Authentication.RequestAndResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String email;
    private String accessToken;
}
