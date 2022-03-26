package uitests.controls;

import com.codeborne.selenide.Condition;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import uitests.models.wrappers.UIObject;

import static com.codeborne.selenide.Condition.visible;
import static uitests.utils.CustomConditions.valid;
import static uitests.utils.SelectorsUtils.*;

public class TextArea extends UIObject<TextArea> {

    public TextArea(By locator) {
        super(locator);
    }

    public TextArea(By locator, By parent) {
        super(locator, parent);
    }

    public TextArea enterText(String text) {
        this.$().sendKeys(text, Keys.ENTER);
        return this;
    }

    public TextArea enterTextSafely(String text) {
        return appendTextSafely(text);
    }

    private TextArea appendTextSafely(String text) {
        enterTextSafly(this.$(), text);
        return this;
    }

    public TextArea clear() {
        clearFoTextArea(this.$());
        return this;
    }

    public TextArea clearAllText() {
        clearAllTextInInputElement(this.$());
        return this;
    }

    public String text() {
        this.$().shouldBe(visible);
        String text = this.$().getText();
        return StringUtils.isEmpty(text) ? null : text;
    }

    public TextArea shouldHaveText(String text) {
        this.$().shouldBe(visible).shouldHave(Condition.text(text));
        return this;
    }

}
