package uitests.assistants;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class CollectionUtils {

    public static boolean allElementsShouldHaveText(ElementsCollection collection, String desiredTextOne, String desiredTextTwo) {
        for (SelenideElement element: collection) {
            if (!element.getText().contains(desiredTextOne) && !element.getText().contains(desiredTextTwo))
                return false;
        }
        return true;
    }

    public static boolean allElementsShouldHaveText(ElementsCollection collection, String desiredTextOne) {
        for (SelenideElement element: collection) {
            if (!element.getText().contains(desiredTextOne)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDifferentCollectionsValues(ElementsCollection firstCollection, ElementsCollection secondCollection) {
        for (int i = 0; i < firstCollection.size(); i++) {
            if (firstCollection.get(i).text().equals(secondCollection.get(i).text())) {
                return false;
            }
        }
        return true;
    }
}
