package io.keede.domains.account.enums;

import io.keede.domains.account.Account;

import java.math.BigDecimal;

/**
* @author keede
* Created on 2023/09/17
*/
public final class SavingsAccount extends Account {

    private BigDecimal 목표금액;

    public SavingsAccount(
            final AccountType accountType,
            final String accountNo,
            final String owner,
            final BigDecimal 목표금액
    ) {
        super(accountType, accountNo, owner);
        this.목표금액 = 목표금액;
    }

    public BigDecimal get목표금액() {
        return this.목표금액;
    }

    @Override
    public Account getAccountInfo() {
        return this;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "목표금액=" + 목표금액 +
                '}';
    }

    // TODO : HashCode, Equals Override
}
