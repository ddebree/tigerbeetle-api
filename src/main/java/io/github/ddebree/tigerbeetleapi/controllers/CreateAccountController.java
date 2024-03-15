package io.github.ddebree.tigerbeetleapi.controllers;

import io.github.ddebree.tigerbeetleapi.dto.CreateAccountsRequest;
import io.github.ddebree.tigerbeetleapi.dto.CreateAccountsResponse;
import io.github.ddebree.tigerbeetleapi.services.CreateAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateAccountController {

    private final CreateAccountService createAccountService;
    @PostMapping("/accounts")
    public CreateAccountsResponse createAccounts(@RequestBody CreateAccountsRequest createAccountsRequest) {
        return createAccountService.createAccounts(createAccountsRequest);
    }

}
