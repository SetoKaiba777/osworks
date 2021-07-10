package com.kaibakorp.osworksapi.api.rpmodel;

import com.kaibakorp.osworksapi.domain.enum_class.OSstatus;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class OSRp {
    private Long id;
    private BigDecimal price;
    private String description;
    private OSstatus status;
    private OffsetDateTime openDate;
    private OffsetDateTime finishDate;
    private ClienteRp cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public OffsetDateTime getOpenDate() {
        return openDate;
    }

    public void setOpenDate(OffsetDateTime openDate) {
        this.openDate = openDate;
    }

    public OffsetDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(OffsetDateTime finishDate) {
        this.finishDate = finishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ClienteRp getCliente() {
        return cliente;
    }

    public void setCliente(ClienteRp cliente) {
        this.cliente = cliente;
    }
}
