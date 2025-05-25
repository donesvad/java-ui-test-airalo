package com.donesvad.page;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

import java.util.function.Function;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.donesvad.component.PackageDetailComponent;

public class StorePage extends BasePage {
    private final SelenideElement header = $(".header");
    private final SelenideElement heroContainer = $(".hero-container");
    private final SelenideElement searchInput = $(".country-search-component input[data-testid='search-input']");
    private final SelenideElement storeContainer = $(".store-container");
    private final SelenideElement storeTitleElement = $("#store-title");
    private final ElementsCollection simItemCollection = $$(".sim-item");

    private final Function<String, String> getSectionSelector = (section) -> "//div[contains(@class, 'country-search-component')]//p[text()='" + section + "']";
    private final Function<String, String> getDestinationFromSectionSelector = (destination) -> "/../..//following-sibling::li/span[contains(@class, 'country-name') and @data-testid = '" + destination + "-name']";
    private final String buyNowButtonSelector = "div[data-testid='esim-button'] button";

    @Override
    public void isLoaded() {
        header.shouldBe(visible);
        heroContainer.shouldBe(visible);
        searchInput.shouldBe(visible);
        storeContainer.shouldBe(visible);
    }

    public void inputSearchItem(String search) {
        searchInput.setValue(search);
    }

    public void selectDestination(String destination, String section) {
        String sectionSelector = getSectionSelector.apply(section);
        String destinationSelector = getDestinationFromSectionSelector.apply(destination);
        SelenideElement destinationElement = $x(sectionSelector + destinationSelector);
        destinationElement.shouldHave(text(destination));
        destinationElement.click();
    }

    public void verifyStoreTitle(String storeTitle) {
        storeTitleElement.shouldHave(text(storeTitle));
    }

    public PackageDetailComponent selectPurchasableItemByIndex(Integer itemIndex) {
        SelenideElement firstPurchasableItem = simItemCollection.filter(not(partialText("Free"))).get(itemIndex);
        firstPurchasableItem.$(buyNowButtonSelector).click();
        return page(PackageDetailComponent.class);
    }
}
