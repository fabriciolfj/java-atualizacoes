package br.com.github;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private static AtomicInteger nextAccountId = new AtomicInteger(1);
    private final Lock lock = new ReentrantLock();

    private double balance;
    private final int accountId;

    public Account(int openingBalance) {
        balance = openingBalance;
        accountId = nextAccountId.getAndIncrement();
    }

    public boolean transferTo(Account other, int amount) {
        if (accountId == other.getAccountId()) {
            return false;
        }

        var firstLock = accountId < other.getAccountId() ? lock : other.lock;
        var secondLock = firstLock == lock ? other.lock : lock;

        firstLock.lock();
        try {
            secondLock.lock();
            try {
                if (balance >= amount) {
                    balance = balance - amount;
                    other.rawDeposit(amount);
                    return true;
                }

                return false;
            } finally {
                secondLock.unlock();
            }
        } finally {
            firstLock.unlock();
        }
    }

    public boolean rawWithdraw(int amount) {
        // Check to see amount > 0, throw if not
        if (balance >= amount) {
            balance = balance - amount;
            return true;
        }
        return false;
    }

    public void rawDeposit(double amount) {
        // Check to see amount > 0, throw if not
        balance = balance + amount;
    }

    public double getRawBalance() {
        return balance;
    }

    public boolean safeWithdraw(final int amount) {
        // Check to see amount > 0, throw if not
        synchronized (this) {
            if (balance >= amount) {
                balance = balance - amount;
                return true;
            }
        }
        return false;
    }

    public void safeDeposit(final int amount) {
        // Check to see amount > 0, throw if not
        synchronized (this) {
            balance = balance + amount;
        }
    }

    public double getSafeBalance() {
        synchronized (this) {
            return balance;
        }
    }

    public int getAccountId() {
        return accountId;
    }
}