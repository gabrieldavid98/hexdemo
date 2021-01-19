package net.gd.hexdemo.domain.accounts;

import net.gd.hexdemo.domain.DomainException;
import net.gd.hexdemo.domain.valueobjects.Amount;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class TransactionCollection {

    private final List<ITransaction> transactions;

    public TransactionCollection() {
        transactions = new ArrayList<>();
    }

    public List<ITransaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public ITransaction getLasTransaction() {
        return transactions.stream()
            .skip(transactions.size() - 1)
            .findFirst()
            .orElse(null);
    }

    public void add(ITransaction transaction) {
        transactions.add(transaction);
    }

    public void add(Collection<ITransaction> transactions) {
        this.transactions.addAll(transactions);
    }

    public Amount getCurrentBalance() {
        var total = transactions.stream()
            .reduce(0.0, (totalAmount, current) -> {
                if (current instanceof Debit) {
                    return totalAmount - current.getAmount().getValue();
                }

                return totalAmount + current.getAmount().getValue();
            }, Double::sum);

        return new Amount(total);
    }
}
