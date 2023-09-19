package io.keede.domains.bank;

/**
* @author keede
* Created on 2023/09/20
*/
public class Bank {
    /**
     * 계좌 클래스에서 구현한 기본 클래스를 이용하여 계좌생성, 출금, 입금, 송금 메서드를 구현합니다. 메서드 내부적으로 입력값을 받는 액션이 있습니다.
     * 적금 계좌는 적금 계좌는 잔액이 목표 금액(%s원) 이상이어야 출금 가능하도록 상속받은 출금 메서드를 조금 다르게 구현해줍니다.
     */

    // 계좌 생성
    public void createAccount() {}

    // 입금
    public void deposit() {}
    // 출금

    public void withdraw() {}

    // 송금
    public void transfer() {}
}
