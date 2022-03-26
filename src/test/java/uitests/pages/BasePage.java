package uitests.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage extends Object {
    public abstract void shouldBeShown();

    public static void loseFocus() {
        $(By.xpath("//body[@class = 'lotusui30dojo tundra locale_ru wpthemePlain wpToolbarCommon app']")).click();
    }

    public static void clickIgnoreVisibility(SelenideElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        executor.executeScript("arguments[0].click;", element);
    }

    public static void setCheckedIgnoreVisibility(SelenideElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        executor.executeScript("arguments[0].checked = \"true\";", element);
    }

    public static void waitOneOf(long millis, By... locators) {
        int sleepTime = 500;
        do {
            for (By loc : locators) {
                if ($(loc).isDisplayed()) {
                    Selenide.sleep(sleepTime);
                    if ($(loc).isDisplayed()) {
                        return;
                    }
                }
            }
            Selenide.sleep(sleepTime);
            millis -= sleepTime;
        } while (millis > 0);
        System.out.println("no one locator is found");
    }

}
