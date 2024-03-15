package io.github.ddebree.tigerbeetleapi.services;

import com.tigerbeetle.AccountBatch;
import com.tigerbeetle.Client;
import com.tigerbeetle.ConcurrencyExceededException;
import com.tigerbeetle.CreateAccountResultBatch;
import io.github.ddebree.tigerbeetleapi.converter.AccountBatchConverter;
import io.github.ddebree.tigerbeetleapi.converter.CreateAccountBatchResponseConverter;
import io.github.ddebree.tigerbeetleapi.dto.CreateAccountsRequest;
import io.github.ddebree.tigerbeetleapi.dto.CreateAccountsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateAccountService {

    private final AccountBatchConverter accountBatchConverter;
    private final CreateAccountBatchResponseConverter createAccountBatchResponseConverter;
    private final Client client;

    public CreateAccountsResponse createAccounts(CreateAccountsRequest createAccountsRequest) {
        AccountBatch accountBatch = accountBatchConverter.convert(createAccountsRequest);
        try {
            CreateAccountResultBatch accounts = client.createAccounts(accountBatch);
            return createAccountBatchResponseConverter.convert(accounts);
        } catch (ConcurrencyExceededException e) {
            throw new RuntimeException(e);
        }
    }

}
