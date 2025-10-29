package com.example.KTB_5WEEK.auth.service.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class Base64Decoder implements Decoder {
    private final Base64.Decoder decoder = Base64.getUrlDecoder();

    public byte[] decode(String target) {
        return decoder.decode(target);
    }
}
