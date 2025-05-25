package com.donesvad.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ConfigProperty {
    BASE_URL("base.url"),
    BROWSER("browser"),
    HEADLESS("headless"),
    SELENIUM_HUB_URL("selenide.remote"),
    TITLE("title"),
    COVERAGE("coverage"),
    DATA("data"),
    VALIDITY("validity"),
    PRICE("price");

    private final String value;
}
