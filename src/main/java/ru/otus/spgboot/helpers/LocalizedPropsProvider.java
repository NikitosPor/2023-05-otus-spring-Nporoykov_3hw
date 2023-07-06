package ru.otus.spgboot.helpers;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import ru.otus.spgboot.configs.LocaleProvider;

@Component
public class LocalizedPropsProvider {

    private final LocaleProvider localeProvider;

    private final MessageSource messageSource;

    public LocalizedPropsProvider(LocaleProvider localeProvider, MessageSource messageSource) {
        this.localeProvider = localeProvider;
        this.messageSource = messageSource;
    }

    public String getLocalizedProperty(String message) {
        return messageSource.getMessage(message, null, localeProvider.getLocale());
    }

    public String getLocalizedProperty(String message, Object[] data) {
        return messageSource.getMessage(message, data, localeProvider.getLocale());
    }
}
