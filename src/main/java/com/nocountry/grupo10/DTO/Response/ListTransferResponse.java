package com.nocountry.grupo10.DTO.Response;

import java.util.List;

public class ListTransferResponse {

    private List<TransferResponse> transfers;

    public List<TransferResponse> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<TransferResponse> transfers) {
        this.transfers = transfers;
    }
}
