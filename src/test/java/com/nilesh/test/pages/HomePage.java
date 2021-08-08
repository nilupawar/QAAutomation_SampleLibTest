package com.nilesh.test.pages;

import com.nilesh.lib.config.TestScenario;
import com.nilesh.lib.core.BasePage;
import com.nilesh.lib.elements.PageElement;

import static com.nilesh.lib.types.ElementType.DROP_BOX;
import static com.nilesh.lib.types.ElementType.LINK;
import static com.nilesh.lib.types.LocatorType.ID;
import static com.nilesh.lib.types.LocatorType.LINK_TEXT;


public class HomePage extends BasePage {
    public HomePage(TestScenario testScenario) {
        super(testScenario, "craigslist");
    }

    // --------------------------------------------------------------------------------------
    // Page elements
    public final PageElement languageSelect = new PageElement(driver, DROP_BOX, "language Selection", ID, "chlang");
    public final PageElement aptHousingLink = new PageElement(driver, LINK, "Apt/Housing link", LINK_TEXT, "apts / housing");

    // --------------------------------------------------------------------------------------


}
