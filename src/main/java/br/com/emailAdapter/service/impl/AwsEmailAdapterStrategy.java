package br.com.emailAdapter.service.impl;

import br.com.emailAdapter.dto.EmailAwsDTO;
import br.com.emailAdapter.dto.EmailDTO;
import br.com.emailAdapter.service.EmailAdapterStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AwsEmailAdapterStrategy implements EmailAdapterStrategy {
    @Override
    public Map<String, Object> adaptEmail(EmailDTO emailDTO) {
        EmailAwsDTO awsDTO = new EmailAwsDTO(
                emailDTO.getRecipientEmail(),
                emailDTO.getRecipientName(),
                emailDTO.getSenderEmail(),
                emailDTO.getSubject(),
                emailDTO.getContent()

        );
        Map<String, Object> result = new HashMap<>();
        result.put("aws", awsDTO);
        return result;
    }
}
