Feature: Create 'PRO SIGN UP AS Client' 10 Test Account

Scenario Outline: 'SignUp As a Client ' on Branch
	Given Launch the browser
	And Open the application url.
	When Click on 'Sign Up / Log In' Link 
	Then I verify the "Log Into Your HealthPRO Account" popup 
	When Click on "Sign Up as a Client" Button 
	Then I verify the "Sign Up as a Client" popup 
	And Enter "Test" in "first_name" TextBox at Sign_In_popup
	And Enter "Client" in "last_name" TextBox at Sign_In_popup
	And Enter "<Email Address>" in TextBox For SignUp
	And Enter "Password123" at 'Create a Password' Textbox
	And Select 'I agree to HealthPRO's' check box
	When Click on "Create a New Account" button
	Then I should See Get Started Page
    And close the broswer
    Examples:
    |Email Address           |
    |testclient01@getnada.com|
    |testclient02@getnada.com|
    |testclient03@getnada.com|
    |testclient04@getnada.com|
    |testclient05@getnada.com|
