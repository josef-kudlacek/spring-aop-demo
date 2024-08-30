package eu.kudljo.aopdemo.dao;

import eu.kudljo.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);

    boolean doWork();
}
