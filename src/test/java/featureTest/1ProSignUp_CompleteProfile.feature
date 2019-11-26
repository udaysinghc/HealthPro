Feature: 'PRO SIGN UP AND COMPLETE PROFILE' Test

	Scenario: Open Browser
	Given Launch the browser
	
	Scenario: 'PRO SIGN UP' on Heathpro plus
	Given Sign up to monthly on Heathpro plus 
	
	Scenario Outline: Fill 'Basic Info' with valid data
	And Verify "Basic Info" panel header Title text
	And Enter 'About Me' "<message>" in text field
	And Enter 'Professional Statement' "<text message>" in text field
	And Select "English" Languages from dropdown list
	And Click on 'Update' button
	And Verify "Your changes have been saved" message appears
	And Verify 'About Me' "<message>" added text field or not
	And Verify 'Professional Statement' "<text message>" added text field or not
	And Verify "English" Languages is selected or not
	Examples:
	|message     |text message                                                       |
	|Professional|Adept medical doctor with eight solid years of practice experience.|
	
	Scenario: Fill 'photos and media' page with valid data 
	And Click on 'photos and media' Side-Bar menu options
	And Verify "Photos" panel header Title text 
	And Upload your 'Photo' 
	And Verify Photo is uploaded or not
	
	Scenario Outline: Add/Edit 'Youtube Video' for your client 
	And Click on 'Add Youtube Video' button
	And Enter YouTube Video Url in textbox as "<Youtube Url>"
	And Enter Video Title in textbox as "<Title>"
	And Click on 'Submit your YouTube video' button
	And Verify Video is uploaded or not
	
	Examples:
	|Youtube Url                                |Title     |
	|https://www.youtube.com/watch?v=YPZ8bpGndPo|HealthPro |
	
	Scenario: Invite your clients to follow you via 'Social Media'
	And Invite your clients to follow you via "Your Website" social networking 
	And Invite your clients to follow you via "twitter" social networking 
	And Invite your clients to follow you via "facebook" social networking 
	And Invite your clients to follow you via "linkedin" social networking 
	And Invite your clients to follow you via "pinterest" social networking 
	And Invite your clients to follow you via "instagram" social networking 
	And Invite your clients to follow you via "youtube" social networking 
	And Invite your clients to follow you via "ideafit" social networking 
	And Invite your clients to follow you via "Amazon" social networking 
	And Click on 'Update' button 
	Then Verify confirmation dialog prompt message & click on 'OK' button
	And Refresh browser & verify all entered Url at Socail media are properly added
	
	Scenario: Update 'Account Plan' details 
	And Click on 'Payment Info' Side-Bar
	Then Select 'Account Plan' Side-Bar Menu options
	And Verify "Account Plan Details" panel header Title text
	And Click on 'Change Plan' button
	And Verify "Upgrade Plan" popup header Title text
	And Click on 'Change to Monthly' plan button
	And Verify "Change My Plan" popup header Title text
	And Click on 'Change' button
	Then Click on 'Next' button
	And Verify plan 'Change to Monthly'
	
	Scenario Outline: Update 'Billing' Details
	And Verify "Account Plan Details" panel header Title text
	And Enter Billing Name as "<name>"
	And Enter Billing address as "<address>"
	Then Click on 'Update Billing Info' button
	And Click on 'OK' button
	
	Examples:
	|name   |address                          |
	|Billing|89 Main Street Billings, MT 59101|	
	
	Scenario: Set 'Payment Gateways' details 
	And Click on 'Account Settings' Side-Bar
	Then Select 'Payment Gateways' Side-Bar Menu options
	And Verify "Payment Gateways" panel header Title text
	And 'In Person & Online' payment method
	
	Scenario: Add 'PayPal' Account
	And Click on 'Log In with PayPal' button
	And Verify 'Log in with PayPal' header text appears
	Then login with 'PayPal' Account
	And 'In Person & Online' payment method
	And Verify 'Your PayPal account is connected' String Message
	
#	Scenario: Add 'Stripe' Account
#	And Click on 'Connect with Stripe' button
#	And Verify 'Stripe' header text appears
#	And Click on Already have a Stripe account? 'Sign In' button
#	And Verify 'Stripe' header text appears
#	Then login with 'Stripe' Account
	
	Scenario: Quite Browser
	And close the broswer
	
	
	
