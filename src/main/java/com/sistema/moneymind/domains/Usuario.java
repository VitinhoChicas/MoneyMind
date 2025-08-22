package com.sistema.moneymind.domains;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistema.moneymind.domains.dtos.UsuarioDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    private Long idUsuario;

    @NotBlank @NotNull
    private String nomeUsuario;

    @NotNull @NotBlank
    @Column(unique = true)
    private String emailUsuario;

    @NotNull @NotBlank
    private String senhaUsuario;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataNascimento;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Conta> contas = new ArrayList<>();


    public Usuario() {
    }

    public Usuario(Long idUsuario, String nomeUsuario, String emailUsuario, String senhaUsuario, LocalDate dataNascimento) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
        this.dataNascimento = dataNascimento;
    }

    public Usuario(UsuarioDTO usuarioDTO) {
        this.idUsuario = usuarioDTO.getIdUsuario();
        this.nomeUsuario = usuarioDTO.getNomeUsuario();
        this.emailUsuario = usuarioDTO.getEmailUsuario();
        this.senhaUsuario = usuarioDTO.getSenhaUsuario();
        this.dataNascimento = usuarioDTO.getDataNascimento();
    }


    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public @NotBlank @NotNull String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(@NotBlank @NotNull String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public @NotNull @NotBlank String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(@NotNull @NotBlank String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public @NotNull @NotBlank String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(@NotNull @NotBlank String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(idUsuario, usuario.idUsuario) && Objects.equals(nomeUsuario, usuario.nomeUsuario) && Objects.equals(emailUsuario, usuario.emailUsuario) && Objects.equals(senhaUsuario, usuario.senhaUsuario) && Objects.equals(dataNascimento, usuario.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nomeUsuario, emailUsuario, senhaUsuario, dataNascimento);
    }
}


