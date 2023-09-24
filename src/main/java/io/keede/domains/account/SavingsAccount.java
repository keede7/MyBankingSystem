package io.keede.domains.account;

import io.keede.domains.account.enums.AccountType;
import io.keede.domains.account.exception.DissatisfiedWithdrawalCondition;

import java.math.BigDecimal;

/**
* @author keede
* Created on 2023/09/17
*/
public final class SavingsAccount extends Account {

    private final BigDecimal goalBalance;

    public SavingsAccount(
            final AccountType accountType,
            final String accountNo,
            final String owner,
            final BigDecimal goalBalance
    ) {
        super(accountType, accountNo, owner);
        this.goalBalance = goalBalance;
    }
    /**
     * 계좌 클래스에서 구현한 기본 클래스를 이용하여 계좌생성, 출금, 입금, 송금 메서드를 구현합니다. 메서드 내부적으로 입력값을 받는 액션이 있습니다.
     * 적금 계좌는 적금 계좌는 잔액이 목표 금액(%s원) 이상이어야 출금 가능하도록 상속받은 출금 메서드를 조금 다르게 구현해줍니다.
     */

    @Override
    public BigDecimal withdraw(final BigDecimal balance) {
        System.out.println("현재 잔액 = " + super.getBalance());
        System.out.println("출금 금액 = " + balance);

        this.checkWithdrawCondition();
        BigDecimal withdraw = super.withdraw(balance);

        System.out.println("적금계좌 잔액 = " + withdraw);
        return withdraw;
    }

    public void checkWithdrawCondition() {
        if(this.goalBalance.compareTo(super.getBalance()) > 0) {
            throw new DissatisfiedWithdrawalCondition();
        }
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

}
