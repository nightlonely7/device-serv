package vn.edu.fpt.deviceserv.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.stereotype.Service;
import vn.edu.fpt.deviceserv.dto.Permission;
import vn.edu.fpt.deviceserv.dto.User;
import vn.edu.fpt.deviceserv.repository.PermissionRepository;
import vn.edu.fpt.deviceserv.repository.UserRepository;
import vn.edu.fpt.deviceserv.service.AuthenticationService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Algorithm ALGORITHM = Algorithm.HMAC512("secrret");
    private static final String USERNAME_CLAIM = "USERNAME";
    private static final String FUNCTION_SIGNATURE_CLAIM = "FUNCTION_SIGNATURE";
    private static final PasswordEncryptor PASSWORD_ENCRYPTOR = new StrongPasswordEncryptor();

    private final PermissionRepository permissionRepository;
    private final UserRepository userRepository;

    @Override
    public boolean authenticate(String token, String functionSignature) {
        JWTVerifier verifier = JWT.require(ALGORITHM)
                .withIssuer("default")
                .build();
        DecodedJWT decodedJWT = verifier.verify(token);
        String usernameClaim = decodedJWT.getClaim(USERNAME_CLAIM).asString();
        String functionSignatureClaim = decodedJWT.getClaim(FUNCTION_SIGNATURE_CLAIM).asString();
        return permissionRepository.existsByUsers_UsernameAndFunctionSignature(usernameClaim, functionSignatureClaim);
    }

    @Override
    public String signIn(String basicAuth) {
        String pair = new String(Base64.decodeBase64(basicAuth));
        String username = pair.split(":")[0];
        String password = pair.split(":")[1];
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty() || !PASSWORD_ENCRYPTOR.checkPassword(password, userOptional.get().getPassword())) {
            return null;
        }
        return JWT.create()
                .withClaim(USERNAME_CLAIM, username)
                .withArrayClaim(FUNCTION_SIGNATURE_CLAIM, userOptional.get().getPermissions().stream()
                        .map(Permission::getFunctionSignature).toArray(String[]::new))
                .withExpiresAt(Date.from(Instant.from(LocalDateTime.now().plusDays(30))))
                .withIssuer("default")
                .sign(ALGORITHM);
    }
}
