package com.model.common.user;

import com.model.entity.model.Account;

/**
 * @author Morning JS
 * @date 2021/4/16 10:08
 * @desc
 */
public class UserThreadLocalDTO {

    private static final ThreadLocal<Account> threadLocal = new ThreadLocal<>();

    public static Account getThreadLocal() {
        Account account = UserThreadLocalDTO.threadLocal.get();
        return account;
    }

    public static void setThreadLocal(Account account) {
        threadLocal.set(account);
    }

    public static void clear() {
        threadLocal.remove();
    }
}