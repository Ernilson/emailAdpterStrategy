package br.com.emailAdapter.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailOciDTO {
    @NotBlank(message = "O destinatário é obrigatório.")
    @Email(message = "O e-mail do destinatário deve ser válido.")
    @Size(max = 40, message = "O assunto pode ter no máximo 40 caracteres.")
    private String recipientEmail;

    @NotBlank(message = "O nome do destinatário é obrigatório.")
    @Size(max = 50, message = "O nome do destinatário pode ter no máximo 50 caracteres.")
    private String recipientName;

    @NotBlank(message = "O remetente é obrigatório.")
    @Email(message = "O e-mail do remetente deve ser válido.")
    @Size(max = 40, message = "O assunto pode ter no máximo 40 caracteres.")
    private String senderEmail;

    @NotBlank(message = "O assunto é obrigatório.")
    @Size(max = 100, message = "O assunto pode ter no máximo 100 caracteres.")
    private String subject;

    @NotBlank(message = "O conteúdo do e-mail é obrigatório.")
    @Size(max = 250, message = "O assunto pode ter no máximo 250 caracteres.")
    private String body;
}
