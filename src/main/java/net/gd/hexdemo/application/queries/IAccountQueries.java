package net.gd.hexdemo.application.queries;

import net.gd.hexdemo.application.results.AccountResult;

import java.util.UUID;

public interface IAccountQueries {
    AccountResult getAccount(UUID accountId);
}
