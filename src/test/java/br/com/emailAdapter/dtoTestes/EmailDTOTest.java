package br.com.emailAdapter.dtoTestes;

import br.com.emailAdapter.dto.EmailDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class EmailDTOTest {

    private static Validator validator;

    @BeforeAll
    static void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void deveCriarEmailDTOValido() {
        EmailDTO dto = new EmailDTO("ernilson25@email.com","teste","liginevs@gmail.com","Assunto", "Mensagem de teste");
        Set<ConstraintViolation<EmailDTO>> violacoes = validator.validate(dto);
        assertTrue(violacoes.isEmpty(), "Não deve haver violações");
    }

    @Test
    void deveRetornarErroQuandoEmailForInvalido() {
        EmailDTO dto = new EmailDTO("teste@email.com","teste","teste*email.com","Assunto", "Mensagem de teste");
        Set<ConstraintViolation<EmailDTO>> violacoes = validator.validate(dto);
        assertFalse(violacoes.isEmpty(), "Deve haver violações para email inválido");
    }
}

