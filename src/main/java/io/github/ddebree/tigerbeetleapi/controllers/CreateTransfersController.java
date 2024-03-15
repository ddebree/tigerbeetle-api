package io.github.ddebree.tigerbeetleapi.controllers;

import io.github.ddebree.tigerbeetleapi.dto.CreateTransfersRequest;
import io.github.ddebree.tigerbeetleapi.dto.CreateTransfersResponse;
import io.github.ddebree.tigerbeetleapi.services.CreateTransfersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateTransfersController {

    private final CreateTransfersService createTransfersService;
    @PostMapping("/transfers")
    public CreateTransfersResponse createTransfers(@RequestBody CreateTransfersRequest createTransfersRequest) {
        return createTransfersService.createTransfers(createTransfersRequest);
    }

}
