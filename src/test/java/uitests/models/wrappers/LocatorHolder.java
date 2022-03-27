package uitests.models.wrappers;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;

public class LocatorHolder {

    private final By locator;
    private By parent;

    LocatorHolder(By locator) {
        this.locator = locator;
    }

    public By getRootLocator() {
        if (parent == null) {
            return locator;
        } else {
            return parent;
        }
    }

    public SelenideElement getElement() {
        if (parent == null) {
            return Selenide.$(locator);
        } else {
            return Selenide.$(parent).shouldBe(visible).find(locator);
        }
    }
}
