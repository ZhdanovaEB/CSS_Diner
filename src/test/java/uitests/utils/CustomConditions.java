package uitests.utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static uitests.assistants.CommonLocators.ARIA_INVALID_XPATH;
import static uitests.assistants.CommonLocators.QUANTITY_ROW_XPATH;

public class CustomConditions {

    public static Condition containsText(String text) {
        return new Condition("text " + text + " was not found") {
            @Override
            public boolean apply(Driver driver, WebElement webElement) {
                return webElement.getText().contains(text.toLowerCase());
            }
        };
    }

    public static Condition valid() {
        return new Condition("valid (FPSO) " + ARIA_INVALID_XPATH + " was found") {
            @Override
            public boolean apply(Driver driver, WebElement webElement) {
                return (getSizeOfInnerElementsWithInvalidAttribute(webElement) == 0);
            }
        };
    }

    public static Condition invalid() {
        return new Condition("Invalid (FPSO) " + ARIA_INVALID_XPATH + " not found") {
            @Override
            public boolean apply(Driver driver, WebElement webElement) {
                return (getSizeOfInnerElementsWithInvalidAttribute(webElement) > 0);
            }
        };
    }

    public static Condition overTenRows() {
        return new Condition("Over ten rows in collection") {
            @Override
            public boolean apply(Driver driver, WebElement webElement) {
                return (getQuantityRowInTable(webElement) > 10);
            }
        };
    }

    public static Condition valueMatches(String regexp) {
        return new Condition("value not matches regexp: '" + ARIA_INVALID_XPATH + "'") {
            @Override
            public boolean apply(Driver driver, WebElement webElement) {
                return webElement.getAttribute("value").matches(regexp);
            }
        };
    }

    private static int getSizeOfInnerElementsWithInvalidAttribute(WebElement webElement) {
        return webElement.findElements(By.xpath(ARIA_INVALID_XPATH)).size();
    }

    private static int getQuantityRowInTable(WebElement webElement) {
        return webElement.findElements(By.xpath(QUANTITY_ROW_XPATH)).size();
    }
}
