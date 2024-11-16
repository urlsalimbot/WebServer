package com.DDPointofSale.security.userauth;

import com.DDPointofSale.config.ModuleConfig;
import com.DDPointofSale.security.RoleUser;
import com.DDPointofSale.security.util.AuthHandler;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.javalin.http.Context;
import jakarta.inject.Inject;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationControllerTest {

    @Test
    void testifIcanRegister() {

        Injector injector = Guice.createInjector(new ModuleConfig());
        AuthenticationController authcon = injector.getInstance(AuthenticationController.class);

        System.out.println(AuthHandler.hashPassword("123456789"));

        UserAuth userAuth = UserAuth.builder()
                .username("admin")
                .passwordHash(AuthHandler.hashPassword("Nyellow"))
                .roles(RoleUser.ADMIN).build();

//        authcon.register();
    }

}