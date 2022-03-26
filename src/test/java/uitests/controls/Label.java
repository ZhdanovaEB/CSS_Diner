package uitests.controls;

import com.codeborne.selenide.Condition;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import uitests.models.wrappers.UIObject;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static uitests.utils.CustomConditions.invalid;

public class Label extends UIObject<Label> {

    public Label(By locator) {
        super(locator);
    }

    public Label(By locator, By parent) {
        super(locator, parent);
    }

    @Override
    public void shouldBeValid() {
        this.$().parent().shouldBe(visible);
    }

    public void scroll() {
        this.$().scrollTo();
    }

    public boolean isEmpty() {
        this.$().parent().shouldNot(Condition.exist, Duration.ofSeconds(10));
        return this.$().parent().exists();
    }

    @Override
    public void shouldBeInvalid() {
        this.$().parent().shouldBe(visible);
        this.$().parent().shouldBe(invalid());
    }

    public String text() {
        this.$().shouldBe(visible);
        String text = this.$().getText();
        return StringUtils.isEmpty(text) ? null : text;
    }

    public Label shouldHaveText(String text) {
        this.$().shouldBe(visible).shouldHave(Condition.text(text));
        return this;
    }
}
