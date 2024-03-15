package io.github.ddebree.tigerbeetleapi.converter;

import com.tigerbeetle.CreateTransferResultBatch;
import io.github.ddebree.tigerbeetleapi.dto.CreateTransfersResponse;
import org.springframework.stereotype.Component;

@Component
public class CreateTransferBatchResponseConverter {

    public CreateTransfersResponse convert(CreateTransferResultBatch transfers) {
        //TODO: Do something with the return...
        if (transfers.getLength() > 0) {
            while (transfers.next()) {
                System.err.printf("Error creating transfer #%d -> %s\n",
                        transfers.getIndex(), transfers.getResult());
            }
        }
        return new CreateTransfersResponse();
    }

}
