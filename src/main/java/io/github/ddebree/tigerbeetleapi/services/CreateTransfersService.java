package io.github.ddebree.tigerbeetleapi.services;

import com.tigerbeetle.Client;
import com.tigerbeetle.ConcurrencyExceededException;
import com.tigerbeetle.CreateTransferResultBatch;
import com.tigerbeetle.TransferBatch;
import io.github.ddebree.tigerbeetleapi.converter.CreateTransferBatchResponseConverter;
import io.github.ddebree.tigerbeetleapi.converter.TransferBatchConverter;
import io.github.ddebree.tigerbeetleapi.dto.CreateTransfersRequest;
import io.github.ddebree.tigerbeetleapi.dto.CreateTransfersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateTransfersService {

    private final TransferBatchConverter transferBatchConverter;
    private final CreateTransferBatchResponseConverter createTransferBatchResponseConverter;
    private final Client client;

    public CreateTransfersResponse createTransfers(CreateTransfersRequest createTransfersRequest) {
        TransferBatch transferBatch = transferBatchConverter.convert(createTransfersRequest);
        try {
            CreateTransferResultBatch transfers = client.createTransfers(transferBatch);
            return createTransferBatchResponseConverter.convert(transfers);
        } catch (ConcurrencyExceededException e) {
            throw new RuntimeException(e);
        }
    }

}
