package ru.otus.spgboot.configs;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties(AppProps.class)
public class AppLocalizedProps {

    private final AppProps appProps;

    private final MessageSource messageSource;

    public AppLocalizedProps(AppProps appProps, MessageSource messageSource) {
        this.appProps = appProps;
        this.messageSource = messageSource;
    }

    public int getMinRightQuestionsCount() {
        return appProps.getMinRightCount();
    }

    public String getLocalizedProperty(String property) {
        return messageSource.getMessage(property, null, appProps.getLocale());
    }

    public String getLocalizedProperty(String property, Integer[] data) {
        return messageSource.getMessage(property, data, appProps.getLocale());
    }
}
