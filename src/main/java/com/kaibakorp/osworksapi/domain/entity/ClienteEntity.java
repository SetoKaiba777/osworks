package com.kaibakorp.osworksapi.domain.entity;

import com.kaibakorp.osworksapi.domain.ValidationGroups;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="CLIENTE")
public class ClienteEntity {

    @NotNull(groups= ValidationGroups.ClienteId.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 60)
    @Column(name="Nome")
    private String nome;

    @NotBlank
    @Size(max = 255)
    @Column(name="Email")
    @Email
    private String email;

    @NotBlank
    @Size(max = 20)
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