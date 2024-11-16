package com.DDPointofSale.security.userauth;

import com.DDPointofSale.security.RoleUser;
import com.DDPointofSale.security.util.AuthHandler;
import com.DDPointofSale.security.util.ProviderUtil;
import io.javalin.http.Context;
import io.javalin.validation.BodyValidator;
import io.javalin.validation.ValidationException;
import jakarta.inject.Inject;
import javalinjwt.JavalinJWT;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class AuthenticationController {
    AuthenticationService authenticationService;

    @Inject
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public void login(@NotNull Context context) {
        BodyValidator<UserAuthDTO> validator = context.bodyValidator(UserAuthDTO.class)
                .check(obj -> obj.getUsername() != null, "username is required")
                .check(obj -> obj.getPassword() != null, "password is required");
        if(validator.errors().isEmpty()) {
            var userAuthDTO = validator.getOrThrow(ValidationException::new);
            var token = authenticationService.authenticate(userAuthDTO);
            JavalinJWT.addTokenToCookie(context,token.get());
            context.json(Map.of("status", "success")).status(200);
        }else{
            context.status(422).json(validator.errors());
        }

    }

    public void register(@NotNull Context ctx) {
        BodyValidator<UserAuthDTO> validator = ctx.bodyValidator(UserAuthDTO.class)
                .check(obj -> obj.getUsername() != null, "username is required")
                .check(obj -> obj.getPassword() != null, "password is required")
                .check(it -> !it.getRoles().equals("ANYONE"), "role above ANYONE is required");
        if (validator.errors().isEmpty()) {
            authenticationService.register(validator.get());
            ctx.json(Map.of("status", "success")).status(201);
        } else {
            ctx.status(422).json(validator.errors());
        }
    }
}
