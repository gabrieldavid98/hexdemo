package net.gd.hexdemo.application.commands.withdraw;

import net.gd.hexdemo.domain.valueobjects.Amount;

import java.util.UUID;

public interface IWithdrawUseCase {

    /**
     * Executes the use case
     * @param accountId the account id
     * @param amount the amount
     * @return a withdraw result
     */
    WithdrawResult execute(UUID accountId, Amount amount);
}
