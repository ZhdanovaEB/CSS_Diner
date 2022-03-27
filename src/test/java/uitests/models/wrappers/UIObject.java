package uitests.models.wrappers;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import uitests.models.DisplayAble;
import static com.codeborne.selenide.Condition.visible;

public class UIObject<T> implements DisplayAble<T>, Validateable {

    private final LocatorHolder locatorHolder;

    public By getRootLocator() {
        return locatorHolder.getRootLocator();
    }

    public UIObject(By locator) {
        this.locatorHolder = new LocatorHolder(locator);
    }

    public SelenideElement $() {
        return locatorHolder.getElement();
    }

    @Override
    public T shouldBeVisible() {
        this.shouldBeValid();
        this.$().shouldBe(visible);
        return (T) this;
    }

    public T click() {
        this.shouldBeVisible();
        this.$().hover().click();
        return (T) this;
    }
}