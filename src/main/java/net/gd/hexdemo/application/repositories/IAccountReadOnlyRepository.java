package net.gd.hexdemo.application.repositories;

import net.gd.hexdemo.domain.accounts.Account;

import java.util.UUID;

public interface IAccountReadOnlyRepository {

    /**
     * Get an account by its id
     * @param id account id
     * @return the account
     */
    Account get(UUID id);
}
