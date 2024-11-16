package com.DDPointofSale.security.util;

import com.DDPointofSale.security.userauth.UserAuth;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import javalinjwt.JWTGenerator;
import javalinjwt.JWTProvider;

import java.time.Instant;

public class ProviderUtil {

    static Algorithm refalgorithm = Algorithm.HMAC256("iliketurtles");

    static JWTGenerator<UserAuth> refgenerator = (user, alg) -> {
        JWTCreator.Builder token = JWT.create()
                .withClaim("name", user.getUsername())
                .withClaim("role", user.getRoles().toString())
                .withIssuedAt(Instant.now())
                .withNotBefore(Instant.now().plusSeconds(5))
                .withExpiresAt(Instant.now().plusSeconds(86400));
        return token.sign(alg);
    };

    static JWTVerifier refverifier = JWT.require(refalgorithm).build();

    public static JWTProvider<UserAuth> provider = new JWTProvider<>(refalgorithm, refgenerator, refverifier);


}

