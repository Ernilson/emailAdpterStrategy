package br.com.emailAdapter.dtoTestes;

import br.com.emailAdapter.dto.EmailAwsDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailAwsDTOTest {

    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testCamposValidos_DevePassarValidacao() {
        EmailAwsDTO emailDto = new EmailAwsDTO(
                "destinatario@email.com",
                "Destinatário",
                "remetente@email.com",
                "Assunto do E-mail",
                "Conteúdo do e-mail."
        );

        Set<ConstraintViolation<EmailAwsDTO>> violations = validator.validate(emailDto);

        assertTrue(violations.isEmpty(), "Não deveria haver violações de validação.");
    }

    @Test
    void testCamposObrigatoriosVazios_DeveFalharValidacao() {
        EmailAwsDTO emailDto = new EmailAwsDTO("", "", "", "", "");

        Set<ConstraintViolation<EmailAwsDTO>> violations = validator.validate(emailDto);

        assertFalse(violations.isEmpty(), "Deveria haver violações de validação.");
    }

    @Test
    void testEmailsInvalidos_DeveFalharValidacao() {
        EmailAwsDTO emailDto = new EmailAwsDTO(
                "email-invalido",
                "Destinatário",
                "email-invalido",
                "Assunto",
                "Conteúdo"
        );

        Set<ConstraintViolation<EmailAwsDTO>> violations = validator.validate(emailDto);

        assertFalse(violations.isEmpty(), "E-mails inválidos deveriam causar violações.");
    }

    @Test
    void testAssuntoComMaisDe100Caracteres_DeveFalharValidacao() {
        String assuntoLongo = "A".repeat(121); // 101 caracteres
        EmailAwsDTO emailDto = new EmailAwsDTO(
                "destinatario@email.com",
                "Destinatário",
                "remetente@email.com",
                assuntoLongo,
                "Conteúdo"
        );

        Set<ConstraintViolation<EmailAwsDTO>> violations = validator.validate(emailDto);

        assertFalse(violations.isEmpty(), "Assunto com mais de 100 caracteres deveria ser inválido.");
    }
}

