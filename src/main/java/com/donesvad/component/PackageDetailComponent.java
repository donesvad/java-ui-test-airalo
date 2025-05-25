package com.donesvad.component;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import com.donesvad.dto.Package;

public class PackageDetailComponent extends BaseComponent {
    private final SelenideElement simDetailHeaderElement = $("div[data-testid='sim-detail-header']");
    private final SelenideElement simDetailContentElement = $(".sim-detail-content");
    private final SelenideElement simDetailFooterElement = $("div[data-testid='sim-details-footer']");
    private final String simDetailSelector = "div[data-testid='sim-detail-operator-title']";
    private final String simDetailCoverageSelector = "p[data-testid='COVERAGE-value']";
    private final String simDetailDataSelector = "p[data-testid='DATA-value']";
    private final String simDetailValiditySelector = "p[data-testid='VALIDITY-value']";
    private final String simDetailPriceSelector = "p[data-testid='PRICE-value']";

    @Override
    public void isLoaded() {
        simDetailHeaderElement.shouldBe(visible);
        simDetailContentElement.shouldBe(visible);
        simDetailFooterElement.shouldBe(visible);
    }

    public void verifyPackageDetailsPage(Package expectedPackage) {
        simDetailHeaderElement.$(simDetailSelector).shouldHave(text(expectedPackage.getTitle()));
        simDetailHeaderElement.$(simDetailCoverageSelector).shouldHave(text(expectedPackage.getCoverage()));
        simDetailHeaderElement.$(simDetailDataSelector).shouldHave(text(expectedPackage.getData()));
        simDetailHeaderElement.$(simDetailValiditySelector).shouldHave(text(expectedPackage.getValidity()));
        simDetailHeaderElement.$(simDetailPriceSelector).shouldHave(text(expectedPackage.getPrice()));
    }
}
