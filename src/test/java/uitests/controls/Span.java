package uitests.controls;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import uitests.models.wrappers.UIObject;
import uitests.utils.CustomConditions;
import uitests.utils.CustomConditions.*;

import javax.lang.model.element.Element;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static uitests.utils.CustomConditions.invalid;
import static uitests.utils.CustomConditions.valid;

public class Span extends UIObject<Span> {

    public Span(By locator) {
        super(locator);
    }

    public Span(By locator, By parent) {
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

    public Span shouldHaveText(String text) {
        this.$().shouldBe(visible).shouldHave(Condition.text(text));
        return this;
    }

    // проверка, что содержит часть текста (для поисков)
    public Span shouldContainText(String text) {
        this.$().shouldBe(visible).shouldHave(Condition.matchText(text));
        return this;
    }

    public Span shouldHaveText(String text, int quantitySeconds) {
        this.$().shouldBe(visible).shouldHave(Condition.text(text), Duration.ofSeconds(quantitySeconds));
        return this;
    }

    public Span clickOnChildLink(int linkNumber) {
        ElementsCollection elementsCollection = Selenide.$$x((returnReplacedText(this.getRootLocator().toString())) + "//following-sibling::div//a");
        this.$().hover();
        elementsCollection.get(linkNumber).click();
        return this;
    }

    public void elementsCollectionShouldHaveText(String text) {
        int quantityElements = size();
        System.out.println("Collection size is " + quantityElements);
        for(int i = 0; i < quantityElements; i++) {
           getElement(i).shouldHave(Condition.text(text));
        }
    }

    public void elementsCollectionShouldHaveSizeOverTen() {
        getElementsCollection().shouldBe(CollectionCondition.sizeGreaterThan(10), Duration.ofSeconds(10));
    }

    @Override
    public Span click() {
        $().click();
        return this;
    }

    public String text() {
        return this.$().getText();
    }

    // CommonFunction
    private String returnReplacedText(String value) {
        return value.replaceAll("By.xpath: ", "");
    }
}
