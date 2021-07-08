package com.kaibakorp.osworksapi.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kaibakorp.osworksapi.domain.ValidationGroups;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Table(name="OS")
public class OSEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Valid
    @ConvertGroup(from= Default.class, to = ValidationGroups.ClienteId.class)
    @NotNull
    @ManyToOne
    private ClienteEntity cliente;

    @NotBlank
    @Column(name="Description")
    private String description;

    @NotNull
    @Column(name="Price")
    private BigDecimal price;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name="Status")
    @Enumerated(EnumType.STRING)
    private OSstatus status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name="Finish_Date")
    private OffsetDateTime finishDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name="Opening_Date")
    private OffsetDateTime openDate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public OSstatus getStatus() {
        return status;
    }

    public void setStatus(OSstatus status) {
        this.status = status;
    }

    public OffsetDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(OffsetDateTime finishDate) {
        this.finishDate = finishDate;
    }

    public OffsetDateTime getOpenDate() {
        return openDate;
    }

    public void setOpenDate(OffsetDateTime openDate) {
        this.openDate = openDate;
    }
}
