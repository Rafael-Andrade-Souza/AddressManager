package com.useraddress.controller;

import com.useraddress.entity.Usuario;
import com.useraddress.DTO.UsuarioDTO;
import com.useraddress.form.UsuarioForm;
import com.useraddress.repo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid UsuarioForm usuarioForm, UriComponentsBuilder uriBuilder){
       Usuario usuario = usuarioForm.converter();

       Optional<Usuario> usuarioPorEmail = usuarioRepository.findByEmail(usuarioForm.getEmail());

       if(usuarioPorEmail.isPresent()){
           return ResponseEntity.badRequest().build();
       }

       usuarioRepository.save(usuario);
       URI uri = uriBuilder.path("/api/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();

       return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{email}")
    public ResponseEntity<UsuarioDTO> detalhar(@PathVariable Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if(usuario.isPresent()){
            return ResponseEntity.ok(new UsuarioDTO(usuario.get()));
        }

        return ResponseEntity.notFound().build();
    }





}
