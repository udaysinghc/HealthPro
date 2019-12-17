Feature: PRO CREATE FULL SCHEDULE of 'SERVICE AND RATES' Test

	Scenario: Open Browser
	Given Launch the browser
	
	Scenario: 'PRO SIGN UP' on Heathpro plus
	Given Sign up to monthly on Heathpro plus
	
	Scenario: Add 'Locations & Availability' for clients
#	And Click on 'Services & Rates' Side-Bar
	Then Select 'Availability' Side-Bar Menu options
	And Verify "Locations & Availability" panel header Title text
	
	
	Scenario Outline: Add 'My Office/Studio' Location services for clients
	And Click on 'Add Location' button
	And Verify "ADD NEW LOCATION" div title text
	And Enter name of location as "<location>"
	And Enter address as "<address>"
	And Select Day as "<Day>"
	And Select availability form "<Start time>" To "<End time>"
	And Click on 'New Interval' options
	And Select availability form "<Start time 2>" To "<End time 2>" from 'New Interval'
	And Select Day from 'New Interval' as "<Day2>"
	And click on 'Save Location' button
	And Verify "Locations & Availability" panel header Title text
	And Verify Name of "<location>" is saved or not
	And Verify "<address>" is saved or not	
	
	Examples:
	|location|address                           |Day|Start time|End time|Day2|Start time 2|End time 2|
	|Office  |523 6th Ave, New York, 10011, US  |Mon|5:30 pm   |7:30 pm |Thu |7:30 pm     |8:30 pm   |
	
	Scenario Outline: Add 'Home Visits' Location services for clients
	And Click on 'Add Location' button
	And Verify "ADD NEW LOCATION" div title text
	And Select "Home Visits" location Type options
	And Enter name of location as "<location>"
	And Enter address as "<address>"
	And Select Day as "<Day>"
	And Select availability form "<Start time>" To "<End time>"
	And Click on 'New Interval' options
	And Select availability form "<Start time 2>" To "<End time 2>" from 'New Interval'
	And Select Day from 'New Interval' as "<Day2>"
	And click on 'Save Location' button
	And Verify "Locations & Availability" panel header Title text
	And Verify Name of "<location & Miles>" is saved or not
	And Verify "<address>" is saved or not	
	Examples:
	|location    |address                           |Day|Start time|End time|Day2|Start time 2|End time 2|location & Miles       |
	|Home Service|120 Broadway, New York, 10271, US |Tue|5:30 pm   |7:30 pm |Fri |7:30 pm     |8:30 pm   |Home Service (15 miles)|
	
	Scenario Outline: Add 'My Office/Studio' Location services for clients
	And Click on 'Add Location' button
	And Verify "ADD NEW LOCATION" div title text
	And Select "Virtual/ Remote" location Type options
	And Enter name of location as "<Title>"
	And Enter Meeting note & "<Details>"
	And Select Day as "<Day>"
	And Select availability form "<Start time>" To "<End time>"
	And Click on 'New Interval' options
	And Select availability form "<Start time 2>" To "<End time 2>" from 'New Interval'
	And Select Day from 'New Interval' as "<Day2>"
	And click on 'Save Location' button
	And Verify "Locations & Availability" panel header Title text
	And Verify Name of "<Title>" is saved or not
	And Verify "<Details>" div is saved or not	
	Examples:
	|Title    |Details            |Day|Start time|End time|Day2|Start time 2|End time 2|
	|Aws      |Amozon WebServices |Wed|5:30 pm   |7:30 pm |Sat |7:30 pm     |8:30 pm   |
	
	Scenario Outline: Add 'SESSIONS' for clients
	And Click on 'Sessions' Side-Bar Menu options
	And Verify "SESSIONS" panel header Title text
	And Click on 'Add Session' button
	And Verify "YOUR SERVICES" div title text
	And Search & Select your services as "<services>"
	And Select "<ONE service>" that you provide.
	And Select "Home" Where you provide above services
	And Select "Office" Where you provide above services
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
	|services   |services2   |duration |discounts|class   |
	|Yoga       |Bhakti Yoga |10       |20       |Recurring Class|
	
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
	|Yoga       |Bhakti Yoga |10       |20       |One-time only Classes|
	
	Scenario Outline: Add 'Packages with 3 sessions' for clients
	And Click on 'Packages' Side-Bar Menu options
	And Verify "PACKAGES" panel header Title text
	And Click on 'Add a Package' button
	And Verify "SETUP NEW PACKAGE" div title text
	And Enter "title" of your "<Title>"
	And Select "<No of Sessions>" for this Packages
	And Enter "<Total Price>" for Packages
	And Select "<services>" check box for which Packages is used
	Then Click on 'Save Package' button
	And Verify "Your changes have been saved" message appears
	And Verify Name of "<Title>" is saved or not
	
	Examples:
	|Title					|Total Price|services|No of Sessions|
	|Package With 3 sessions|100		|2 hrs   |3             |
	
	Scenario Outline: Add 'Packages with 5 sessions' for clients
	And Verify "PACKAGES" panel header Title text
	And Click on 'Add a Package' button
	And Verify "SETUP NEW PACKAGE" div title text
	And Enter "title" of your "<Title>"
	And Select "<No of Sessions>" for this Packages
	And Enter "<Total Price>" for Packages
	And Select "<services>" check box for which Packages is used
	Then Click on 'Save Package' button
	And Verify "Your changes have been saved" message appears
	And Verify Name of "<Title>" is saved or not
	
	Examples:
	|Title					|Total Price|services|No of Sessions|
	|Package With 5 sessions|150		|2 hrs   |5             |
	
	Scenario: Specify populations which are 'suitable' for your services.
	And Click on 'Clients' Side-Bar
    And Click on 'Suitability' Side-Bar Menu options
    And Verify "Suitability" panel header Title text
    And click on "Age Group" item panel to open it
    And Select "Children" from listed item
    And Select "Adults" from listed item
    And click on "Gender Identities Served" item panel to open it
    And Select "Men Only" from listed item
    And click on "Special Needs" item panel to open it
    And Select "Blind" from listed item
    And Select "Physically Disabled" from listed item
    When Click on 'Save Changes' button
    Then Verify "Your changes have been saved" message appears
    And Verify "Children" is properly selcted from listed item or not
    And Verify "Adults" is properly selcted from listed item or not
    And Verify "Men Only" is properly selcted from listed item or not
    And Verify "Blind" is properly selcted from listed item or not
    And Verify "Physically Disabled" is properly selcted from listed item or not
        
	
	Scenario Outline: fill 'My Clients' form with valid data
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
    |Robert    |Miles    |(812)3456789 |
    
    Scenario: Quite Browser
	And close the broswer
	
	
	
	
	
	
	
	