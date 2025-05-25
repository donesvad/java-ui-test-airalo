package com.donesvad.stepdef;

import com.donesvad.component.PackageDetailComponent;
import com.donesvad.util.ConfigManager;

import io.cucumber.java.en.Then;

public class PackageDetailSteps extends BaseSteps {

    private final PackageDetailComponent packageDetailComponent = new PackageDetailComponent();

    @Then("user is on the {int} {string} package details page")
    public void userIsOnThePackageDetailsPage(int itemIndex, String destination) {
        packageDetailComponent.verifyPackageDetailsPage(ConfigManager.getPackageTestData("package." + destination.toLowerCase() + "." + itemIndex));
    }
}
