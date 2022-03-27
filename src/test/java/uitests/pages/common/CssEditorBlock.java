package uitests.pages.common;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import uitests.controls.Button;
import uitests.controls.Div;
import uitests.controls.Input;
import uitests.pages.BasePage;

public class CssEditorBlock extends BasePage {
    private final Div headerCssEditor = new Div(By.xpath("//div[@class = 'editor-pane']/div[@class = 'input-header']"));
    private final Input cssEditorInput = new Input(By.cssSelector("input.input-strobe"));
    private final Button enterButton = new Button(By.cssSelector("div.enter-button"));

    @Override
    public void shouldBeShown() {
        headerCssEditor.shouldBeVisible().shouldHaveText("CSS Editor");
        cssEditorInput.shouldBeVisible();
        enterButton.shouldBeVisible();
    }

    @Step("Проверить наличия блока CSS Editor и его элементов")
    public void checkCssEditorBlock() {
        shouldBeShown();
    }

    @Step("Строка ввода: ввести текст <solution>")
    public void enterSolution(String solution) {
        cssEditorInput.shouldBeVisible().enterText(solution);
    }

    @Step("Нажать кнопку Enter")
    public void clickEnterButton() {
        enterButton.shouldBeVisible().shouldHaveText("Enter").click();
    }

}
