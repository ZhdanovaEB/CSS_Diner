package uitests.controls;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import uitests.models.wrappers.UIObject;
import static com.codeborne.selenide.Condition.visible;


public class Span extends UIObject<Span> {

    public Span(By locator) {
        super(locator);
    }

    @Override
    public void shouldBeValid() {
        this.$().parent().shouldBe(visible);
    }

    public Span shouldHaveText(String text) {
        this.$().shouldBe(visible).shouldHave(Condition.text(text));
        return this;
    }

    @Override
    public Span click() {
        $().click();
        return this;
    }
}
