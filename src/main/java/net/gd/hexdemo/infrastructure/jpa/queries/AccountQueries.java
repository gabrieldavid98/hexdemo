package net.gd.hexdemo.infrastructure.jpa.queries;

import net.gd.hexdemo.application.queries.IAccountQueries;
import net.gd.hexdemo.application.results.AccountResult;
import net.gd.hexdemo.domain.accounts.ITransaction;
import net.gd.hexdemo.infrastructure.AccountNotFoundException;
import net.gd.hexdemo.infrastructure.jpa.entities.Account;
import net.gd.hexdemo.infrastructure.jpa.repositories.AccountJpaRepository;
import net.gd.hexdemo.infrastructure.jpa.repositories.CreditsJpaRepository;
import net.gd.hexdemo.infrastructure.jpa.repositories.DebitsJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public final class AccountQueries implements IAccountQueries {

    @Autowired
    private AccountJpaRepository accountJpaRepository;

    @Autowired
    private CreditsJpaRepository creditsJpaRepository;

    @Autowired
    private DebitsJpaRepository debitsJpaRepository;

    @Override
    public AccountResult getAccount(UUID accountId) {
        final Account account = accountJpaRepository.findById(accountId)
            .orElseThrow(() -> new AccountNotFoundException(
                String.format("The account %s does not exists or is already closed", accountId)
            ));

        final var credits = creditsJpaRepository.findByAccountId(accountId);
        final var debits = debitsJpaRepository.findByAccountId(accountId);

        return null;
    }
}
