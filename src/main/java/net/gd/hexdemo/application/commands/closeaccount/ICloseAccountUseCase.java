package net.gd.hexdemo.application.commands.closeaccount;

import java.util.UUID;

public interface ICloseAccountUseCase {

    /**
     * Executes the use case
     * @param accountId UUID
     * @return UUID
     */
    UUID execute(UUID accountId);
}
