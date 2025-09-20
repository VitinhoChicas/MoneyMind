

package com.sistema.moneymind.resources;

import com.sistema.moneymind.domains.Usuario;
import com.sistema.moneymind.domains.dtos.UsuarioDTO;
import com.sistema.moneymind.services.UsuarioService;
import com.sistema.moneymind.security.JWTUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import com.sistema.moneymind.security.JWTUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@RequestMapping(value = "/usuario")

public class UsuarioResource {



    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JWTUtils jwtUtils;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll(){
        return ResponseEntity.ok().body(usuarioService.findAll());
    }

    @GetMapping("/me")
    public ResponseEntity<UsuarioDTO> getMe(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).build();
        }
        String token = authHeader.replace("Bearer ", "");
        String email = jwtUtils.getUsername(token);
        if (email == null) {
            return ResponseEntity.status(401).build();
        }
        Usuario usuario = usuarioService.findByEmailUsuario(email);
        return ResponseEntity.ok(new UsuarioDTO(usuario));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        Usuario obj = this.usuarioService.findbyId(id);
        return ResponseEntity.ok().body(new UsuarioDTO(obj));
    }

    @GetMapping(value =  "/emailUsuario/{emailUsuario}")
    public ResponseEntity<UsuarioDTO> findByEmailUsuario(@PathVariable String emailUsuario){
        Usuario obj = this.usuarioService.findByEmailUsuario(emailUsuario);
        return ResponseEntity.ok().body(new UsuarioDTO(obj));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO dto){
        Usuario usuario = usuarioService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getIdUsuario()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value =  "/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @Valid @RequestBody UsuarioDTO objDto){
        Usuario Obj = usuarioService.update(id, objDto);
        return ResponseEntity.ok().body(new UsuarioDTO(Obj));
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> delete(@PathVariable Long id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }





}
