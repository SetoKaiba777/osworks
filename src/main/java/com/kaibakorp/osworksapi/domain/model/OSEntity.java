package com.kaibakorp.osworksapi.domain.model;

import com.kaibakorp.osworksapi.api.rpmodel.CommentEntity;
import com.kaibakorp.osworksapi.domain.enum_class.OSstatus;
import com.kaibakorp.osworksapi.domain.exception.ServiceException;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="OS")
public class OSEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private ClienteEntity cliente;

    @Column(name="Description")
    private String description;


    @Column(name="Price")
    private BigDecimal price;

    @Column(name="Status")
    @Enumerated(EnumType.STRING)
    private OSstatus status;

    @Column(name="Finish_Date")
    private OffsetDateTime finishDate;

    @Column(name="Opening_Date")
    private OffsetDateTime openDate;

    @OneToMany(mappedBy = "os")
    private List<CommentEntity> commentEntities = new ArrayList<>();

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

    public List<CommentEntity> getComments() {
        return commentEntities;
    }

    public void setComments(List<CommentEntity> commentEntities) {
        this.commentEntities = commentEntities;
    }

    public boolean canBeFinished(){
        return OSstatus.OPEN.equals(getStatus());
    }

    public void finish(){
        if(!canBeFinished()){
            throw new ServiceException("Service Order can't be cancelled");
        }
        setStatus(OSstatus.FINISHED);
        setFinishDate(OffsetDateTime.now());
    }
}
