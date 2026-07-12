package idk.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idk.example.demo.dto.securityDtos.LoginDto;
import idk.example.demo.entity.User;
import idk.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }



    @PostMapping("/register")
    public String register(@RequestBody User user){
            return userService.register(user);
    }


    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }
    

}
