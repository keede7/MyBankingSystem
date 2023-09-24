package io.keede.domains.account;

import io.keede.domains.account.enums.AccountType;

import java.math.BigDecimal;

/**
* @author keede
* Created on 2023/09/17
*/
public final class SavingsAccount extends Account {

    private BigDecimal goalBalance;

    public SavingsAccount(
            final AccountType accountType,
            final String accountNo,
            final String owner,
            final BigDecimal goalBalance
    ) {
        super(accountType, accountNo, owner);
        this.goalBalance = goalBalance;
    }

    public BigDecimal getGoalBalance() {
        return this.goalBalance;
    }

    @Override
    public void getAccountInfo() {
        System.out.printf("적금계좌 정보 : %s", this);
    }

    @Override
    public String toString() {
        return String.format(
                "계좌종류 : %s, 목표금액: %s, 계좌번호: %s, 소유자: %s, 보유금액: %s, 활성화 여부: %s",
                this.getAccountType(), this.goalBalance,  this.getAccountNo(), this.getOwner(), this.getBalance(), this.isActive());
    }

    // TODO : HashCode, Equals Override
}
