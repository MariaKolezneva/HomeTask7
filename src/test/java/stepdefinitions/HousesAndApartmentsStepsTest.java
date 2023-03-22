package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;
import java.util.List;

import static basehelp.BaseHelpTest.getElement;
import static basehelp.BaseHelpTest.getListMenu;
import static com.codeborne.selenide.Selenide.actions;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class HousesAndApartmentsStepsTest {
    private final String housesAndApartments = "Дома и квартиры";
    private final String sell = "Продажа";
    private final String arenda = "Аренда";

    @When("Наводит на пункт Дома и квартиры")
    public void hoverToTheHomeButton() {
        actions().moveToElement(getElement(housesAndApartments)).perform();
    }
    @Then("Появляется подменю с категориями Продажа и Аренда")
    public void checkMenuHousesAndApartments() {
        List<String> expectedSaleItems = Arrays.asList(
        "Минск",
        "Брест",
        "Витебск",
        "Гомель",
        "Гродно",
        "Могилев",
        "1-комнатные",
        "2-комнатные",
        "3-комнатные",
        "4+-комнатные",
        "До 30 000 $",
        "30 000–80 000 $",
        "От 80 000 $"
        );
        List<String> expectedArendaItems = Arrays.asList(
        "Минск",
        "Брест",
        "Витебск",
        "Гомель",
        "Гродно",
        "Могилев",
        "1-комнатные",
        "2-комнатные",
        "3-комнатные",
        "4+-комнатные",
        "Комнаты",
        "От собственника",
        "До 250 $",
        "250-500 $",
        "От 500 $"
        );

        List<String> actualSaleItems = getListMenu(sell);
        assertThat(actualSaleItems).containsExactlyInAnyOrderElementsOf(expectedSaleItems);
        List<String> actualArendaItems = getListMenu(arenda);
        assertThat(actualArendaItems).containsExactlyInAnyOrderElementsOf(expectedArendaItems);
    }
}
