package io.keede.domains.bank.policy;

import java.math.BigDecimal;

/**
* @author keede
* Created on 2023/09/20
*/
public interface InterestCalculator {
    BigDecimal getInterest(BigDecimal balance);
}
