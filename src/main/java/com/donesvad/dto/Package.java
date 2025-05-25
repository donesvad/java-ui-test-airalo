package com.donesvad.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Package {
    private final String title;
    private final String coverage;
    private final String data;
    private final String validity;
    private final String price;
}
