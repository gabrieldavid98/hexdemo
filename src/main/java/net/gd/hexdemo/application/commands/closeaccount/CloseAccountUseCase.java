package net.gd.hexdemo.application.commands.closeaccount;

import net.gd.hexdemo.application.AccountNotFoundException;
import net.gd.hexdemo.application.repositories.IAccountReadOnlyRepository;
import net.gd.hexdemo.application.repositories.IAccountWriteOnlyRepository;
import net.gd.hexdemo.domain.accounts.Account;

import java.util.UUID;

public class CloseAccountUseCase implements ICloseAccountUseCase {

    private final IAccountReadOnlyRepository accountReadOnlyRepository;
    private final IAccountWriteOnlyRepository accountWriteOnlyRepository;

    public CloseAccountUseCase(
        IAccountReadOnlyRepository accountReadOnlyRepository,
        IAccountWriteOnlyRepository accountWriteOnlyRepository
    ) {
        this.accountReadOnlyRepository = accountReadOnlyRepository;
        this.accountWriteOnlyRepository = accountWriteOnlyRepository;
    }

    /**
     * Executes the use case
     * @param accountId UUID
     * @return UUID
     */
    public UUID execute(UUID accountId) {
        final Account account = accountReadOnlyRepository.get(accountId);
        if (account == null) {
            throw new AccountNotFoundException(
                String.format("The account %s does not exists or is already closed", accountId)
            );
        }

        account.close();
        accountWriteOnlyRepository.delete(account);

        return account.getId();
    }
}
