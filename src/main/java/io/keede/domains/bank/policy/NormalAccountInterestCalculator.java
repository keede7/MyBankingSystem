package io.keede.domains.bank.policy;

import io.keede.domains.account.enums.AccountType;

import java.math.BigDecimal;

/**
* @author keede
* Created on 2023/09/20
*/
public class NormalAccountInterestCalculator implements InterestCalculator {

    /**
     * 일반 예금 계좌인 경우 1000만원 이상은 이자율이 50%, 500만원 이상은 7%, 100만원 이상은 4%, 1만원 이상은 2%, 그 외에는 1% 이자를 제공해줍니다.
     */
    @Override
    public boolean match(AccountType accountType) {
        return AccountType.NORMAL.isMatchAccountType(accountType);
    }

    @Override
    public BigDecimal getInterest(BigDecimal balance) {
        long money = balance.longValue();

        if(money >= 10_000_000L) {
            return BigDecimal.valueOf(money * 0.5);
        } else if(money >= 5_000_000L) {
            return BigDecimal.valueOf(money * 0.07);
        } else if(money >= 1_000_000L) {
            return BigDecimal.valueOf(money * 0.04);
        } else if(money >= 10_000L) {
            return BigDecimal.valueOf(money * 0.02);
        }

        return BigDecimal.valueOf(money * 0.01);
    }
}
