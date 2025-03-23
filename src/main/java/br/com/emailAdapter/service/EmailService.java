package br.com.emailAdapter.service;

import br.com.emailAdapter.dto.EmailAwsDTO;
import br.com.emailAdapter.dto.EmailDTO;
import br.com.emailAdapter.dto.EmailOciDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${mail.integracao}")
    private String integracao;

    private final ObjectMapper objectMapper;

    public EmailService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void processEmail(EmailDTO emailDTO) throws JsonProcessingException {
        String json;

        if ("AWS".equalsIgnoreCase(integracao)) {
            EmailAwsDTO awsDTO = new EmailAwsDTO();
            // Adaptar os dados de emailDTO para awsDTO
            json = objectMapper.writeValueAsString(awsDTO);
        } else if ("OCI".equalsIgnoreCase(integracao)) {
            EmailOciDTO ociDTO = new EmailOciDTO();
            // Adaptar os dados de emailDTO para ociDTO
            json = objectMapper.writeValueAsString(ociDTO);
        } else {
            throw new IllegalArgumentException("Integração não suportada");
        }

        System.out.println(json);
    }
}
