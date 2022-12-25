package com.sophfp.sophosfp.dto;

public class getTransac {

    public static String TransType(String transac_type){
        Double balance = null;
        Double amount = null;
        if(transac_type.equalsIgnoreCase("deposit")){
           balance = amount + balance;
           return balance.toString();
        }else if(transac_type.equalsIgnoreCase("Transfer")){
            if(balance < 0){
                return "You can't make a operation with negative numbers";
            }
            balance= amount - balance;
            return "Transaction Succesful";
        }else if(transac_type.equalsIgnoreCase("withdraw")){
            if(balance < 0){
                return "You can't make a operation with negative numbers";
            }
            balance = amount - balance;
        }
        return "Transaction Succesful";
    }
}
