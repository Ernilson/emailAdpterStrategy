package br.com.emailAdapter.serviceTestes;

import br.com.emailAdapter.dto.EmailDTO;
import br.com.emailAdapter.dto.EmailAwsDTO;
import br.com.emailAdapter.dto.EmailOciDTO;
import br.com.emailAdapter.service.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmailServiceTest {

    @InjectMocks
    private EmailService emailService;

    @Mock
    private ObjectMapper objectMapper;

    private EmailDTO emailDTO;

    @BeforeEach
    void setUp() {
        emailDTO = new EmailDTO();
    }

    @Test
    void deveProcessarEmailComAWS() throws JsonProcessingException {
        // Configura a integração para AWS
        ReflectionTestUtils.setField(emailService, "integracao", "AWS");

        // Mocka a conversão do objeto
        when(objectMapper.writeValueAsString(any(EmailAwsDTO.class))).thenReturn("{\"mocked\":\"json\"}");

        // Executa o método
        emailService.processEmail(emailDTO);

        // Verifica se a conversão para EmailAwsDTO ocorreu
        verify(objectMapper).writeValueAsString(any(EmailAwsDTO.class));
    }

    @Test
    void deveProcessarEmailComOCI() throws JsonProcessingException {
        // Configura a integração para OCI
        ReflectionTestUtils.setField(emailService, "integracao", "OCI");

        // Mocka a conversão do objeto
        when(objectMapper.writeValueAsString(any(EmailOciDTO.class))).thenReturn("{\"mocked\":\"json\"}");

        // Executa o método
        emailService.processEmail(emailDTO);

        // Verifica se a conversão para EmailOciDTO ocorreu
        verify(objectMapper).writeValueAsString(any(EmailOciDTO.class));
    }

    @Test
    void deveLancarExcecaoParaIntegracaoNaoSuportada() {
        // Configura uma integração inválida
        ReflectionTestUtils.setField(emailService, "integracao", "INVALID");

        // Verifica se a exceção é lançada ao chamar processEmail
        assertThrows(IllegalArgumentException.class, () -> emailService.processEmail(emailDTO));
    }
}
