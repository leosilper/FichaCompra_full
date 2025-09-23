package br.com.fiap.fichacompra.config;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageHelper {
    private final MessageSource messageSource;

    public MessageHelper(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String get(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }
}
