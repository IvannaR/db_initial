package com.example.myTestDatabase.controller.request;

import javax.validation.constraints.NotNull;

public class UserCreateRequest {

    @NotNull
    public String email;

    @NotNull
    public String name;
}

