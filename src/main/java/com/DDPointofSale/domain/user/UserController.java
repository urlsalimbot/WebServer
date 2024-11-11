package com.DDPointofSale.domain.user;


import com.google.inject.Inject;
import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

public class UserController implements CrudHandler {

    private UserService userServ;

    @Inject
    public UserController(UserService userServ) {
        this.userServ = userServ;
    }

    /**
     * @param context
     */
    @Override
    public void create(@NotNull Context context) {
        var newUser = context.bodyAsClass(User.class);
        context.json(userServ.addUser(newUser));
    }

    /**
     * @param context
     */
    @Override
    public void getAll(@NotNull Context context) {
        var result = userServ.getAll();
        context.json(result);
    }

    /**
     * @param context
     * @param s
     */
    @Override
    public void getOne(@NotNull Context context, @NotNull String s) {
        context.json(userServ.getUserbyName(s));
    }

    public void getbyID(@NotNull Context context, @NotNull String s) {
        var user = userServ.getUserbyID(Integer.parseInt(s));
        if(user.isPresent()) {context.json(user);}
        else{context.status(404);}
    }

    /**
     * @param context
     * @param s
     */
    @Override
    public void update(@NotNull Context context, @NotNull String s) {

    }

    /**
     * @param context
     * @param s
     */
    @Override
    public void delete(@NotNull Context context, @NotNull String s) {

    }
}
