package com.kefas.EWallet.services.impl;

import com.kefas.EWallet.dtos.responseDtos.TransactionResponseDto;
import com.kefas.EWallet.models.Transactions;
import com.kefas.EWallet.repositories.TransactionRepository;
import com.kefas.EWallet.services.TransactionServices;
import com.kefas.EWallet.utils.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionServices {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AppUtil appUtil;

    @Override
    public TransactionResponseDto logTransaction(TransactionResponseDto transactionResponseDto) {

        if (!transactionRepository
                .existsByReferenceOrId(transactionResponseDto.getReference(), transactionResponseDto.getId())) {

            Transactions transaction = appUtil.getMapper().convertValue(transactionResponseDto, Transactions.class);
            transaction.setCustomerEmail(transactionResponseDto.getCustomer().getEmail());
            transactionRepository.save(transaction);
        }

        return transactionResponseDto;
    }
}
