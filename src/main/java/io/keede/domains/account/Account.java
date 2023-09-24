package io.keede.domains.account;

import io.keede.domains.account.enums.AccountType;
import io.keede.domains.account.exception.NotEnoughBalanceException;

import java.math.BigDecimal;

/**
 * @author keede
 * Created on 2023/09/17
 */
public class Account {

    /**
     * 계좌 클래스 설계와 구현
     * 계좌(일반 예금 계좌)에는 일반 예금 계좌와 적금 계좌가 있습니다. 계좌 클래스의 속성은 계좌종류(N: 예금계좌, S:적금계좌), 계좌번호, 소유자, 잔액, 활성화 여부 다섯 가지 입니다.
     * 적금 계좌 클래스는 일반 예금 계좌 클래스에서 상속을 받고 목표 금액 속성이 추가 됩니다.
     * 일반 예금 계좌 클래스의 각 속성에 getter/setter를 제공하고, 계좌 정보를 보여주는 getAccountInfo() 메서드를 구현합니다.
     * 적금 계좌 클래스는 이 메서드를 재정의 하여 목표 금액 정보도 보여주도록 합니다.
     * 뱅크 클래스에서 호출할 출금, 입금 기본 메서드를 생성합니다.
     */
    private final AccountType accountType;
    private final String accountNo;
    private final String owner;
    private BigDecimal balance;
    private boolean isActive;

    public Account(
            final AccountType accountType,
            final String accountNo,
            final String owner
    ) {
        this.accountType = accountType;
        this.accountNo = accountNo;
        this.owner = owner;
        this.balance = BigDecimal.ZERO;
        this.isActive = true;
    }

    public void getAccountInfo() {
        System.out.printf("일반계좌 정보 : %s", this);
    }

    public BigDecimal deposit(final BigDecimal balance) {
        this.balance = this.balance.add(balance);
        return this.balance;
    }

    public BigDecimal withdraw(final BigDecimal balance) {
        if(this.balance.compareTo(balance) < 0) {
            throw new NotEnoughBalanceException();
        }

        this.balance = this.balance.subtract(balance);
        return this.balance;
    }

    public AccountType getAccountType() {
        return this.accountType;
    }

    public String getAccountNo() {
        return this.accountNo;
    }

    public String getOwner() {
        return this.owner;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        return String.format(
                "계좌종류 : %s, 계좌번호: %s, 소유자: %s, 보유금액: %s, 활성화 여부: %s",
                this.accountType,  this.accountNo, this.owner, this.balance, this.isActive);
    }

    // TODO : HashCode, Equals Override
}
