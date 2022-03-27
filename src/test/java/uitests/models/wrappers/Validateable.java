package uitests.models.wrappers;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface Validateable {

  By getRootLocator();

  default void shouldBeValid() {
    $(this.getRootLocator()).shouldBe(Condition.visible);
    $(this.getRootLocator()).shouldBe(Condition.enabled);
  }
}