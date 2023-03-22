package basehelp;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;

public class BaseHelpTest {

    public static List<String> getListMenu(String element){
        ElementsCollection items = Selenide.$$x("//a[text()='" + element + "']/../..//div[contains(@class, 'grid')]//span[contains(@class, 'sign')]");
        List<String> list = new ArrayList<>();
        for (SelenideElement item : items) {
            list.add(item.getOwnText());
        }
        return list;
    }
    public static SelenideElement getElement(String name) {
        return $x("//span[contains(@class,'main') and text()='"+name+"']");
    }
}
