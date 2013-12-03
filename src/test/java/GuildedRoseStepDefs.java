import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.runtime.PendingException;

import static org.junit.Assert.*;


public class GuildedRoseStepDefs {
	@Given("^*(.+) with sell in of (\\d+)$")
	public void item_with_sell_in_of(String itemName, int sellIn) throws Throwable {
		Item item = new Item(itemName, sellIn, 20);
		GildedRose.setItem(item);
	}

	@When("^the day ends$")
	public void the_day_ends() throws Throwable {
		GildedRose.updateQuality();
	}

	@Then("^the sell in will be (\\d+)$")
	public void the_sell_in_will_be(int expectedSellIn) throws Throwable {
		Item curItem = GildedRose.getFirstItem();
		assertEquals(expectedSellIn, curItem.sellIn);
	}

	@Given("^(.+) with sell in of (\\d+) and quality of (\\d+)$")
	public void item_with_sell_in_of_and_quality_of(String itemName, int sellIn, int quality) throws Throwable {
		Item item = new Item(itemName, sellIn, quality);
		GildedRose.setItem(item);
	}

	@Then("^the quality will be (\\d+)$")
	public void the_quality_will_be(int expectedQuality) throws Throwable {
		Item item = GildedRose.getFirstItem();
		assertEquals(expectedQuality, item.quality);
	}

	@Given("^(.+) with quality of (\\d+)$")
	public void item_with_quality_of(String itemName, int quality) throws Throwable {
		Item item = new Item(itemName, 99, quality);
		GildedRose.setItem(item);
	}
}
