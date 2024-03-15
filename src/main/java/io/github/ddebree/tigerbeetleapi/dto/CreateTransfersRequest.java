package io.github.ddebree.tigerbeetleapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateTransfersRequest {

    private List<Transfer> transfers;

    @Data
    public static class Transfer {

        private long idLeastSignificant;
        private long idMostSignificant;

        private long userData128LeastSignificant;
        private long userData128MostSignificant;
        private long userData64;
        private int userData32;

        private int ledger;
        private int code;
        private int flags;

    }
}
