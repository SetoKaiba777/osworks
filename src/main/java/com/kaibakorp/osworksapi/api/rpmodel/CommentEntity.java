package com.kaibakorp.osworksapi.api.rpmodel;

import com.kaibakorp.osworksapi.domain.model.OSEntity;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name="COMMENTS")
public class CommentEntity {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentEntity commentEntity = (CommentEntity) o;
        return id.equals(commentEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private OSEntity os;

    @Column(name="Description")
    private String descrption;

    @Column(name="SendDT")
    private OffsetDateTime sendDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OSEntity getOs() {
        return os;
    }

    public void setOs(OSEntity os) {
        this.os = os;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public OffsetDateTime getSendDateTime() {
        return sendDateTime;
    }

    public void setSendDateTime(OffsetDateTime sendDateTime) {
        this.sendDateTime = sendDateTime;
    }
}
