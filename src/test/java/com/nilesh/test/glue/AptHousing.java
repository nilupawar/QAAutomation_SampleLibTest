package com.nilesh.test.glue;

import com.nilesh.lib.config.TestScenario;
import com.nilesh.test.pages.AptHousingPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AptHousing {
    private final AptHousingPage aptHousingPage;

    public AptHousing(TestScenario testScenario) {
        aptHousingPage = new AptHousingPage(testScenario);
    }

    @When("^ascending price sort order is selected$")
    public void itemsAreSortedByPriceInAscendingOrder() {
        aptHousingPage.sortItemsByAscendingPrice();
    }

    @Then("^items should be displayed in price ascending order$")
    public void itemsShouldBeDisplayedInPriceAscendingOrder() {
        Assert.assertTrue(aptHousingPage.isSortedByPriceAsc());
    }

    @When("^descending price sort order is selected$")
    public void itemsAreSortedByPriceInDescendingOrder() {
        aptHousingPage.sortItemsByDescendingPrice();
    }

    @Then("^items should be displayed in price descending order$")
    public void itemsShouldBeDisplayedInPriceDescendingOrder() {
        Assert.assertTrue(aptHousingPage.isSortedByPriceDesc());
    }

    @Then("^user should be on apts/housing page$")
    public void isValidAptHousingPage() {
        Assert.assertTrue(aptHousingPage.isValidPage());
    }

    @When("user search for {string} apartment")
    public void searchItem(String searchItem) {
        aptHousingPage.searchItem(searchItem);
    }

    @Then("default sort should be set to {string}")
    public void checkDefaultSortCriteria(String defaultSort) {
        Assert.assertEquals(defaultSort, aptHousingPage.getDefaultSortOption());
    }

    @Then("items should be sorted based on newest sort criteria")
    public void newestSortCriteria() {
        Assert.assertTrue(aptHousingPage.isSortedByNewest());
    }


    @And("sorting menu should have following options")
    public void afterSearchCheckMenuOptions(DataTable menus) {
        List<String> expMenusOptions = convertDataTableToFlatList(menus);
        expMenusOptions.sort(Comparator.naturalOrder());
        List<String> actMenusOptions = aptHousingPage.getMenuOptions();
        actMenusOptions.sort(Comparator.naturalOrder());
        Assert.assertEquals(expMenusOptions, actMenusOptions);
    }


    private List<String> convertDataTableToFlatList(DataTable dataTable) {
        List<List<String>> dataTableList = dataTable.asLists();
        return dataTableList.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
