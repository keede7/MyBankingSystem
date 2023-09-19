package io.keede.domains.account.enums;

import java.util.Arrays;

public enum AccountType {

    NORMAL,
    SAVINGS
    ;

    public boolean isMatchAccountType(AccountType accountType) {
        return Arrays.asList(values()).contains(accountType);
    }
}
