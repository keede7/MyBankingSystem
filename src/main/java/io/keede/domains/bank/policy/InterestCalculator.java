package io.keede.domains.bank.policy;

import io.keede.domains.account.enums.AccountType;

import java.math.BigDecimal;

/**
* @author keede
* Created on 2023/09/20
*/
public interface InterestCalculator {

    boolean match(AccountType accountType);

    BigDecimal getInterest(BigDecimal balance);

}
