package idk.example.demo.service;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import idk.example.demo.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    public String generateJwt(User user){

        SecretKey key=Keys.hmacShaKeyFor(secret.getBytes());

    return Jwts.builder().subject(user.getUsername()).
    issuedAt(new Date()).expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)).
    signWith(key).compact();
    }

    public String extractUsername(String token) {
    SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

    return Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
}
    public boolean validateToken(String token, UserDetails userDetails) {

    String username = extractUsername(token);

    return username.equals(userDetails.getUsername())
            && !isTokenExpired(token);
}

   public boolean isTokenExpired(String token) {
    SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

    Date expiration = Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getExpiration();

    return expiration.before(new Date());
}

}
