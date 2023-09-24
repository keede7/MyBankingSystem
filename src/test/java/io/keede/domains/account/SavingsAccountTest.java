package io.keede.domains.account;

import io.keede.domains.account.enums.AccountType;
import io.keede.domains.account.exception.DissatisfiedWithdrawalCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;



/**
* @author keede
* Created on 2023/09/24
*/
class SavingsAccountTest {

    private Account account;

    private static final int DEFAULT_GOAL_BALANCE = 500_000;
    private static final int DEFAULT_BALANCE = 600_000;
    private static final BigDecimal GOAL_BALANCE = new BigDecimal(DEFAULT_GOAL_BALANCE);


    @BeforeEach
    void setUp() {
        this.account = new SavingsAccount(
                AccountType.SAVINGS,
                "8828928",
                "Owner2",
                GOAL_BALANCE
        );
        this.account.deposit(new BigDecimal(DEFAULT_BALANCE));
    }

    @Test
    void 적금계좌_입금_성공() {
        
        final int depositBalance = 1_000;

        BigDecimal toDeposit = new BigDecimal(depositBalance);

        BigDecimal deposit = account.deposit(toDeposit);

        BigDecimal sut = new BigDecimal(DEFAULT_BALANCE + depositBalance);

        assertEquals(deposit, sut);
    }

    @Test
    void 적금계좌_출금_성공() {
        BigDecimal toWithdrawal = new BigDecimal(DEFAULT_GOAL_BALANCE);

        assertDoesNotThrow(() -> account.withdraw(toWithdrawal));
    }

    @Test
    void 적금계좌_출금_실패() {
        BigDecimal toWithdrawal = new BigDecimal(DEFAULT_GOAL_BALANCE);

        account.withdraw(toWithdrawal);

        assertThrows(DissatisfiedWithdrawalCondition.class,
                () -> account.withdraw(toWithdrawal)
        );
    }

}