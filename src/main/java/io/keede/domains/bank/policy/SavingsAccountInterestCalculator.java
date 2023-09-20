package io.keede.domains.bank.policy;

import io.keede.domains.account.enums.AccountType;

import java.math.BigDecimal;

/**
* @author keede
* Created on 2023/09/20
*/
public class SavingsAccountInterestCalculator implements InterestCalculator {

    /**
     * 적금 계좌의 경우 100만원 이상은 이자율이 50%, 그 외에는 1% 이자를 제공해줍니다.
     */
    @Override
    public boolean match(AccountType accountType) {
        return AccountType.SAVINGS.isMatchAccountType(accountType);
    }

    @Override
    public BigDecimal getInterest(BigDecimal balance) {

        long money = balance.longValue();

        if(money >= 1_000_000L) {
            return BigDecimal.valueOf(money * 0.5);
        }

        return BigDecimal.valueOf(money * 0.01);
    }

}
