package br.com.emailAdapter.service;

import br.com.emailAdapter.dto.EmailDTO;

import java.util.Map;

public interface EmailAdapterStrategy {

    Map<String, Object> adaptEmail(EmailDTO emailDTO);
}
