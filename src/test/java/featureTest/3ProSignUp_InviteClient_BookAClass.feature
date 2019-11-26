Feature: PRO SignUp & 'Invite Clients' & 'Book A Class' Test

Scenario: Open Browser
	Given Launch the browser
	
	Scenario: 'PRO SIGN UP' on Heathpro plus
	Given Sign up to monthly on Heathpro plus
	
	Scenario Outline: Add 'Recurring Classes' for clients
	And Click on 'Classes' Side-Bar Menu options
	And Verify "CLASSES" panel header Title text
	And Click on 'Add New Class' button
	And Verify "ADD NEW CLASS" div title text
	And Search & Select your services as "<services>"
	And Select your services as "<services2>"
	And Enter "title" of your "<class>"
	And Select Session duration as "<duration>"
	And Enter discounts for Session as "<discounts>"
	And Select 'today's' date from calendar
	Then Click on 'Save Class' button
	And Verify "Your changes have been saved" message appears
	And Verify Name of "<class>" is saved or not
	
	Examples:
	|services   |services2   |duration |discounts|class          |
	|Fitness    |Boxing      |10       |20       |Recurring Class|
	
	Scenario Outline: Add 'One-time only Classes' for clients
	And Verify "CLASSES" panel header Title text
	And Click on 'Add New Class' button
	And Verify "ADD NEW CLASS" div title text
	And Search & Select your services as "<services>"
	And Select your services as "<services2>"
	And Enter "title" of your "<class>"
	And Select "One-time only" Class Type
	And Select Session duration as "<duration>"
	And Enter discounts for Session as "<discounts>"
	And Select Single date from calendar
	Then Click on 'Save Class' button
	And Verify "Your changes have been saved" message appears
	And Verify Name of "<class>" is saved or not
	
	Examples:
	|services   |services2   |duration |discounts|class                |
	|Dance      |Dancercise  |30       |20       |One-time only Classes|
	
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
#    And Enter Clients "phone" in text box as "<phone>"
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
    
    Scenario: Book a Avialable 'Recurring Class' Class
    When Select "Fitness" 'CATEGORIES' form list
    Then Verify "Recurring Class" class available under "Fitness" CATEGORIES
    And Click on "Recurring Class" options
#    And Choose your start date to Start Class
    And Click on Book "Recurring Class" button
    And Verify "Booking Information" block appears
	And Click on "Confirm Booking" button
    And Verify "Book A Class" wizard open
    And Verify "You've done it!" success message appears on prompt
    And Click on "View Classes" Link
     
    Scenario: Phone Number Verification
    When Verify "Phone Number Verification" prompt open
    Then Verify Mobile number using SMS 
#   And Verify "My Bookings" panel header Title text
    And Verify "My HealthPROs" panel header Title text
     
    Scenario: Book a Avialable 'One-time only Classes' Class
    When click on 'Instructor' link for book class
    When Select "Dance" 'CATEGORIES' form list
    Then Verify "One-time only Classes" class available under "Dance" CATEGORIES
    And Click on "One-time only Classes" options
    And Click on Book "One-time only Classes" button
    And Verify "Booking Information" block appears
	And Click on "Confirm Booking" button
    And Verify "Book A Class" wizard open
    And Verify "You've done it!" success message appears on prompt
    And Click on "View Classes" Link
    
    Scenario: Quite Browser
	And close the broswer














    
    