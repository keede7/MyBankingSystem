package io.keede.domains.account.exception;

public class NotEnoughBalanceException extends RuntimeException {
    public NotEnoughBalanceException() {
        super("잔액이 부족합니다.");
    }
}
