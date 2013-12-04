import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.junit.Assert.*;


public class GuildedRoseStepDefs {
	private static final int MAXIMUM_QUALITY_VALUE = 50;
	private static final int INITIAL_SELL_IN = 5;
	private static final int INITIAL_QUALITY_VALUE = 10;

	@Given("^a basic item$")
	public void a_basic_item() throws Throwable {
		Item basicItem = new Item("Basic Item", INITIAL_SELL_IN, INITIAL_QUALITY_VALUE);
		GildedRose.setItem(basicItem);
	}
	
	@Given("^a basic item whose sell in has passed$")
	public void a_basic_item_whose_sell_in_has_passed() throws Throwable {
		Item basicItem = new Item("Basic Item", 0, INITIAL_QUALITY_VALUE);
		GildedRose.setItem(basicItem);
	}
	
	@Given("^Aged Brie with maximum quality$")
	public void Aged_Brie_with_maximum_quality() throws Throwable {
		Item agedBrie = new Item("Aged Brie", INITIAL_SELL_IN, MAXIMUM_QUALITY_VALUE);
		GildedRose.setItem(agedBrie);	    
	}
	
	@Given("^Aged Brie$")
	public void Aged_Brie() throws Throwable {
		Item agedBrie = new Item("Aged Brie", INITIAL_SELL_IN, INITIAL_QUALITY_VALUE);
		GildedRose.setItem(agedBrie);
	}
	
	@Given("^Sulfuras, Hand of Ragnaros$")
	public void Sulfuras_Hand_of_Ragnaros() throws Throwable {
	    Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", INITIAL_SELL_IN, INITIAL_QUALITY_VALUE);
	    GildedRose.setItem(sulfuras);
	}
	
	@Given("^Sulfuras, Hand of Ragnaros with quality greater than maximum$")
	public void Sulfuras_Hand_of_Ragnaros_with_quality_greater_than_maximum() throws Throwable {
	    Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", INITIAL_SELL_IN, MAXIMUM_QUALITY_VALUE * 2);
	    GildedRose.setItem(sulfuras);
	}
	
	@Given("^Backstage passes sell in of (\\d+) and quality of (\\d+)$")
	public void Backstage_passes_sell_in_of_and_quality_of(int sellIn, int quality) throws Throwable {
		Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
		GildedRose.setItem(backstagePass);
	}

	@Given("^(.+) with quality of (\\d+)$")
	public void item_with_quality_of(String itemName, int quality) throws Throwable {
		Item item = new Item(itemName, INITIAL_SELL_IN, quality);
		GildedRose.setItem(item);
	}

	@When("^the day ends$")
	public void the_day_ends() throws Throwable {
		GildedRose.updateQuality();
	}

	@Then("^the sell in will decrease by one$")
	public void the_sell_in_will_decrease_by_one() throws Throwable {
		Item curItem = GildedRose.getFirstItem();
		assertEquals(INITIAL_SELL_IN - 1, curItem.sellIn);
	}
	
	@Then("^the quality will decrease by (\\d+)$")
	public void the_quality_will_decrease_by(int decreaseAmount) throws Throwable {
		Item curItem = GildedRose.getFirstItem();
		assertEquals(INITIAL_QUALITY_VALUE - decreaseAmount, curItem.quality);
	}
	
	@Then("^the quality will remain at (\\d+)$")
	public void the_quality_will_remain_at(int expectedQuality) throws Throwable {
		Item curItem = GildedRose.getFirstItem();
		assertEquals(expectedQuality, curItem.quality);
	}

	@Then("^the quality will remain at maximum quality$")
	public void the_quality_will_remain_at_maximum_quality() throws Throwable {
		Item curItem = GildedRose.getFirstItem();
		assertEquals(MAXIMUM_QUALITY_VALUE, curItem.quality);
	}

	@Then("^the sell in value will remain the same$")
	public void the_sell_in_value_will_remain_the_same() throws Throwable {
		Item curItem = GildedRose.getFirstItem();
		assertEquals(INITIAL_SELL_IN, curItem.sellIn);
	}

	@Then("^the quality will not change$")
	public void the_quality_will_not_change() throws Throwable {
		Item curItem = GildedRose.getFirstItem();
		assertEquals(MAXIMUM_QUALITY_VALUE * 2, curItem.quality); 
	}

	@Then("^the quality will increase by (\\d+)$")
	public void the_quality_will_increase_by(int increaseAmount) throws Throwable {
		Item curItem = GildedRose.getFirstItem();
		assertEquals(INITIAL_QUALITY_VALUE + increaseAmount, curItem.quality);
	}

	@Then("^the quality will be (\\d+)$")
	public void the_quality_will_be(int expectedQuality) throws Throwable {
		Item item = GildedRose.getFirstItem();
		assertEquals(expectedQuality, item.quality);
	}
}
