package org.registration.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.registration.api.RegistrationApi;
import org.registration.model.Record;
import org.registration.model.Request;
import org.registration.repository.CustomizedRecordInfoCrudRepository;
import org.registration.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RegistrationApiImpl implements RegistrationApi {
    private final RegistrationService registrationService;
    private final CustomizedRecordInfoCrudRepository recordInfoRepository;
    private final ModelMapper modelMapper;

    @Override
    public ResponseEntity<Void> addRequest(Integer clientId, Request request) {
        registrationService.startRegistration(request, clientId);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<Record>> getAllRequests() {
        return ResponseEntity.ok(recordInfoRepository.findAll().stream()
                .map(element -> modelMapper.map(element, Record.class))
                .collect(Collectors.toList()));
    }
}
