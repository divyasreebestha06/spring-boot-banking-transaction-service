package com.divyasree.banking.controller;

import com.divyasree.banking.service.LedgerService;
import java.math.BigDecimal;

public class TransactionController {
    private final LedgerService ledger;

    public TransactionController(LedgerService ledger) {
        this.ledger = ledger;
    }

    public String handleTransfer(String from, String to, double amount) {
        boolean ok = ledger.transfer(from, to, BigDecimal.valueOf(amount));
        return ok ? "TRANSFER_CONFIRMED" : "TRANSFER_REJECTED";
    }
}
