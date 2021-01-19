package net.gd.hexdemo.application.results;

import java.time.LocalDateTime;

public final class TransactionResult {
    private final String description;
    private final double amount;
    private final LocalDateTime transactionDate;

    public TransactionResult(String description, double amount, LocalDateTime transactionDate) {
        this.description = description;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }
}
