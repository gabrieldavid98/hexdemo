package net.gd.hexdemo.application.commands.withdraw;

import net.gd.hexdemo.application.AccountNotFoundException;
import net.gd.hexdemo.application.repositories.IAccountReadOnlyRepository;
import net.gd.hexdemo.application.repositories.IAccountWriteOnlyRepository;
import net.gd.hexdemo.domain.accounts.Account;
import net.gd.hexdemo.domain.accounts.Debit;
import net.gd.hexdemo.domain.valueobjects.Amount;

import java.util.UUID;

public class WithdrawUseCase implements IWithdrawUseCase {
    private final IAccountReadOnlyRepository accountReadOnlyRepository;
    private final IAccountWriteOnlyRepository accountWriteOnlyRepository;

    public WithdrawUseCase(
        IAccountReadOnlyRepository accountReadOnlyRepository,
        IAccountWriteOnlyRepository accountWriteOnlyRepository
    ) {
        this.accountReadOnlyRepository = accountReadOnlyRepository;
        this.accountWriteOnlyRepository = accountWriteOnlyRepository;
    }

    /**
     * Executes the use case
     * @param accountId the account id
     * @param amount the amount
     * @return a withdraw result
     */
    @Override
    public WithdrawResult execute(UUID accountId, Amount amount) {
        final Account account = accountReadOnlyRepository.get(accountId);
        if (account == null) {
            throw new AccountNotFoundException(
                String.format("The account %s does not exists or is already closed", accountId)
            );
        }

        account.withdraw(amount);
        final Debit debit = (Debit) account.getLastTransaction();

        accountWriteOnlyRepository.update(account, debit);

        return new WithdrawResult(debit, account.getCurrentBalance());
    }
}
