package net.gd.hexdemo.domain.accounts;

import net.gd.hexdemo.domain.DomainException;

public class AccountCannotBeClosedException extends DomainException {
    public AccountCannotBeClosedException(String message) {
        super(message);
    }
}
