Feature: Gilded Rose Existing Functionality 
	
Scenario: At the end of a day, a basic item will decrease its sell in by one
	Given a basic item
	When the day ends
	Then the sell in will decrease by one
	
Scenario: At the end of a day, a basic item will decrease its quality by one
	Given a basic item
	When the day ends
	Then the quality will decrease by 1
	
Scenario: A basic item whose sell in has passed, quality will decrease by two
	Given a basic item whose sell in has passed
	When the day ends
	Then the quality will decrease by 2
		
Scenario: The quality of an item is never negative 
	Given a basic item with quality of 0 
	When the day ends 
	Then the quality will remain at 0 
	
Scenario: Aged Brie increases in quality the older it gets 
	Given Aged Brie
	When the day ends 
	Then the quality will increase by 1 
	
Scenario: Quality of an existing aged brie will never exceed a maximum quality
	Given Aged Brie with maximum quality
	When the day ends
	Then the quality will remain at maximum quality
	
Scenario: Quality of an exiting item will never exceed 50 
	Given Aged Brie with quality of 50 
	When the day ends 
	Then the quality will be 50 
	
Scenario: Sulfurus never has to be sold 
	Given Sulfuras, Hand of Ragnaros
	When the day ends 
	Then the sell in value will remain the same
	
Scenario: Quality of sulfurus set to be greater than maximum will remain at that value
	Given Sulfuras, Hand of Ragnaros with quality greater than maximum
	When the day ends 
	Then the quality will not change
	
Scenario Outline:
Backstage passes increase in quality on an excelerated schedule 
	Given Backstage passes sell in of <Initial SellIn> and quality of <Initial Quality> 
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
