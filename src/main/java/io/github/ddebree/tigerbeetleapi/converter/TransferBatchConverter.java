package io.github.ddebree.tigerbeetleapi.converter;

import com.tigerbeetle.TransferBatch;
import io.github.ddebree.tigerbeetleapi.dto.CreateTransfersRequest;
import org.springframework.stereotype.Component;

@Component
public class TransferBatchConverter {

    public TransferBatch convert(CreateTransfersRequest createTransfersRequest) {
        TransferBatch transferBatch = new TransferBatch(createTransfersRequest.getTransfers().size());
        for (CreateTransfersRequest.Transfer transfer : createTransfersRequest.getTransfers()) {
            transferBatch.add();
            transferBatch.setId(transfer.getIdLeastSignificant(), transfer.getIdMostSignificant());
            transferBatch.setUserData128(transfer.getUserData128LeastSignificant(), transfer.getUserData128MostSignificant());
            transferBatch.setUserData64(transfer.getUserData64());
            transferBatch.setUserData32(transfer.getUserData32());
            transferBatch.setLedger(transfer.getLedger());
            transferBatch.setCode(transfer.getCode());
            transferBatch.setFlags(transfer.getFlags());
        }
        return transferBatch;
    }

}
