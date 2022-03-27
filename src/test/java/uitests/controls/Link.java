package uitests.controls;

import org.openqa.selenium.By;
import uitests.models.wrappers.UIObject;
import static com.codeborne.selenide.Condition.visible;


public class Link extends UIObject<Link> {

    public Link(By locator) {
        super(locator);
    }


    @Override
    public void shouldBeValid() {
        this.$().parent().shouldBe(visible);
    }

    public Link click() {
        this.$().click();
        return this;
    }

    public String text() {
        return this.$().text();
    }

}