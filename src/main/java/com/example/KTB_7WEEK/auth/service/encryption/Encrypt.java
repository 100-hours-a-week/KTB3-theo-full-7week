package com.example.KTB_7WEEK.auth.service.encryption;

public interface Encrypt {

    String getAlgorithm();

    byte[] encrypt(String target, String secretKey);
}
