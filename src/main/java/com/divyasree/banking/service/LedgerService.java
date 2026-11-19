package com.divyasree.banking.service;

import com.divyasree.banking.model.Account;
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LedgerService {
    private final Map<String, Account> accounts = new ConcurrentHashMap<>();

    public void createAccount(String accNo, String owner, BigDecimal initialDeposit) {
        accounts.put(accNo, new Account(accNo, owner, initialDeposit));
    }

    public synchronized boolean transfer(String fromAcc, String toAcc, BigDecimal amount) {
        Account sender = accounts.get(fromAcc);
        Account receiver = accounts.get(toAcc);
        if (sender == null || receiver == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }
        if (sender.getBalance().compareTo(amount) < 0) {
            return false; // Insufficient funds
        }
        sender.setBalance(sender.getBalance().subtract(amount));
        receiver.setBalance(receiver.getBalance().add(amount));
        return true;
    }

    public Account getAccount(String accNo) {
        return accounts.get(accNo);
    }
}
