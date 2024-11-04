package com.WebServTest.security;

import io.javalin.security.RouteRole;

public enum RoleUser implements RouteRole { ANYONE, USER_READ, USER_WRITE, ADMIN }
