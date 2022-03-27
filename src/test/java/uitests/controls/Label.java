package uitests.controls;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import uitests.models.wrappers.UIObject;


import static com.codeborne.selenide.Condition.visible;


public class Label extends UIObject<Label> {

    public Label(By locator) {
        super(locator);
    }

    @Override
    public void shouldBeValid() {
        this.$().parent().shouldBe(visible);
    }

    public Label shouldHaveText(String text) {
        this.$().shouldBe(visible).shouldHave(Condition.text(text));
        return this;
    }
}
