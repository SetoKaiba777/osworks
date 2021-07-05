package com.kaibakorp.osworksapi.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.boot.validation.*;

@Entity
@Table(name="CLIENTE")
public class ClienteEntity {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(name="Nome")
    private String nome;

    @NotBlank
    @Column(name="Email")
    @Email
    private String email;

    @NotBlank
    @Column(name="Telefone")
    private String tel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
