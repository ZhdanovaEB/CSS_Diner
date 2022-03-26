package uitests.controls;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import uitests.models.wrappers.UIObject;

import static com.codeborne.selenide.Condition.visible;
import static uitests.utils.CustomConditions.invalid;

public class Link extends UIObject<Link> {

    public Link(By locator) {
        super(locator);
    }

    public Link(By locator, By parent) {
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

    public Link click() {
        this.$().click();
        return this;
    }

    public Link focus() {
        this.$().hover();
        return this;
    }

    public Link scroll() {
        this.$().scrollTo();
        return this;
    }

    public String text() {
        return this.$().text();
    }

    public Link clickOnChildLink(int linkNumber) {
        ElementsCollection elementsCollection = Selenide.$$x((returnReplacedText(this.getRootLocator().toString())) + "//following-sibling::div//a");
        this.$().hover();
        elementsCollection.get(linkNumber).click();
        return this;
    }

    public Link shouldHaveText(String text) {
        this.$().shouldBe(visible).shouldHave(Condition.text(text));
        return this;
    }

    public void elementsCollectionShouldHaveText(String text) {
        int quantityElements = size();
        System.out.println("Collection size is " + quantityElements);
        for(int i = 0; i < quantityElements; i++) {
            getElement(i).shouldHave(Condition.text(text));
        }
    }

    // CommonFunction
    private String returnReplacedText(String value) {
        return value.replaceAll("By.xpath: ", "");
    }
}