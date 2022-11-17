package com.useraddress.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Id
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "usuario")
    private List<Endereco> enderecos;

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Deprecated
    public Usuario(){

    }

    public Usuario(String email) {
                this.email = email;
    }
}
