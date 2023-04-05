Feature: Order the food

Scenario: User  Enters The Desired Location 
Given user Launch The Swiggy Application
When user  Enters the Location "Anna Nagar" In Location Field
And click Clear button
And enters the Location "Ann" In Location Field
Then select The Desired Location From The Location Suggestions and Navigates To Home Page
  

Scenario: Select The Required Food
Given user Is On Search Page
When user Enters The Required Food "Grill Chicken" In Search Box
And user Can Select The Required Food in Food List

Scenario: Add The Food Item In Cart
When user Select The Required Hotel and Add button
And click The Required Quantity and Add The Item In Cart
Then click Cart button and Check The Required Order Is In Cart
