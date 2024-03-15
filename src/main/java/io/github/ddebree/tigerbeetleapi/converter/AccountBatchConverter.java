package io.github.ddebree.tigerbeetleapi.converter;

import com.tigerbeetle.AccountBatch;
import io.github.ddebree.tigerbeetleapi.dto.CreateAccountsRequest;
import org.springframework.stereotype.Component;

@Component
public class AccountBatchConverter {

    public AccountBatch convert(CreateAccountsRequest createAccountsRequest) {
        com.tigerbeetle.AccountBatch accountBatch = new com.tigerbeetle.AccountBatch(createAccountsRequest.getAccounts().size());
        for (CreateAccountsRequest.Account account : createAccountsRequest.getAccounts()) {
            accountBatch.add();
            accountBatch.setId(account.getIdLeastSignificant(), account.getIdMostSignificant());
            accountBatch.setUserData128(account.getUserData128LeastSignificant(), account.getUserData128MostSignificant());
            accountBatch.setUserData64(account.getUserData64());
            accountBatch.setUserData32(account.getUserData32());
            accountBatch.setLedger(account.getLedger());
            accountBatch.setCode(account.getCode());
            accountBatch.setFlags(account.getFlags());
        }
        return accountBatch;
    }

}
