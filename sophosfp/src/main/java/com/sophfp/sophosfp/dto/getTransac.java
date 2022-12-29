package com.sophfp.sophosfp.dto;


public class getTransac {

    public static Double getTransac(Double amount, Double balance, String transac_type){
        if(transac_type.equalsIgnoreCase("deposit")){
          balance= amount + balance;
          return balance;
        }
        return balance;
    }
}
