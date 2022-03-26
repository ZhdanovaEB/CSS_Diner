package uitests.assistants;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.thoughtworks.gauge.Step;
import config.browser.Browser;
import config.environment.Environment;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

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

    @Step("Ожидание загрузки страницы")
    public void waitPageIsLoaded() {
        try {
            Function<WebDriver, Boolean> pageLoaded = wd -> ((JavascriptExecutor) wd).executeScript(
                    "return document.readyState").equals("complete");
            new FluentWait<>(WebDriverRunner.getWebDriver())
                    .withTimeout(Duration.ofSeconds(Configuration.timeout / 1000))
                    .until(pageLoaded);
        } catch (Exception e) {
            System.out.println("error in waitPageIsLoaded(): " + e);
        }
    }

    @Step("Ожидание в течение <seconds> секунд")
    public void sleep(String seconds) {
        Selenide.sleep(Integer.parseInt(seconds) * 1000);
    }

    @Step("Обновить страницу")
    public void refreshPage() {
        Selenide.refresh();
    }

}
