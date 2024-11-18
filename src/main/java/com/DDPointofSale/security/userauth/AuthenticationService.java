package com.DDPointofSale.security.userauth;

import com.DDPointofSale.security.RoleUser;
import com.DDPointofSale.security.util.AuthHandler;
import com.DDPointofSale.security.util.ProviderUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.javalin.http.UnauthorizedResponse;
import jakarta.inject.Inject;

import java.util.HashMap;
import java.util.Map;
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

    public Map<String,String> validate(DecodedJWT token) {
        var user = token.getClaim("user").asString();
        var level = token.getClaim("role").asString();

        return Map.of(user,level);
    }

    public Map<String,String> authenticate(UserAuthDTO userAuth) {
        UserAuth checkuser = authenticationRepository.getbyUsername(userAuth.getUsername());
        if (checkuser != null && AuthHandler.checkPassword(userAuth.getPassword(),checkuser.getPasswordHash())){
            var myUser = new HashMap<String,String>();
            myUser.put("TOKEN",getToken(checkuser));
            myUser.put("username",checkuser.getUsername());
            myUser.put("role",checkuser.getRoles().toString());
            System.out.println(myUser);
            return myUser;
        } else {
            throw new UnauthorizedResponse("Wrong Username or Password");
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
