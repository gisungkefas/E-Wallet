package com.kefas.EWallet.services;

import com.kefas.EWallet.dtos.paystack.AccountDto;
import com.kefas.EWallet.dtos.paystack.BankDto;
import com.kefas.EWallet.dtos.paystack.FundTransferDto;
import com.kefas.EWallet.dtos.paystack.InitiateTransactionDto;
import com.kefas.EWallet.dtos.responseDtos.ApiResponse;
import com.kefas.EWallet.dtos.responseDtos.TransactionResponseDto;

import java.util.List;

public interface PaymentServices {

    ApiResponse<List<BankDto>> fetchBanks(String currency, String type);

    ApiResponse<String> getPaymentLink(InitiateTransactionDto transactionDto);

    ApiResponse<TransactionResponseDto> verifyTransaction(String paymentReference);

    ApiResponse<AccountDto> getAccountDetails(String accountNumber, String bankCode);

    ApiResponse<FundTransferDto> createTransferRecipient(AccountDto accountDto);

    ApiResponse<TransactionResponseDto> initiateTransfer(FundTransferDto fundTransferDto);
}
