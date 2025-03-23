package br.com.emailAdapter.service;

import br.com.emailAdapter.dto.EmailDTO;
import br.com.emailAdapter.service.impl.AwsEmailAdapterStrategy;
import br.com.emailAdapter.service.impl.OciEmailAdapterStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class EmailAdapterService {

    @Autowired
    private AwsEmailAdapterStrategy awsStrategy;

    @Autowired
    private OciEmailAdapterStrategy ociStrategy;

    @Value("${mail.integracao}")
    private String integracao;

    public Map<String, Object> adaptAndSerializeEmail(EmailDTO emailDTO) {
        if ("AWS".equalsIgnoreCase(integracao)) {
            return awsStrategy.adaptEmail(emailDTO);
        } else if ("OCI".equalsIgnoreCase(integracao)) {
            return ociStrategy.adaptEmail(emailDTO);
        } else {
            throw new IllegalArgumentException("Configuração de integração inválida.");
        }
    }
}