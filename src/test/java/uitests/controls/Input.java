package uitests.controls;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import uitests.models.wrappers.UIObject;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static uitests.utils.CustomConditions.invalid;
import static uitests.utils.CustomConditions.valid;
import static uitests.utils.SelectorsUtils.*;

public class  Input extends UIObject<Input> {

    public Input(By inputTagLocator) {
        super(inputTagLocator);
    }

    public Input(By inputTagLocator, By parent) {
        super(inputTagLocator, parent);
    }

    public boolean isValid() {
        return this.$().parent().is(valid());
    }

    @Override
    public void shouldBeValid() {
        this.$().parent().shouldBe(visible);
        this.$().parent().shouldBe(valid());
    }

    @Override
    public void shouldBeInvalid() {
        this.$().parent().shouldBe(visible);
        this.$().parent().shouldBe(invalid());
    }

    public String getPlaceholder() {
        return this.$().getAttribute("placeholder");
    }

    public Input enterText(String text) {
        this.$().shouldBe(visible);
        this.$().sendKeys(text);
        return this;
    }

    public Input enterTextWithoutVisible(String text) {
        this.$().sendKeys(text);
        return this;
    }

    public Input enterTextAndConfirm(String text) {
        this.$().shouldBe(visible).shouldBe(valid());
        this.$().sendKeys(text);
        this.$().pressEnter();
        return this;
    }

    public Input scroll() {
        this.$().scrollTo();
        return this;
    }

    public Input enterTextSafely(String text) {
        return appendTextSafely(text);
    }

    public Input appendTextSafely(String text) {
        enterTextSafly(this.$(), text);
        return this;
    }

    public String value() {
        this.$().shouldBe(visible);
        String rootPath = returnReplacedText(getRootLocator().toString());
        SelenideElement spanElement = Selenide.$x(rootPath + "//..//..//span");
        if (spanElement.exists() && this.$().getValue().equals("")) {
            String spanValue = spanElement.getText();
            return StringUtils.isEmpty(spanValue) ? null : spanValue;
        }
        String value = this.$().getValue();
        return StringUtils.isEmpty(value) ? null : value;
    }

    public String title() {
        this.$().shouldBe(visible);
        String title = this.$().getAttribute("title");
        return StringUtils.isEmpty(title) ? null : title;
    }

    public String text() {
        this.$().shouldBe(visible);
        String text = this.$().getText();
        return StringUtils.isEmpty(text) ? null : text;
    }

    public Input shouldHaveText(String text) {
        this.$().shouldBe(visible).shouldHave(Condition.text(text));
        return this;
    }

    public Input shouldHaveValue(String text) {
        this.$().shouldBe(visible).shouldHave(Condition.value(text));
        return this;
    }

    public Input clear() {
        clearInputElement(this.$());
        return this;
    }

    public Input clearAllText() {
        clearAllTextInInputElement(this.$());
        return this;
    }

    public Input shouldBeEmpty() {
        this.$().shouldBe(empty);
        return this;
    }

    public Input shouldNotBeEmpty() {
        this.$().shouldNotBe(empty);
        return this;
    }

    public Input shouldBeEnabled() {
        this.$().shouldBe(enabled);
        this.$().shouldNot(have(attribute("disabled")));
        return this;
    }

    public Input shouldNotBeEnabled() {
        this.$().shouldNotBe(enabled);
        return this;
    }

    public Input shouldBeDisabled() {
        this.$().shouldBe(disabled);
        return this;
    }

    public Input shouldNotBeDisabled() {
        this.$().shouldNotBe(disabled);
        return this;
    }

    public Input uploadFile(String pathName) {
        File file = new File(pathName);
        this.$().uploadFile(file);
        return this;
    }


    // CommonFunction
    private String returnReplacedText(String value) {
        return value.replaceAll("By.xpath: ", "");
    }
}