package com.nocountry.grupo10.DTO.Response;

import lombok.Data;

@Data
public class LoanStateResponse {
    private String name;
    private Long idLoan;
    private Long document;
    private String message;
}
