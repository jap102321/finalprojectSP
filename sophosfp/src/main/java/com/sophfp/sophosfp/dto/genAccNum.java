package com.sophfp.sophosfp.dto;

import java.util.Random;

public class genAccNum {
    public static String genAccNum(String acc_type){
        String acc_num;
        String bank = "0123456789";
        int length = 8;
        StringBuilder builder = new StringBuilder(length);
        if(acc_type.equalsIgnoreCase("savings")){
            acc_num = "46";
            builder.append(acc_num);
        } else if (acc_type.equalsIgnoreCase("checking")) {
            acc_num = "23";
            builder.append(acc_num);
        }
        for(int x = 0; x < length; ++x ){
            double Random = Math.random() * (double)bank.length();
            int pos = (int)Random;
            char letter = bank.charAt(pos);
            builder.append(letter);
        }
        acc_num = builder.toString();
        return acc_num;
    }
}
