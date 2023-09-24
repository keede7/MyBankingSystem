package io.keede.domains.account.exception;

/**
* @author keede
* Created on 2023/09/24
*/
public class NotEnoughBalanceException extends RuntimeException {
    public NotEnoughBalanceException() {
        super("잔액이 부족합니다.");
    }
}
