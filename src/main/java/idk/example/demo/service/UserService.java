package idk.example.demo.service;



import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import idk.example.demo.dto.securityDtos.LoginDto;
import idk.example.demo.entity.User;
import idk.example.demo.repo.UserRepo;

@Service
public class UserService {

   private final PasswordEncoder passwordEncoder;
   private final UserRepo userRepo;
    private final JwtService jwtService;
    public UserService(PasswordEncoder pEncoder,UserRepo userRepo,JwtService jwtService){
        this.passwordEncoder=pEncoder;
         this.userRepo=userRepo;    
         this.jwtService=jwtService;
    }


    public String register(User user){
        User tempUser=userRepo.findByUsername(user.getUsername()).orElse(null);
        if(tempUser!=null){
            return "Already registered";
        }

        if(userRepo.findByEmail(user.getEmail()).orElse(null)!=null){
            return "Email already exists";
        }

        user.setRole(idk.example.demo.enums.Role.USER);
        String rawPassword=user.getPassword();
        String hashedPassword=passwordEncoder.encode(rawPassword);
        user.setPassword(hashedPassword);
        userRepo.save(user);
        return "Registered";
    }


    public String login(LoginDto loginDto){
        String username=loginDto.getUsername();
        if(!userRepo.existsByUsername(username)){
            return "user isn't registered";
        }
        User user=userRepo.findByUsername(username).orElse(null);
        String hashedPassword=user.getPassword();
        if(!passwordEncoder.matches(loginDto.getPassword(), hashedPassword)){
            return "Invalid password";
        }
        String jwt=jwtService.generateJwt(user);
        return jwt;
    }



}
