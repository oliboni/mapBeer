package br.edu.unochapeco.mapbeer.model.vo;


import android.support.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

public class UserVO {

    @NotNull
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String password;

    @NotNull
    private Boolean isLogged;

    public UserVO(@NotNull final Integer id, @NotNull final String name, @NotNull final String password, @NotNull final Boolean isLogged) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.isLogged = isLogged;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public String getPassword() {
        return password;
    }
    @NotNull
    public Boolean getLogged() {
        return isLogged;
    }

}
