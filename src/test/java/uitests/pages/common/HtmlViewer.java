package uitests.pages.common;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import uitests.controls.Div;
import uitests.pages.BasePage;

public class HtmlViewer extends BasePage {
    private final Div headerHtmlViewer = new Div(By.xpath("//div[@class = 'editor-pane html-view']/div[@class = 'input-header']"));
    private final Div contentHtmlViewer = new Div(By.cssSelector("div.markup"));

    @Override
    public void shouldBeShown() {
        headerHtmlViewer.shouldBeVisible().shouldHaveText("HTML Viewer");
        contentHtmlViewer.shouldBeVisible();
    }

    @Step("Проверить наличия блока HTML Viewer")
    public void checkHtmlViewer() {
        shouldBeShown();
    }
}
