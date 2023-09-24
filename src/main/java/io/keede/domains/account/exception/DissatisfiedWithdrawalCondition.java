package io.keede.domains.account.exception;

/**
* @author keede
* Created on 2023/09/24
*/
public class DissatisfiedWithdrawalCondition extends RuntimeException {
    public DissatisfiedWithdrawalCondition() {
        super("적금계좌의 잔액이 목표금액보다 낮아 출금이 불가능합니다.");
    }
}
