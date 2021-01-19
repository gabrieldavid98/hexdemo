package net.gd.hexdemo.domain.accounts;

import net.gd.hexdemo.domain.IEntity;
import net.gd.hexdemo.domain.valueobjects.Amount;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.UUID;

public final class Credit implements IEntity, ITransaction {

    private UUID id;
    private UUID accountId;
    private Amount amount;
    private LocalDateTime transactionDate;

    public Credit() {}

    public Credit(UUID accountId, Amount amount) {
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
        return "Credit";
    }

    @Override
    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public static Credit load(UUID id, UUID accountId, Amount amount, LocalDateTime transactionDate) {
        var credit = new Credit();
        credit.id = id;
        credit.accountId = accountId;
        credit.amount = amount;
        credit.transactionDate = transactionDate;

        return credit;
    }
}
