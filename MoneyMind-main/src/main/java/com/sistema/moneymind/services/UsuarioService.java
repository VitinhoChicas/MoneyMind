package com.sistema.moneymind.services;


import com.sistema.moneymind.domains.Banco;
import com.sistema.moneymind.domains.Usuario;
import com.sistema.moneymind.domains.dtos.UsuarioDTO;
import com.sistema.moneymind.repositories.UsuarioRepository;
import com.sistema.moneymind.services.exceptions.DataIntegrityViolationException;
import com.sistema.moneymind.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository usRepo;

    @Autowired
    private PasswordEncoder encoder;

    public List<UsuarioDTO> findAll(){
        return usRepo.findAll().stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toUnmodifiableList());
    }

    public Usuario findbyId(Long id){
        Optional<Usuario> obj = usRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado! Id: " + id));
    }

    public Usuario findByEmailUsuario (String emailUsuario){
        Optional<Usuario> obj = usRepo.findByEmailUsuario(emailUsuario);
        return obj.orElseThrow(() -> new ObjectNotFoundException(" E-mail de usuário não encontrado! E-mail: " +emailUsuario));
    }

    public Usuario create (UsuarioDTO dto){
        dto.setIdUsuario(null);
        dto.setSenhaUsuario(encoder.encode(dto.getSenhaUsuario()));
        validaUsuario(dto);
        Usuario obj = new Usuario(dto);
        return usRepo.save(obj);
    }

    private void validaUsuario(UsuarioDTO dto){
        Optional<Usuario> obj = usRepo.findByEmailUsuario(dto.getEmailUsuario());
        if(obj.isPresent() && obj.get().getIdUsuario() != dto.getIdUsuario()){
            throw new DataIntegrityViolationException("E-mail já cadastrado");
        }
    }

    public Usuario update(Long id, UsuarioDTO objDto){
        objDto.setIdUsuario(id);
        Usuario oldObj = findbyId(id);

        // só encoda se senha foi enviada
        if (objDto.getSenhaUsuario() != null && !objDto.getSenhaUsuario().isBlank()) {
            objDto.setSenhaUsuario(encoder.encode(objDto.getSenhaUsuario()));
        } else {
            // mantém a senha antiga se não foi informada
            objDto.setSenhaUsuario(oldObj.getSenhaUsuario());
        }

        validaUsuario(objDto);
        Usuario newObj = new Usuario(objDto);
        return usRepo.save(newObj);
    }


    public void delete(Long id){
        Usuario obj = findbyId(id);
        if(obj.getContas().size()>0){
            throw new DataIntegrityViolationException("Usuário não pode ser excluido pois tem uma conta vinculado com ele");
        }
        usRepo.deleteById(id);
    }

}
