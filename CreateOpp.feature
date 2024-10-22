Feature: Create opportunity in Salesforce Application

Scenario Outline: Check the Login and opportunity functionality
Given Launch the browser and load the URL
When Enter the username as 'dilip@testleaf.com'
And Enter the password as 'leaf@2024'
And Click the login button
And Click on the toggle menu button in the left corner
And Click on View All and select Sales from the App Launcher.
And Click on the Opportunity tab.
And Click on the New button.
When Enter the Opportunity name as <opportunityName>
And Enter Amount as <amount>
And Choose the close date as Today.
And Select Stage as Need Analysis
And Click on the Save button
Then verify the Opportunity Name

Examples:
|opportunityName|amount|
|'vimalraj'|'70000'|
|'vimal'|'60000'|