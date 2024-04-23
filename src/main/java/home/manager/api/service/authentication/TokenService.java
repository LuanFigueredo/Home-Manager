package home.manager.api.service.authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import home.manager.api.model.user.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Value("{api.security.token.secret}")
    private String secret;
    public String generateToken(User user){
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("Home Manager API")
                    .withSubject(user.getUsername())
                    .withClaim("id", user.getId())
                    .withExpiresAt(expirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("erro ao gerar token JWT", exception);
            // Invalid Signing configuration / Couldn't convert Claims.
        }
    }

    public String getSubject(String tokenJWT){
        try{
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("Home Manager API")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        }catch (JWTVerificationException e){
            throw new RuntimeException("Token JWT inválido ou expirado");
        }

    }
    //DEFINE TEMPO DE DURAÇÃO DO TOKEN
    private Instant expirationDate() {
        return LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.of("-03:00"));
    }
}
