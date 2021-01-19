package net.gd.hexdemo.application.results;

import net.gd.hexdemo.domain.accounts.Account;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public final class AccountResult {
    private final UUID accountId;
    private final double currentBalance;
    private final List<TransactionResult> transactions;

    public AccountResult(UUID accountId, double currentBalance, List<TransactionResult> transactions) {
        this.accountId = accountId;
        this.currentBalance = currentBalance;
        this.transactions = transactions;
    }

    public AccountResult(Account account) {
        accountId = account.getId();
        currentBalance = account.getCurrentBalance().getValue();
        transactions = account.getTransactions().stream()
            .map(transaction ->
                new TransactionResult(
                    transaction.getDescription(),
                    transaction.getAmount().getValue(),
                    transaction.getTransactionDate()
                )
            ).collect(Collectors.toList());
    }

    public UUID getAccountId() {
        return accountId;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public List<TransactionResult> getTransactions() {
        return transactions;
    }
}
