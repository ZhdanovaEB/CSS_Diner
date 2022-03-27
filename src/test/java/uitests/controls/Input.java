package uitests.controls;

import org.openqa.selenium.By;
import uitests.models.wrappers.UIObject;
import static com.codeborne.selenide.Condition.*;


public class  Input extends UIObject<Input> {

    public Input(By inputTagLocator) {
        super(inputTagLocator);
    }

    @Override
    public void shouldBeValid() {
        this.$().parent().shouldBe(visible);
    }

    public Input enterText(String text) {
        this.$().shouldBe(visible);
        this.$().sendKeys(text);
        return this;
    }
}