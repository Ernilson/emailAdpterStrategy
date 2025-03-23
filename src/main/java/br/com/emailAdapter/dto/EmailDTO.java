package br.com.emailAdapter.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailDTO {
    @NotBlank(message = "O destinatário é obrigatório.")
    @Email(message = "O e-mail do destinatário deve ser válido.")
    private String recipientEmail;

    @NotBlank(message = "O nome do destinatário é obrigatório.")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres.")
    private String recipientName;

    @NotBlank(message = "O remetente é obrigatório.")
    @Email(message = "O e-mail do remetente deve ser válido.")
    private String senderEmail;

    @NotBlank(message = "O assunto é obrigatório.")
    @Size(max = 100, message = "O assunto pode ter no máximo 100 caracteres.")
    private String subject;

    @NotBlank(message = "O conteúdo do e-mail é obrigatório.")
    private String content;


}
