package br.com.emailAdapter.service.impl;

import br.com.emailAdapter.dto.EmailDTO;
import br.com.emailAdapter.dto.EmailOciDTO;
import br.com.emailAdapter.service.EmailAdapterStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OciEmailAdapterStrategy implements EmailAdapterStrategy {

    @Override
    public Map<String, Object> adaptEmail(EmailDTO emailDTO) {
        EmailOciDTO ociDTO = new EmailOciDTO(
                emailDTO.getRecipientEmail(),
                emailDTO.getRecipientName(),
                emailDTO.getSenderEmail(),
                emailDTO.getSubject(),
                emailDTO.getContent()
        );
        Map<String, Object> result = new HashMap<>();
        result.put("oci", ociDTO);
        return result;
    }
}
