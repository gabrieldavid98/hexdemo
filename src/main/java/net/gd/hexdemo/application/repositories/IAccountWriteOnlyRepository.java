package net.gd.hexdemo.application.repositories;

import net.gd.hexdemo.domain.accounts.Account;
import net.gd.hexdemo.domain.accounts.Credit;
import net.gd.hexdemo.domain.accounts.Debit;

public interface IAccountWriteOnlyRepository {
    void add(Account account, Credit credit);
    void update(Account account, Credit credit);
    void update(Account account, Debit debit);
    void delete(Account account);
}
