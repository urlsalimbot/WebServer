package com.DDPointofSale.security;

import io.javalin.security.RouteRole;

public enum RoleUser implements RouteRole { ANYONE, USER, ADMIN }
