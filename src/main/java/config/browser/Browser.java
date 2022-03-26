package config.browser;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Browser {
    FF("firefox"){
    },
    GH("chrome"){
    },
    OPERA("opera") {
    };

    @Getter
    @NonNull
    String browserName;

    @Getter
    private static Browser currentBrowser = resolveBrowser();


    private static Browser resolveBrowser() {
        String browser = (String) System.getProperties().get("browser");
        return browser == null ? GH : Browser.valueOf(browser.toUpperCase());
    }
}