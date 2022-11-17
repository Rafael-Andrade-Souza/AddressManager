package com.useraddress.form;


import com.useraddress.entity.Usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class UsuarioForm {

    @NotBlank @Email
    private String email;

    public String getEmail() {
        return email;
    }

       public UsuarioForm(@NotBlank @Email String email) {
        this.email = email;
        }

    public Usuario converter(){
        return new Usuario(email);
    }
}
