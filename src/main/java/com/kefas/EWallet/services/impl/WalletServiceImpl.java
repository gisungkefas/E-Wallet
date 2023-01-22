package com.kefas.EWallet.services.impl;

import com.kefas.EWallet.dtos.responseDtos.WalletResponseDto;
import com.kefas.EWallet.models.Wallet;
import com.kefas.EWallet.repositories.WalletRepository;
import com.kefas.EWallet.services.WalletServices;
import com.kefas.EWallet.utils.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WalletServiceImpl implements WalletServices {
    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private AppUtil appUtil;
    @Override
    public WalletResponseDto updateWallet(String email, BigDecimal amount) {

        Wallet wallet = walletRepository.findByEmail(email)
                .orElse(Wallet.builder()
                        .walletUUID(appUtil.generateSerialNumber("0"))
                        .balance(BigDecimal.ZERO)
                        .email(email)
                        .build());
        wallet.setBalance(wallet.getBalance().add(amount));
        wallet.setUpdatedAt();

        return appUtil.getMapper().convertValue(walletRepository.save(wallet), WalletResponseDto.class);
    }
}
