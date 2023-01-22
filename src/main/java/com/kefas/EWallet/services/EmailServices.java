package com.kefas.EWallet.services;

import com.kefas.EWallet.dtos.requestDtos.MailDto;
import com.kefas.EWallet.dtos.responseDtos.ApiResponse;

public interface EmailServices {

    ApiResponse<MailDto> sendEmail(MailDto mailDto);
}
