package org.registration.controller;

import lombok.RequiredArgsConstructor;
import org.registration.api.RequestApi;
import org.registration.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RequestApiImpl implements RequestApi {
    private final RegistrationService registrationService;


    @Override
    public ResponseEntity<Void> cancelRequest(Integer clientId) {
        registrationService.cancelRequest(clientId);

        return ResponseEntity.ok().build();
    }
}
