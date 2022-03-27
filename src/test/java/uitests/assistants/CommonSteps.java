package uitests.assistants;

import com.codeborne.selenide.WebDriverRunner;
import com.thoughtworks.gauge.Step;
import config.environment.Environment;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class CommonSteps {

    @Step("Открыть сайт CSS Diner")
    public void openSite() {
        open(Environment.getCurrentEnvironment().getUrl());
    }

    @Step("Почистить куки")
    public void clearCookie() {
        if (WebDriverRunner.hasWebDriverStarted() && !url().startsWith("data")) {
            try {
                WebDriverRunner.getWebDriver().manage().deleteAllCookies();
                WebDriverRunner.clearBrowserCache();
                System.out.println("deleting cookies...");
            } catch (Exception e) {
                System.out.println("exception occurs while trying clear cookies {} \n " + e);
            }
        }
    }

    @Step("Почистить локальные данные")
    public void clearLocalStorage() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        try {
            if (WebDriverRunner.hasWebDriverStarted() && !url().contains("data:")) {
                System.out.println("clearing local storage...");
                javascriptExecutor.executeScript("window.localStorage.clear();");
            }
        } catch (Exception e) {
            System.out.println("exception occurs while trying clear local storage {} \n " + e);
        }
        WebDriverRunner.getWebDriver().close();
    }
}
