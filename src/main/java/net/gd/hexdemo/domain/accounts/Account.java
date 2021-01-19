package net.gd.hexdemo.domain.accounts;

import net.gd.hexdemo.domain.IAggregateRoot;
import net.gd.hexdemo.domain.IEntity;
import net.gd.hexdemo.domain.valueobjects.Amount;

import java.util.List;
import java.util.UUID;

public final class Account implements IEntity, IAggregateRoot {
    private UUID id;
    private UUID customerId;
    private TransactionCollection transactions;

    private Account() {}

    public Account(UUID customerId) {
        id = UUID.randomUUID();
        this.customerId = customerId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public List<ITransaction> getTransactions() {
        return transactions.getTransactions();
    }

    @Override
    public UUID getId() {
        return id;
    }

    public void deposit(Amount amount) {
        final var credit = new Credit(id, amount);
        transactions.add(credit);
    }

    public void withdraw(Amount amount) {
        if (transactions.getCurrentBalance().getValue() < amount.getValue()) {
            throw new InsuficientFundsException(
                String.format("The account %s does not have enough funds to withdraw %s.", id, amount)
            );
        }

        final var debit = new Debit(id, amount);
        transactions.add(debit);
    }

    public void close() {
        if (transactions.getCurrentBalance().getValue() > 0) {
            throw new AccountCannotBeClosedException(
                String.format("The account %s can not be closed because it has funds.", id)
            );
        }
    }

    public Amount getCurrentBalance() {
        return transactions.getCurrentBalance();
    }

    public ITransaction getLastTransaction() {
        return transactions.getLasTransaction();
    }

    public static Account load(UUID id, UUID customerId, TransactionCollection transactions) {
        final var account = new Account();
        account.id = id;
        account.customerId = customerId;
        account.transactions = transactions;

        return account;
    }
}
