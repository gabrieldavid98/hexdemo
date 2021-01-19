package net.gd.hexdemo.domain.accounts;

import net.gd.hexdemo.domain.IEntity;
import net.gd.hexdemo.domain.valueobjects.Amount;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.UUID;

public final class Debit implements IEntity, ITransaction {

    private UUID id;
    private UUID accountId;
    private Amount amount;
    private LocalDateTime transactionDate;

    public Debit() {}

    public Debit(UUID accountId, Amount amount) {
        this.id = UUID.randomUUID();
        this.accountId = accountId;
        this.amount = amount;
        this.transactionDate = LocalDateTime.now(Clock.systemUTC());
    }

    public UUID getAccountId() {
        return accountId;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public Amount getAmount() {
        return amount;
    }

    @Override
    public String getDescription() {
        return "Debit";
    }

    @Override
    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public static Debit load(UUID id, UUID accountId, Amount amount, LocalDateTime transactionDate) {
        var debit = new Debit();
        debit.id = id;
        debit.accountId = accountId;
        debit.amount = amount;
        debit.transactionDate = transactionDate;

        return debit;
    }
}
