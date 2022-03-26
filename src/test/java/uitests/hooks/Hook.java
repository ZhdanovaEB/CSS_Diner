package uitests.hooks;

import com.codeborne.selenide.Configuration;
import com.thoughtworks.gauge.BeforeSuite;
import config.browser.Browser;

public class Hook {
    @BeforeSuite
    public void setupApp() {
        Configuration.timeout = 20_000;
        System.setProperty("browser", "FF");
        System.setProperty("environment", "URL");
        Configuration.browser = Browser.getCurrentBrowser().getBrowserName();
    }
}