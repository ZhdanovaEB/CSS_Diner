package uitests.models.wrappers;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import uitests.controls.Label;
import uitests.models.DisplayAble;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static uitests.utils.SelectorsUtils.getElementXpath;

public class UIObject<T> implements DisplayAble<T>, Validateable {

    private final LocatorHolder locatorHolder;

    public By getRootLocator() {
        return locatorHolder.getRootLocator();
    }

    public UIObject(By locator) {
        this.locatorHolder = new LocatorHolder(locator);
    }

    public UIObject(By locator, By parent) {
        this.locatorHolder = new LocatorHolder(locator, parent);
    }

    public SelenideElement $() {
        return locatorHolder.getElement();
    }

    private ElementsCollection $$() {
        return locatorHolder.getElementsCollection();
    }

    public boolean isNotEmpty() {
        Selenide.sleep(1000);
        return this.$().exists();
    }

    @Override
    public T shouldBeVisible() {
        this.shouldBeValid();
        this.$().shouldBe(visible);
        return (T) this;
    }

    public T shouldBeVisible(Integer value) {
        this.shouldBeValid();
        this.$().shouldBe(visible, Duration.ofSeconds(value));
        return (T) this;
    }

    /*public boolean isNotEmpty() {
        Selenide.sleep(1000);
        return this.$().exists();
    }*/

    public boolean isEmpty() {
        Selenide.sleep(1000);
        this.$().shouldNotBe(exist, Duration.ofSeconds(10));
        return !this.$().exists();
    }

    @Override
    public T shouldNotBeVisible() {
        this.shouldBeInvalid();
        return (T) this;
    }

    public T shouldNotBeExist() {
        this.$().shouldNot(exist);
        return (T) this;
    }

    public T shouldNotBeExist(int timeDuration) {
        this.$().shouldNot(exist, Duration.ofSeconds(timeDuration));
        return (T) this;
    }

    public T shouldBeExist() {
        this.$().shouldBe(exist);
        return (T) this;
    }

    public T click() {
        this.shouldBeVisible();
        this.$().hover().click();
        return (T) this;
    }

    public T clickWithoutVisible() {
        this.$().hover().click();
        return (T) this;
    }

    public boolean isDisplayed() {
        return Selenide.$(getRootLocator()).isDisplayed() && this.$().isDisplayed();
    }

    public SelenideElement getElement(int index) {
        this.shouldBeVisible();
        return  this.$$().get(index);
    }

    public ElementsCollection getElementsCollection() {
        return locatorHolder.getElementsCollection();
    }

    public void  elementsCollectionShouldHaveSizeOverValue(String value) {
        getElementsCollection().shouldBe(CollectionCondition.sizeGreaterThan(Integer.parseInt(value)), Duration.ofSeconds(10));
    }

    public void  elementsCollectionShouldHaveSizeLessOrEqualValue(String value) {
        getElementsCollection().shouldBe(CollectionCondition.sizeLessThanOrEqual(Integer.parseInt(value)), Duration.ofSeconds(10));
    }

    public int size() {
        this.shouldBeVisible();
        return this.$$().size();
    }

    public T get(int index) {
        Class clazz = this.getClass();
        Constructor<T> constructor;
        try {
            constructor = clazz.getDeclaredConstructor(By.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            System.out.println("couldn't instantiate class " + clazz.getName() + " with constructor(By.class");
            return null;
        }
        this.shouldBeVisible();
        this.$$().shouldHave(CollectionCondition.sizeGreaterThanOrEqual(index + 1));
        WebElement element = this.$$().get(index);
        String path = getElementXpath(element);
        try {
            return constructor.newInstance(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}