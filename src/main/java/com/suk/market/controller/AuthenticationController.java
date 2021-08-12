package com.suk.market.controller;

import com.suk.market.configuration.security.JWTService;
import com.suk.market.domain.User;
import com.suk.market.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthenticationController {
    private JWTService jwtService;
    private UserService userService;

    @Autowired
    public void setJwtService(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Map<String,String>> authenticate(@RequestBody Map<String,String> request)
    {
        if(!request.containsKey("username")||!request.containsKey("password")){
            return ResponseEntity.badRequest().body(Map.of("reason","Incorrect User Name and Password"));
        }
        String username = request.get("username");
        String password = request.get("password");

        User user = userService.findUserByUsernameAndPassword(username, password);
        if(user == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("result","Bad Credential"));
        }
        return ResponseEntity.ok(Map.of("token",jwtService.generateToken(user)));

    }
}
