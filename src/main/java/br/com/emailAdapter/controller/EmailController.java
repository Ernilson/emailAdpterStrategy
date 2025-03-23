package br.com.emailAdapter.controller;

import br.com.emailAdapter.dto.EmailDTO;
import br.com.emailAdapter.service.EmailAdapterService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

@RestController
@RequestMapping("/api/email")
@Tag(name = "Email Controller", description = "Endpoints para envio de e-mails")
public class EmailController {

    @Autowired
    private EmailAdapterService emailAdapterService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<String> sendEmail(@Valid @RequestBody EmailDTO emailDTO) throws Exception {
        Map<String, Object> adaptedData = emailAdapterService.adaptAndSerializeEmail(emailDTO);
        String json = objectMapper.writeValueAsString(adaptedData);
        System.out.println("Recebido: " + json);
        return ResponseEntity.noContent().build();
    }
}
