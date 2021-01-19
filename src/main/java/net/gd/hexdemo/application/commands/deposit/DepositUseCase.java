package net.gd.hexdemo.application.commands.deposit;

import net.gd.hexdemo.application.AccountNotFoundException;
import net.gd.hexdemo.application.repositories.IAccountReadOnlyRepository;
import net.gd.hexdemo.application.repositories.IAccountWriteOnlyRepository;
import net.gd.hexdemo.domain.accounts.Account;
import net.gd.hexdemo.domain.accounts.Credit;
import net.gd.hexdemo.domain.valueobjects.Amount;

import java.util.UUID;

public final class DepositUseCase implements IDepositUseCase {
    private final IAccountReadOnlyRepository accountReadOnlyRepository;
    private final IAccountWriteOnlyRepository accountWriteOnlyRepository;

    public DepositUseCase(
        IAccountReadOnlyRepository accountReadOnlyRepository,
        IAccountWriteOnlyRepository accountWriteOnlyRepository
    ) {
        this.accountReadOnlyRepository = accountReadOnlyRepository;
        this.accountWriteOnlyRepository = accountWriteOnlyRepository;
    }

    /**
     * Executes the use case
     * @param accountId account id
     * @param amount the amount
     * @return deposit result
     */
    @Override
    public DepositResult execute(UUID accountId, Amount amount) {
        final Account account = accountReadOnlyRepository.get(accountId);
        if (account == null) {
            throw new AccountNotFoundException(
                String.format("The account %s does not exists or is already closed", accountId)
            );
        }

        account.deposit(amount);
        final Credit credit = (Credit) account.getLastTransaction();

        accountWriteOnlyRepository.update(account, credit);

        return new DepositResult(credit, account.getCurrentBalance());
    }
}
