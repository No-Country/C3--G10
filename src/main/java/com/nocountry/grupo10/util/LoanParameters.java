package com.nocountry.grupo10.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LoanParameters {

    private double interestMontlyRate;

    public LoanParameters() {
        this.interestMontlyRate = 0.043;
    }

    public double getInterestMontlyRate() {
        return interestMontlyRate;
    }

    public void setInterestMontlyRate(double interestMontlyRate) {
        this.interestMontlyRate = interestMontlyRate;
    }

    /**
     *
     * @param capital Monto pedido por el Usuario
     * @param dues Cantidad de Cuotas que Solicito el Usuario
     * @return el monto que se pagara por cada cuota
     */
    public Double getMonthlyFee(Long capital, Integer dues){
        Double auxDenominadorPartentesis = Math.pow((1+interestMontlyRate),-dues);
        Double cuota = (capital*interestMontlyRate)/(1-auxDenominadorPartentesis);
        BigDecimal bd = new BigDecimal(Double.toString(cuota));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /**
     *
     * @param cuota monto de la cuota
     * @param dues cantidad de cuotas
     * @return
     */
    public Double finalAmount(Double cuota, Integer dues){
        Double finalAmount = cuota*dues;
        BigDecimal bd = new BigDecimal(Double.toString(finalAmount));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
