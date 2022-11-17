package com.useraddress.form;

import com.useraddress.entity.Endereco;
import com.useraddress.entity.Usuario;
import com.useraddress.repo.UsuarioRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;


public class EnderecoForm {

    @NotBlank
    private String logradouro;
    @NotBlank
    private String numero;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cidade;
    @NotBlank
    private String estado;
    @NotBlank
    private String cep;
    @NotNull
    private String email;

    public EnderecoForm(@NotBlank String logradouro, @NotBlank String numero, @NotBlank String bairro, @NotBlank String cidade, @NotBlank String estado, @NotBlank String cep, @NotNull String email) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.email = email;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public String getEmail() {
        return email;
    }

    public Endereco converter(UsuarioRepository usuarioRepository){
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);

        return new Endereco(logradouro, numero, bairro, cidade, estado, cep, usuario.get());

    }




}
