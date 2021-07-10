package com.kaibakorp.osworksapi.api.rpmodel;


import java.time.OffsetDateTime;

public class ClienteRp {

    private Long id;
    private String description;
    private OffsetDateTime sendDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffsetDateTime getSendDateTime() {
        return sendDateTime;
    }
}

