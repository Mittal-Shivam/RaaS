package com.epoch.makers.raas.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Data {
    private Timestamp transactionBookedTimestamp;
    private String transactionId;
    private String accountId;
    private Integer amount;
    private String transactionType;
    private String transactionCode;
    private String brand;
    private String transactionStatus;
    private String transactionNarrative;
    private String currencyCode;
    private Category category;
    private String carbonModelVersion;
}