package net.gd.hexdemo.application.commands.withdraw;

import net.gd.hexdemo.application.results.TransactionResult;
import net.gd.hexdemo.domain.accounts.Debit;
import net.gd.hexdemo.domain.valueobjects.Amount;

public final class WithdrawResult {
    private final TransactionResult transaction;
    private final double updatedBalance;

    public WithdrawResult(Debit debit, Amount updatedBalance) {
        transaction = new TransactionResult(
            debit.getDescription(),
            debit.getAmount().getValue(),
            debit.getTransactionDate()
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
