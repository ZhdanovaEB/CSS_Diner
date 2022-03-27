package uitests.controls;

import com.codeborne.selenide.Condition;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import uitests.models.wrappers.UIObject;
import static com.codeborne.selenide.Condition.visible;


public class Div extends UIObject<Div> {

    public Div(By locator) {
        super(locator);
    }

    @Override
    public void shouldBeValid() {
        this.$().parent().shouldBe(visible);
    }

    public Div click() {
        this.$().click();
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

}