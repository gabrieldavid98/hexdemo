package net.gd.hexdemo.application.commands.deposit;

import net.gd.hexdemo.domain.valueobjects.Amount;

import java.util.UUID;

public interface IDepositUseCase {

    /**
     * Executes the use case
     * @param accountId account id
     * @param amount the amount
     * @return deposit result
     */
    DepositResult execute(UUID accountId, Amount amount);
}
