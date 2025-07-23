package com.vw.consent.management.system.consent.api.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ConsentDTO {
    private String id;
    private boolean enabled;
    private Date updateTimestamp;
}
