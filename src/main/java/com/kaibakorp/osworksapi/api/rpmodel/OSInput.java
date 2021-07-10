package com.kaibakorp.osworksapi.api.rpmodel;

import com.kaibakorp.osworksapi.domain.model.ClienteEntity;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class OSInput {
    @Valid
    @NotNull
    private ClienteIdInput cliente;

    @NotBlank
    private String description;

    @NotNull
    private BigDecimal price;

    public ClienteIdInput getCliente() {
        return cliente;
    }

    public void setCliente(ClienteIdInput cliente) {
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
}
