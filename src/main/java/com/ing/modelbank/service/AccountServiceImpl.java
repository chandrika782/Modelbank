package com.ing.modelbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.modelbank.dto.ResponseAccountDto;
import com.ing.modelbank.entity.Account;
import com.ing.modelbank.exception.AccountNotFoundException;
import com.ing.modelbank.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	ResponseAccountDto responseAccountDto;

	@Override
	public ResponseAccountDto getAccountSummary(Integer accountNumber) {

		Account account = accountRepository.findByAccountNumber(accountNumber);
		if (account != null) {

			responseAccountDto = new ResponseAccountDto();
			responseAccountDto.setAccountId(account.getAccountId());
			responseAccountDto.setAccountNumber(account.getAccountNumber());
			responseAccountDto.setAccountType(account.getAccountType());
			responseAccountDto.setBalance(account.getBalance());
			return responseAccountDto;
		} else {
			throw new AccountNotFoundException();
		}

	}

}
