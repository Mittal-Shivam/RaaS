package com.epoch.makers.raas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private List<com.epoch.makers.raas.model.Data> data;
}