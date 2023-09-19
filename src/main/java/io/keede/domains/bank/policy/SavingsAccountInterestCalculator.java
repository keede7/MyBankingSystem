package io.keede.domains.bank.policy;

import io.keede.domains.account.enums.AccountType;

import java.math.BigDecimal;

/**
* @author keede
* Created on 2023/09/20
*/
public class SavingsAccountInterestCalculator implements InterestCalculator {

    @Override
    public boolean match(AccountType accountType) {
        return false;
    }

    @Override
    public BigDecimal getInterest(BigDecimal balance) {
        return null;
    }

}
