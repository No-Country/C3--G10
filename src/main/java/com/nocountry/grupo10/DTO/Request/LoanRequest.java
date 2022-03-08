package com.nocountry.grupo10.DTO.Request;

import lombok.Data;

@Data
public class LoanRequest {
    private Long requiredMoney;
    private Integer dues;
    private Long document;
}
