Feature: Gilded Rose Existing Functionality 

Scenario: At the end of a day, an item will decrease its sell in by one 
	Given +5 Dexterity Vest with sell in of 5 
	When the day ends 
	Then the sell in will be 4 
	
Scenario: At the end of a day, an item will decrease its quality by one 
	Given +5 Dexterity Vest with sell in of 6 and quality of 5 
	When the day ends 
	Then the quality will be 4 
	
Scenario: If the sell in has passed, Quality degrades twice as fast 
	Given +5 Dexterity Vest with sell in of 0 and quality of 10 
	When the day ends 
	Then the quality will be 8 
	
Scenario: The quality of an item is never negative 
	Given +5 Dexterity Vest with quality of 0 
	When the day ends 
	Then the quality will be 0 
	
Scenario: Aged Brie increases in quality the older it gets 
	Given Aged Brie with quality of 42 
	When the day ends 
	Then the quality will be 43 
	
Scenario: Quality of an exiting item will never exceed 50 
	Given Aged Brie with quality of 50 
	When the day ends 
	Then the quality will be 50 
	
Scenario: Sulfurus never has to be sold 
	Given Sulfuras, Hand of Ragnaros with sell in of 10 
	When the day ends 
	Then the sell in will be 10 
	
Scenario: Quality of sulfurus will never change 
	Given Sulfuras, Hand of Ragnaros with quality of 40 
	When the day ends 
	Then the quality will be 40 
	
Scenario: Quality of sulfurus can be greater than 50 
	Given Sulfuras, Hand of Ragnaros with quality of 80 
	When the day ends 
	Then the quality will be 80 
	
Scenario Outline:
Backstage passes increase in quality on an excelerated schedule 
	Given Backstage passes to a TAFKAL80ETC concert with sell in of <Initial SellIn> and quality of <Initial Quality> 
	When the day ends 
	Then the quality will be <After Quality> 
	
	Examples: 
		| Initial Quality | Initial SellIn | After Quality |
		| 20              | 11             | 21            |
		| 42              | 10             | 44            |
		| 27			  | 6			   | 29			   |
		| 35              | 5              | 38            |
		| 20			  | 1			   | 23			   |
		| 15			  | 0			   | 0             |
