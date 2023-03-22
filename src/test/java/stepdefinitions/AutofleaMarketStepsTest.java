package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;
import java.util.List;

import static basehelp.BaseHelpTest.getElement;
import static basehelp.BaseHelpTest.getListMenu;
import static com.codeborne.selenide.Selenide.actions;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class AutofleaMarketStepsTest{

    private final String autofleaMarket = "Автобарахолка";

        @When("Наводит на пункт Автобарахолка")
        public void hoverToTheAutoButton() {
            actions().moveToElement(getElement(autofleaMarket)).perform();
        }

        @Then("Появляется подменю с категориями Автобарахолки")
        public void checkMenuAutofleaMarket() {
            List<String> expectedAutoItems = Arrays.asList(
                    "Отзывы об авто",
                    "Новые авто",
                    "С пробегом",
                    "Цена с НДС",
                    "Авто до 4000 р.",
                    "Авто до 10 000 р.",
                    "Минск",
                    "Гомель",
                    "Могилев",
                    "Витебск",
                    "Гродно",
                    "Брест",
                    "Audi",
                    "BMW",
                    "Citroen",
                    "Ford",
                    "Mazda",
                    "Mercedes-Benz",
                    "Nissan",
                    "Opel",
                    "Peugeot",
                    "Renault",
                    "Toyota",
                    "Volkswagen"
            );

            List<String> actualAutoItems = getListMenu(autofleaMarket);
            assertThat(actualAutoItems).containsExactlyInAnyOrderElementsOf(expectedAutoItems);

            }
        }



