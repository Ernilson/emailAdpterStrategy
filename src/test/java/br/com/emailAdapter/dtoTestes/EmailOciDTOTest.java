package br.com.emailAdapter.dtoTestes;

import br.com.emailAdapter.dto.EmailOciDTO;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class EmailOciDTOTest {

    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testCamposValidos() {
        EmailOciDTO dto = new EmailOciDTO(
                "destinatario@email.com",
                "Nome Válido",
                "remetente@email.com",
                "Assunto Válido",
                "Conteúdo do e-mail"
        );

        Set<ConstraintViolation<EmailOciDTO>> violations = validator.validate(dto);
        assertTrue(violations.isEmpty(), "Não deve haver violações quando os dados são válidos.");
    }

    @Test
    void testCamposObrigatorios() {
        EmailOciDTO dto = new EmailOciDTO(null, null, null, null, null);

        Set<ConstraintViolation<EmailOciDTO>> violations = validator.validate(dto);
        assertEquals(5, violations.size(), "Todos os campos obrigatórios devem gerar violações.");
    }

    @Test
    void testEmailInvalido() {
        EmailOciDTO dto = new EmailOciDTO(
                "email-invalido",
                "Nome Válido",
                "remetente-invalido",
                "Assunto",
                "Conteúdo"
        );

        Set<ConstraintViolation<EmailOciDTO>> violations = validator.validate(dto);
        assertEquals(2, violations.size(), "Deve haver 2 violações por e-mails inválidos.");
    }


    @Test
    void testTamanhoMaximoAssuntoENome() {
        String nomeGrande = "A".repeat(51); // 51 caracteres
        String assuntoGrande = "A".repeat(101); // 101 caracteres

        EmailOciDTO dto = new EmailOciDTO(
                "destinatario@email.com",
                nomeGrande,
                "remetente@email.com",
                assuntoGrande,
                "Conteúdo"
        );

        Set<ConstraintViolation<EmailOciDTO>> violations = validator.validate(dto);
        assertEquals(2, violations.size(), "Deve haver 2 violações para campos que excedem o tamanho máximo.");
    }
}
