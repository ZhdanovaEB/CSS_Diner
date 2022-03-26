package uitests.controls;

import com.codeborne.selenide.Condition;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import uitests.models.wrappers.UIObject;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static uitests.utils.CustomConditions.invalid;

public class Div extends UIObject<Div> {

    public Div(By locator) {
        super(locator);
    }

    public Div(By locator, By parent) {
        super(locator, parent);
    }

    @Override
    public void shouldBeValid() {
        this.$().parent().shouldBe(visible);
    }

    @Override
    public void shouldBeInvalid() {
        this.$().parent().shouldBe(visible);
        this.$().parent().shouldBe(invalid());
    }

    public Div click() {
        this.$().click();
        return this;
    }

    public Div scroll() {
        this.$().scrollTo();
        return this;
    }

    public String text() {
        this.$().shouldBe(visible);
        String text = this.$().getText();
        return StringUtils.isEmpty(text) ? null : text;
    }

    public Div shouldHaveText(String text) {
        this.$().shouldBe(visible).shouldHave(Condition.text(text));
        return this;
    }

    public Div shouldExactText(String text) {
        this.$().shouldBe(visible).shouldHave(Condition.exactText(text));
        return this;
    }
}