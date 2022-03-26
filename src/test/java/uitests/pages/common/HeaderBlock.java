package uitests.pages.common;

import com.thoughtworks.gauge.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import uitests.controls.Div;
import uitests.controls.Label;
import uitests.controls.Link;
import uitests.pages.BasePage;

@Getter
public class HeaderBlock extends BasePage {
    private final Label siteLabel = new Label(By.cssSelector("header"));
    private final Div siteLogo = new Div(By.className("logo"));
    private final Label orderForLevel = new Label(By.cssSelector("h2.order"));
    private final Link helpLink = new Link(By.xpath("//a[contains(text(),'Help')]"));
    private final Link shareEmail = new Link(By.xpath("//a[@class = 'share-email']"));
    private final Link shareFacebook = new Link(By.xpath("//a[@class = 'share-facebook']"));
    private final Link shareTwitter = new Link(By.xpath("//a[@class = 'share-twitter']"));

    @Override
    public void shouldBeShown() {
        siteLabel.shouldBeVisible().shouldHaveText("CSS Diner");
        siteLogo.shouldBeVisible();
        orderForLevel.shouldBeVisible();
        helpLink.shouldBeVisible();
        shareEmail.shouldBeVisible();
        shareFacebook.shouldBeVisible();
        shareTwitter.shouldBeVisible();
    }

    @Step("Проверить наличие хедера и его элементов")
    public void checkHeaderElements() {
        shouldBeShown();
    }

    @Step("Проверить наличие задания <order>")
    public void checkOrderForLevel(String order) {
        orderForLevel.shouldBeVisible().shouldHaveText(order);
    }





}
