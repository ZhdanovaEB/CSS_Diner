package uitests.controls;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import uitests.models.wrappers.UIObject;

import java.io.File;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static uitests.utils.CustomConditions.invalid;

public class Button extends UIObject<Button> {

    public Button(By locator) {
        super(locator);
    }

    public Button(By locator, By parent) {
        super(locator, parent);
    }

    @Override
    public void shouldBeValid() {
        this.$().parent().shouldBe(visible);
        this.$().parent().shouldBe(enabled);    }

    @Override
    public void shouldBeInvalid() {
        this.$().parent().shouldBe(visible);
        this.$().parent().shouldBe(invalid());
    }


    public Button shouldHaveText(String text) {
        this.$().shouldBe(visible).shouldHave(Condition.text(text));
        return this;
    }

    public Button click() {
        this.$().click();
        return this;
    }

}