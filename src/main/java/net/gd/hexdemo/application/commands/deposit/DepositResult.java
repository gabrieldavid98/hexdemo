package net.gd.hexdemo.application.commands.deposit;

import net.gd.hexdemo.application.results.TransactionResult;
import net.gd.hexdemo.domain.accounts.Credit;
import net.gd.hexdemo.domain.valueobjects.Amount;

public final class DepositResult {
    private final TransactionResult transaction;
    private final double updatedBalance;

    public DepositResult(Credit credit, Amount updatedBalance) {
        transaction = new TransactionResult(
            credit.getDescription(),
            credit.getAmount().getValue(),
            credit.getTransactionDate()
        );

        this.updatedBalance = updatedBalance.getValue();
    }

    public TransactionResult getTransaction() {
        return transaction;
    }

    public double getUpdatedBalance() {
        return updatedBalance;
    }
}
