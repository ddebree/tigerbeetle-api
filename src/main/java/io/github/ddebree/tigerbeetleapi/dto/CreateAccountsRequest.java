package io.github.ddebree.tigerbeetleapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateAccountsRequest {

    private List<Account> accounts;

    @Data
    public static class Account {

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
