package com.useraddress.DTO;

import com.useraddress.entity.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDTO {

    private String email;
    private List<EnderecoDTO> enderecos;

    public String getEmail() {
        return email;
    }

    public List<EnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public UsuarioDTO(Usuario usuario) {
        this.email = usuario.getEmail();
        this.enderecos = usuario.getEnderecos().stream().map(EnderecoDTO::new).collect(Collectors.toList());
    }
}
