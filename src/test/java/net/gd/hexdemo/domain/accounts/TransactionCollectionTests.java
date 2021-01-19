package net.gd.hexdemo.domain.accounts;

import net.gd.hexdemo.domain.valueobjects.Amount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class TransactionCollectionTests {
    @Test
    void should_computeTheBalance() {
        final var trans = new TransactionCollection();
        trans.add(new Credit(UUID.randomUUID(), new Amount(10)));
        trans.add(new Credit(UUID.randomUUID(), new Amount(30)));
        trans.add(new Debit(UUID.randomUUID(), new Amount(20)));

        final var actual = trans.getCurrentBalance();

        Assertions.assertEquals(20, actual.getValue());
    }
}
