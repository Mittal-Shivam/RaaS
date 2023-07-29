package com.epoch.makers.raas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private Integer mcc;
    private String merchantBrandName;
    private String merchantCategory1Name;
    private String merchantCategory2Name;
    private String merchantCategory3Name;
    private String fcaCode;
    private String fcaCategory;
}