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
public class EmailAwsDTO {
    @NotBlank(message = "O destinatário é obrigatório.")
    @Email(message = "O e-mail do destinatário deve ser válido.")
    @Size(max = 45, message = "O conteúdo pode ter no máximo 45 caracteres.")
    private String recipient;

    @NotBlank(message = "O nome do destinatário é obrigatório.")
    @Size(max = 60, message = "O nome do destinatário pode ter no máximo 60 caracteres.")
    private String recipientName;

    @NotBlank(message = "O remetente é obrigatório.")
    @Email(message = "O e-mail do remetente deve ser válido.")
    @Size(max = 45, message = "O conteúdopode ter no máximo 45 caracteres.")
    private String sender;

    @NotBlank(message = "O assunto é obrigatório.")
    @Size(max = 120, message = "O assunto pode ter no máximo 120 caracteres.")
    private String subject;

    @NotBlank(message = "O conteúdo do e-mail é obrigatório.")
    @Size(max = 250, message = "O conteúdo pode ter no máximo 250 caracteres.")
    private String content;

}
