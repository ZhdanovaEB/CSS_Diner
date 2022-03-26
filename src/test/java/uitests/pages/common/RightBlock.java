package uitests.pages.common;

import com.thoughtworks.gauge.Step;
import enums.ButtonName;
import lombok.Getter;
import org.openqa.selenium.By;
import uitests.controls.Div;
import uitests.controls.Label;
import uitests.controls.Link;
import uitests.controls.Span;
import uitests.pages.BasePage;

@Getter
public class RightBlock extends BasePage {
    private final Span levelNumber = new Span(By.cssSelector("span.level-text"));                   // Заголовок с номером уровня
    private final Div buttonToggle = new Div(By.cssSelector("div.level-menu-toggle-wrapper"));      // Кнопка сендвич-меню и крестик
    private final Label nameOfLevel = new Label(By.cssSelector("h3.selector-name"));
    private final Label shortDescription = new Label(By.cssSelector("h2.title"));
    private final Label syntaxForLevel = new Label(By.cssSelector("h3.syntax"));
    private final Div fullDescription = new Div(By.cssSelector("div.hint"));
    private final Label examplesTitle = new Label(By.cssSelector("h4.examples-title"));
    private final Div examples = new Div(By.cssSelector("div.examples"));

    // Метод для получения < > кнопок.
    public Link getNavigationButton(ButtonName buttonName) {
        return new Link(By.cssSelector("a." + buttonName.getButtonClass()));
    }

    // Метод для получения заданного уровня
    public Link getLevelFromMenu(String level) {
        return new Link(By.xpath("//a/span[text() = '" + level + "']"));
    }

    @Override
    public void shouldBeShown() {
        levelNumber.shouldBeVisible();
        buttonToggle.shouldBeVisible();
        nameOfLevel.shouldBeVisible();
        shortDescription.shouldBeVisible();
        syntaxForLevel.shouldBeVisible();
        fullDescription.shouldBeVisible();
        examplesTitle.shouldBeVisible().shouldHaveText("Examples");
        examples.shouldBeVisible();
    }

    @Step("Проверить наличия правого блока и его элементов")
    public void checkRightBlock() {
        shouldBeShown();
    }

    @Step("Нажать на кнопку навигации <button>")
    public void clickButton(String button) {
        getNavigationButton(ButtonName.valueOf(button)).shouldBeVisible().click();
    }

    @Step("Проверить отображение уровня <level>")
    public void checkLevel(String level) {
        levelNumber.shouldBeVisible().shouldHaveText(level);
    }

    @Step("Раскрыть сендвич-меню")
    public void clickButtonToggle() {
        buttonToggle.shouldBeVisible().click();
    }

    @Step("Кликнуть на уровень <level>")
    public void clickLevelFromMenu(String level) {
        getLevelFromMenu(level).shouldBeVisible().click();
    }
}
