package uitests.controls;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import uitests.models.wrappers.UIObject;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;


public class Button extends UIObject<Button> {

    public Button(By locator) {
        super(locator);
    }

    @Override
    public void shouldBeValid() {
        this.$().parent().shouldBe(visible);
        this.$().parent().shouldBe(enabled);    }

    public Button shouldHaveText(String text) {
        this.$().shouldBe(visible).shouldHave(Condition.text(text));
        return this;
    }

    public Button click() {
        this.$().click();
        return this;
    }
}