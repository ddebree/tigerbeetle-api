package io.github.ddebree.tigerbeetleapi.converter;

import com.tigerbeetle.CreateAccountResultBatch;
import io.github.ddebree.tigerbeetleapi.dto.CreateAccountsResponse;
import org.springframework.stereotype.Component;

@Component
public class CreateAccountBatchResponseConverter {

    public CreateAccountsResponse convert(CreateAccountResultBatch accounts) {
        //TODO: Do something with the return...
        if (accounts.getLength() > 0) {
            while (accounts.next()) {
                System.err.printf("Error creating account #%d -> %s\n",
                        accounts.getIndex(), accounts.getResult());
            }
        }
        return new CreateAccountsResponse();
    }

}
