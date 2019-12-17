Feature: PRO SignUp & 'Invite Clients' & 'Book A Session' Test

	Scenario: Open Browser
	Given Launch the browser
	
	Scenario: 'PRO SIGN UP' on Heathpro plus
	Given Sign up to monthly on Heathpro plus
	
	Scenario Outline: Add 'SESSIONS' for clients
	And Click on 'Sessions' Side-Bar Menu options
	And Verify "SESSIONS" panel header Title text
	And Click on 'Add Session' button
	And Verify "YOUR SERVICES" div title text
	And Search & Select your services as "<services>"
	And Select "<ONE service>" that you provide.
	And Select "Home" Where you provide above services
	And Select Session duration as "<duration>"
	And Enter discounts for Session as "<discounts>"
	And Click on 'Add New Session Rate' options
	And Select 'New Session' duration as "<New duration>"
	And Enter 'New discounts' for New Session as "<New discounts>"
	And click on 'Save Service' button
	And Verify "Your changes have been saved" message appears
	
	Examples:
	|services  |ONE service|location|duration   |New duration|New discounts|discounts|
	|Acro Yoga |Hatha Yoga |Home    |60			|120         |15           |20       |
	
	Scenario Outline: fill 'My Clients' form with valid data
	And Click on 'Clients' Side-Bar
    Then Select 'My Clients' Side-Bar Menu options
    And Verify "My Clients" panel header Title text
    And Click on 'Invite Your Clients' button
    And Verify "Choose your way to invite your clients" popup header Title text
    And Click on 'Fill in Form' button
    And Verify "Fill The Form" popup header Title text
    And Enter Clients "first_name" in text box as "<first_name>"
    And Enter Clients "last_name" in text box as "<last_name>"
    And Enter Clients "email" in text box "<email>"
    And Click on 'Upload and Send Emails' button
    And Verify "Inviting Client(s) Complete" popup header Title text
    And Click on 'View Reports' link
    And Verify email sent to correct user
    When Click on 'Done' button
    And Verify "My Clients" panel header Title text
    Then Verify user is listed under 'Pending Invitations' section
       
    Examples:
    |first_name|last_name|phone        |
    |Client    |Test     |(812)3456789 |
	 
	 Scenario: Logout Application
    And Logout Application
    
    Scenario: Open Mail & verify Client invitaion sent
    When Open Client Mail Inbox
    Then Verify Invitaion mail received 
    And Click on 'Click here' link to create FREE account
    
    Scenario Outline: Set Client 'Password'
    When Verify "Set password" panel open
    Then Enter "<New Password>" in text filed
    And Enter Confirm "<New Password>" in text field
    And Click on 'I agree to HealthPRO's' TC check box
    And Click on 'Set Password' button
    And Verify "Your password has been successfully set" appears & click on Ok button
    Examples:
    |New Password|
    |Test2019    |
    
    Scenario: Buy 'Package' With 5 sessions
    When Verify "Session" is selected for Booking
    Then Select "2 hrs" Duration
    And Click on "Continue" button at "Duration"
    And Select available 'appointment' date from calendar
    And Select Booking Time for 'appointment'
    And Click on "Continue" button at "Book session"    
    And Verify "Booking Information" block appears
	And Click on "Confirm Booking" button
    And Verify "Book An Appointment" wizard open
    And Verify 'Booking Successful' success message appears on prompt
    And Click on "View Appointments" Link
    
    Scenario: Phone Number Verification
    When Verify "Phone Number Verification" prompt open
    Then Verify Mobile number using SMS 
    And Verify "My HealthPROs" panel header Title text
    
    Scenario: Complete 'My Profile' Basic Info details
    When Click on 'My Profile' Side-Bar
    Then Select 'Basic Info' Side-Bar Menu options
    And Verify "Basic Info" panel header Title text
    And Select 'Date of Birth' of Clients
    When Click on "Update" button 
    And Verify "Your changes have been saved" message appears
    
    Scenario Outline: Complete 'My Profile' Basic Info details
    When Select 'Home Visits Locations' Side-Bar Menu options
    Then Verify "Home Visits Locations" panel header Title text
    And Click on "Add New Home Visit Location" button
    And Verify "Add New Address" popup header Title text
    And Enter "<Location Name>" in "name" field
    And Enter "<Address>" in "address" field
    When Click on "Save Location" button 
    Then Verify "<Location Name>" is appears in list
    Then Verify "<Address>" is appears in list
    Examples:
	|Location Name |Address                              |
	|Client-Home   |120 Broadway, New York, NY 10271, US |	
	
	Scenario Outline: Add New 'Credit Cards' Details
	When Click on 'Account Settings' Side-Bar
    Then Select 'Credit Cards' Side-Bar Menu options
    And Verify "Payments" panel header Title text
    When Click on "Add New Card" button
    Then 'Add Credit Card' promt open
    And Enter "card_number" as "<card Number>" at 'Add New Credit Card'
	And Enter "card_holder" as "<NameOnCard>" at 'Add New Credit Card'
	And Enter "card_exp" as "<Expire Date>" at 'Add New Credit Card'
	And Enter "card_cvv" as "<card cvv>" at 'Add New Credit Card'
	And Select 'Save as Default Credit Card' check box
	When Click on "Save New Card" button
	Examples:
	|card Number     |NameOnCard |Expire Date|card cvv|
	|4111111111111111|ClientTest |02/22      |123     |
	
	Scenario Outline: Add New 'Credit Cards' Details
	And Verify "Payments" panel header Title text
    When Click on "Add New Card" button
    Then 'Add Credit Card' promt open
    And Enter "card_number" as "<card Number>" at 'Add New Credit Card'
	And Enter "card_holder" as "<NameOnCard>" at 'Add New Credit Card'
	And Enter "card_exp" as "<Expire Date>" at 'Add New Credit Card'
	And Enter "card_cvv" as "<card cvv>" at 'Add New Credit Card'
	When Click on "Save New Card" button
	Then Verify "<NameOnCard>" is appears in list
	And Click on 'Edit' card button 
	Then 'Edit Credit Card' promt open
	And Enter "card_cvv" as "<card cvv>" at 'Add New Credit Card'
	And Select 'Save as Default Credit Card' check box
	When Click on "Save New Card" button
	Examples:
	|card Number     |NameOnCard|Expire Date|card cvv |
	|5105105105105100|Client    |02/22      |123      |
	
	 Scenario: Quite Browser
	And close the broswer