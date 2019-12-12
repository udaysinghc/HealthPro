Feature: Create ' Client PRO ' 10 Test Account

Scenario Outline: Create ' Client PRO ' Test Account on Branch
	Given Launch the browser
	When Open the application url.
	Then Sign up 'Client PRO' with "<Email Address>" user on Heathpro plus
	
#	For Create New Session

	And Click on 'Sessions' Side-Bar Menu options
	And Verify "SESSIONS" panel header Title text
	And Click on 'Add Session' button
	And Verify "YOUR SERVICES" div title text
	And Search & Select your services as "Acro Yoga"
	And Select "Hatha Yoga" that you provide.
	And Select "Home" Where you provide above services
	And Select Session duration as "60"
	And Enter discounts for Session as "15"
	And Click on 'Add New Session Rate' options
	And Select 'New Session' duration as "120"
	And Enter 'New discounts' for New Session as "20"
	And click on 'Save Service' button
	And Verify "Your changes have been saved" message appears

#	For Add New Classes

	And Click on 'Classes' Side-Bar Menu options
	And Verify "CLASSES" panel header Title text
	And Click on 'Add New Class' button
	And Verify "ADD NEW CLASS" div title text
	And Search & Select your services as "Yoga"
	And Select your services as "Bhakti Yoga"
	And Enter "title" of your "Recurring Class"
	And Select Session duration as "10"
	And Enter discounts for Session as "20"
	And Select 'today's' date from calendar
	Then Click on 'Save Class' button
	And Verify "Your changes have been saved" message appears
	And Verify Name of "Recurring Class" is saved or not
	
	#	For Add New Packages
	
	And Click on 'Packages' Side-Bar Menu options
	And Verify "PACKAGES" panel header Title text
	And Click on 'Add a Package' button
	And Verify "SETUP NEW PACKAGE" div title text
	And Enter "title" of your "Package With 3 sessions"
	And Select "3" for this Packages
	And Enter "100" for Packages
	And Select "2 hrs" check box for which Packages is used
	Then Click on 'Save Package' button
	And Verify "Your changes have been saved" message appears
	And Verify Name of "Package With 3 sessions" is saved or not
	And close the broswer
	
	Examples:
	|Email Address         |
	|clientpro0123132123@getnada.com|
#	|clientpro02@getnada.com|
#	|clientpro03@getnada.com|
#	|clientpro04@getnada.com|
#	|clientpro05@getnada.com|
#	|clientpro06@getnada.com|
#	|clientpro07@getnada.com|
#	|clientpro08@getnada.com|
#	|clientpro09@getnada.com|
#	|clientpro10@getnada.com|
	
	
	