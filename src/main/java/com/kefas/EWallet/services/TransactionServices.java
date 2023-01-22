package com.kefas.EWallet.services;

import com.kefas.EWallet.dtos.responseDtos.TransactionResponseDto;

public interface TransactionServices {

    TransactionResponseDto logTransaction(TransactionResponseDto transactionResponseDto);
}
