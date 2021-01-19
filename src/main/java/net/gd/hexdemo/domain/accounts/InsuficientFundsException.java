package net.gd.hexdemo.domain.accounts;

import net.gd.hexdemo.domain.DomainException;

public class InsuficientFundsException extends DomainException {
    public InsuficientFundsException(String message) {
        super(message);
    }
}
