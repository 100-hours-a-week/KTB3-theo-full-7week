package com.example.KTB_5WEEK.auth.service.encryption;

public interface Encrypt {

    String getAlgorithm();

    byte[] encrypt(String target, String secretKey);
}
