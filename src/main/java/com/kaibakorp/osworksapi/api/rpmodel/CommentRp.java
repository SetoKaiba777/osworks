package com.kaibakorp.osworksapi.api.rpmodel;

import java.time.OffsetDateTime;

public class CommentRp {

    private Long id;
    private String descrption;
    private OffsetDateTime sendDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
