package wxy.dao;

import wxy.domain.Account;

/**
 * 账户的持久层操作
 */
public interface IAccountDao {

    Account findAccountById(Integer accountId);

    Account findAccountByName(String accountName);

    void updateAccount(Account account);
}
