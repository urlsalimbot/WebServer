package com.DDPointofSale.security.userauth;

import com.DDPointofSale.security.RoleUser;
import com.DDPointofSale.security.util.AuthHandler;
import com.DDPointofSale.security.util.ProviderUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.javalin.http.UnauthorizedResponse;
import jakarta.inject.Inject;

import java.util.Optional;

public class AuthenticationService {
    IAuthenticationRepository authenticationRepository;

    @Inject
    public AuthenticationService(IAuthenticationRepository authRepo){
        this.authenticationRepository = authRepo;
    }

    private static UserAuth getUserAuthfromDTO(UserAuthDTO userAuth) {
        UserAuth myUser = new UserAuth();
        myUser.setUsername(userAuth.getUsername());
        myUser.setPasswordHash(AuthHandler.hashPassword(userAuth.getPassword()));
        myUser.setRoles(RoleUser.valueOf(userAuth.getRoles()));
        return myUser;
    }

    public boolean validate(DecodedJWT token) {
        var user = token.getClaim("user").asString();
        var pw = token.getClaim("passwordHash").asString();
        var level = token.getClaim("level").asString();

        return false;
    }

    public Optional<String> authenticate(UserAuthDTO userAuth) {
        UserAuth checkuser = authenticationRepository.getbyUsername(userAuth.getUsername());
        if (checkuser != null && AuthHandler.checkPassword(userAuth.getPassword(),checkuser.getPasswordHash())){
            return getToken(checkuser).describeConstable();
        } else {
            throw new UnauthorizedResponse("Unauthorized");
        }
    }

    public String getToken(UserAuth userAuth) {
        return AuthHandler.refprovider.generateToken(userAuth);
    }

    public void register(UserAuthDTO userAuthDTO) {
        UserAuth myUser = getUserAuthfromDTO(userAuthDTO);
        Optional<UserAuth> checkuser = Optional.ofNullable(authenticationRepository.getbyUsername(myUser.getUsername()));
        if (checkuser.isEmpty()) {
            authenticationRepository.save(myUser);
        }
    }
}
