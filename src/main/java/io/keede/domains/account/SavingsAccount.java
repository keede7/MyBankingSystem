package io.keede.domains.account;

import io.keede.domains.account.Account;
import io.keede.domains.account.enums.AccountType;

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
    public void getAccountInfo() {
        System.out.printf("적금계좌 정보 : %s", this);
    }

    @Override
    public String toString() {
        return String.format(
                "계좌종류 : %s, 목표금액: %s, 계좌번호: %s, 소유자: %s, 보유금액: %s, 활성화 여부: %s",
                this.getAccountType(), this.목표금액,  this.getAccountNo(), this.getOwner(), this.보유금액(), this.isActive());
    }

    // TODO : HashCode, Equals Override
}
