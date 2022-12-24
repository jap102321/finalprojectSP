package com.sophfp.sophosfp.dto;

import com.sophfp.sophosfp.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientReq {

    private Client client;
}
