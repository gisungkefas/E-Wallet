package com.kefas.EWallet.services;

import com.kefas.EWallet.dtos.responseDtos.WalletResponseDto;

import java.math.BigDecimal;

public interface WalletServices {

    WalletResponseDto updateWallet(String email, BigDecimal amount);
}
