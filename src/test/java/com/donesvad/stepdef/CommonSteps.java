package com.donesvad.stepdef;

import static com.codeborne.selenide.Selenide.page;
import static com.donesvad.util.ReflectionUtil.findAllClassesUsingClassLoader;
import static com.donesvad.util.ReflectionUtil.toUpperCamelCase;

import java.util.Map;

import com.donesvad.component.BaseComponent;
import com.donesvad.page.BasePage;

import io.cucumber.java.en.Then;
import lombok.Getter;

@Getter
public class CommonSteps extends BaseSteps {

    private final Map<String, Class<?>> allPageClassesUsingClassLoader = findAllClassesUsingClassLoader("com.donesvad.page");
    private final Map<String, Class<?>> allComponentClassesUsingClassLoader = findAllClassesUsingClassLoader("com.donesvad.component");

    @Then("user is on {string} page")
    public void userIsOnPage(String pageName) {
        String className = toUpperCamelCase(pageName + " page".toLowerCase(), true);
        Class<? extends BasePage> aClass = (Class<? extends BasePage>) allPageClassesUsingClassLoader.get(className);
        BasePage page = page(aClass);
        page.isLoaded();
    }

    @Then("user is on {string} component")
    public void userIsOnComponent(String componentName) {
        String className = toUpperCamelCase(componentName + " component".toLowerCase(), true);
        Class<? extends BaseComponent> aClass = (Class<? extends BaseComponent>) allComponentClassesUsingClassLoader.get(className);
        BaseComponent page = page(aClass);
        page.isLoaded();
    }
}
