package io.keede.domains.account;

import java.math.BigDecimal;

public class Balance {

    private final BigDecimal balance;

    public Balance(final BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal increase(final BigDecimal balance) {
        return this.balance.plus().add(balance);
    }

    public BigDecimal decrease(final BigDecimal balance) {
        return this.balance.negate().add(balance);
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "balance=" + balance +
                '}';
    }
}
