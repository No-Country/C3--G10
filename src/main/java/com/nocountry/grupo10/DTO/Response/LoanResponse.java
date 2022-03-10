package com.nocountry.grupo10.DTO.Response;

import lombok.Data;

@Data
public class LoanResponse {
    private Long id;
    private Long requiredMoney;
    private Integer dues;
    private Boolean state;
    private double interest;
    private double monthlyFee;
    private Double totalAmount;
}
