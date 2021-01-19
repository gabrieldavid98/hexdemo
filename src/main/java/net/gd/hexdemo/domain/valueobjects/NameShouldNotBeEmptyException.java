package net.gd.hexdemo.domain.valueobjects;

import net.gd.hexdemo.domain.DomainException;

public class NameShouldNotBeEmptyException extends DomainException {
    public NameShouldNotBeEmptyException(String message) {
        super(message);
    }
}
