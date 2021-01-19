package net.gd.hexdemo.infrastructure;

public final class AccountNotFoundException extends InfrastructureException {
    public AccountNotFoundException(String message) {
        super(message);
    }
}
