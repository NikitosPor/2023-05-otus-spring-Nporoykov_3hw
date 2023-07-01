package ru.otus.spgboot.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

import java.util.Locale;

@ConfigurationProperties(prefix = "application")
public class AppProps {

    private final Locale locale;

    private final int minRightCount;

    private final String sourceFilePath;

    @ConstructorBinding
    public AppProps(Locale locale, int minRightCount, String defFilePath) {
        this.locale = locale;
        this.minRightCount = minRightCount;
        this.sourceFilePath = defFilePath + locale.getLanguage();
    }

    public Locale getLocale() {
        return this.locale;
    }

    public String getSourceFilePath() {
        return sourceFilePath;
    }

    public int getMinRightCount() {
        return minRightCount;
    }

}
