package com.rafeed.wcteaminfodemo.SecurityConfiguration.Authentication.Controller;

import com.rafeed.wcteaminfodemo.Enity.User;
import com.rafeed.wcteaminfodemo.SecurityConfiguration.Authentication.RequestAndResponse.AuthenticationRequest;
import com.rafeed.wcteaminfodemo.SecurityConfiguration.Authentication.RequestAndResponse.AuthenticationResponse;
import com.rafeed.wcteaminfodemo.SecurityConfiguration.JWT.JwtTokenUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;

    public AuthenticationController(AuthenticationManager authenticationManager,
                                    JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationRequest authenticationRequest){
        try{
            Authentication authentication =authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getEmail(),
                            authenticationRequest.getPassword()
                    )
            );
            User user = (User) authentication.getPrincipal();
            String accessToken = jwtTokenUtil.generateAccessToken(user);
            AuthenticationResponse authenticationResponse = new AuthenticationResponse(user.getEmail(), accessToken);

            return ResponseEntity.ok().body(authenticationResponse);

        }catch (BadCredentialsException badCredentialsException){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
