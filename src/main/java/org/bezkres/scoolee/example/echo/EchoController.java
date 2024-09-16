package org.bezkres.scoolee.example.echo;


import org.bezkres.scoolee.example.api.EchoApi;
import org.bezkres.scoolee.example.api.model.EchoRequest;
import org.bezkres.scoolee.example.api.model.EchoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
public class EchoController implements EchoApi {

    @Override
    public ResponseEntity<EchoResponse> sendEcho(EchoRequest echoRequest) {
        return ResponseEntity.ok(
                EchoResponse.
                        builder().
                        timestamp(OffsetDateTime.now()).
                        text(echoRequest.getText()).
                        build());
    }
}