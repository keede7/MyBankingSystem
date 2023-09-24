package io.keede.domains.account;

import io.keede.domains.account.enums.AccountType;
import io.keede.domains.account.exception.NotEnoughBalanceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
* @author keede
* Created on 2023/09/24
*/
class AccountTest {

    private Account account;

    private static final int DEFAULT_BALANCE = 30000;

    @BeforeEach
    void setUp() {
        this.account = new Account(AccountType.NORMAL, "0102922", "Owner");
        this.account.deposit(new BigDecimal(DEFAULT_BALANCE));
    }

    @Test
    void 계좌_보유금액_압금_성공() {

        final int depositBalance = 1000;

        BigDecimal deposit = account.deposit(new BigDecimal(depositBalance));

        BigDecimal toDepositBalance = new BigDecimal(DEFAULT_BALANCE + depositBalance);

        assertEquals(deposit, toDepositBalance);

    }

    @Test
    void 계좌_보유금액_출금_성공() {

        final int withdrawBalance = 2000;

        BigDecimal withdraw = account.withdraw(new BigDecimal(withdrawBalance));

        BigDecimal toWithdrawBalance = new BigDecimal(DEFAULT_BALANCE - withdrawBalance);

        assertEquals(withdraw, toWithdrawBalance);
    }

    @Test
    void 계좌_보유금액_출금_실패() {

        final int withdrawBalance = 44000;

        assertThrows(NotEnoughBalanceException.class,
                () -> account.withdraw(new BigDecimal(withdrawBalance))
        );
    }

}