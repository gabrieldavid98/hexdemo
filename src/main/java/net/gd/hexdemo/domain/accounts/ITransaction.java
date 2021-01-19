package net.gd.hexdemo.domain.accounts;

import net.gd.hexdemo.domain.valueobjects.Amount;

import java.time.LocalDateTime;

public interface ITransaction {
    Amount getAmount();
    String getDescription();
    LocalDateTime getTransactionDate();
}
