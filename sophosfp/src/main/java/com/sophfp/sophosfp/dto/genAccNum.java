package com.sophfp.sophosfp.dto;

import java.util.Random;

public class genAccNum {
    public static String genAccNum(String acc_type){
        String accNumber;
        String bank = "0123456789";
        int length = 8;
        StringBuilder builder = new StringBuilder(length);
        if(acc_type.equalsIgnoreCase("savings")){
            accNumber = "46";
            builder.append(accNumber);
        } else if (acc_type.equalsIgnoreCase("checking")) {
            accNumber = "23";
            builder.append(accNumber);
        }
        for(int x = 0; x < length; ++x ){
            double Random = Math.random() * (double)bank.length();
            int pos = (int)Random;
            char letter = bank.charAt(pos);
            builder.append(letter);
        }
        accNumber = builder.toString();
        return accNumber;
    }
}
