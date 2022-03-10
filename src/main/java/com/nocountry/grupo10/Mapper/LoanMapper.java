package com.nocountry.grupo10.Mapper;

import com.nocountry.grupo10.DTO.Request.LoanRequest;
import com.nocountry.grupo10.DTO.Response.LoanResponse;
import com.nocountry.grupo10.model.entity.Loan;
import com.nocountry.grupo10.util.LoanParameters;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    public Loan loanRequest2Loan(LoanRequest loanRequest){
        LoanParameters parameter = new LoanParameters();
        Loan loan = new Loan();
        loan.setRequiredMoney(loanRequest.getRequiredMoney());
        loan.setDues(loanRequest.getDues());
        loan.setState(Boolean.FALSE);
        // Estoy multiplicando por 12 y por 100 para guardar interes anual
        loan.setInterest(parameter.getInterestMontlyRate()*12*100);
        Double cuota = parameter.getMonthlyFee(loanRequest.getRequiredMoney(),loanRequest.getDues());
        loan.setMonthlyFee(cuota);
        loan.setTotalAmount(parameter.finalAmount(cuota, loanRequest.getDues()));
        return loan;
    }

    public LoanResponse loan2LoanResponse(Loan loan){
        LoanResponse response = new LoanResponse();
        response.setId(loan.getIdLoan());
        response.setRequiredMoney(loan.getRequiredMoney());
        response.setDues(loan.getDues());
        response.setState(loan.getState());
        response.setInterest(loan.getInterest());
        response.setMonthlyFee(loan.getMonthlyFee());
        response.setTotalAmount(loan.getTotalAmount());
        return response;
    }
}
