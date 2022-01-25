# CSCI_1175_IndustryProjects_Project

This is the repository for the CSCI 1175 project and all of its files including the project itself, the JUnit4 test of the project classes, and the JavaDoc of the project.

## Synopsis
This project is called HoursAndFinances.java. It allows a user to input up to 15 items in any given section (i.e. income, expenses, and hours calculator). This will take the information given it and will total the numbers up and create a textfile to print out all of the totals. Hours will be printed in HourPlanner.txt and Financials will be printed in FinancialTracker.txt.

## My Motivation Behind this Project
I wanted to build something that I would've used all of the time while I was a student. As a student enrolled at SUU in 2018-2020, I would have loved to have this information at hand instead of trying to make excell sheets and spending hours or even days figuring all of this stuff out. This Program tries to alliviate that by doing most of the hard work for the user by calculating the totals for them. It would have saved me hours of time if I had access to this prior to coming to Stech.

## How to Run
To run this program, click on the HoursAndFinances.java file and using an IDE capable of using JavaFX, run the program to use it. The other file is a test case of the actual program and is not necessary to run the main program.

## Code Example
```
for (int i = 0; i < 16; i++) {
  nameTextArrayHours[i] = new TextField();
  timeTextArray[i] = new TextField();
  nameTextArrayHours[i].setMaxWidth(200);
  timeTextArray[i].setMaxWidth(100);
  nameTextArrayHours[i].setPromptText("String");
  timeTextArray[i].setPromptText("Double #");
}
for (int i = 0; i < 16; i++) {
  nameTextArrayIncome[i] = new TextField();
  nameTextArrayIncome[i].setMaxWidth(200);
  nameTextArrayIncome[i].setPromptText("Name");

  incomeTextFieldArray[i] = new TextField();
  incomeTextFieldArray[i].setMaxWidth(100);
  incomeTextFieldArray[i].setPromptText("Total Monthly");
  
  nameTextArrayExpenses[i] = new TextField();
  nameTextArrayExpenses[i].setMaxWidth(200);
  nameTextArrayExpenses[i].setPromptText("Name");
  
  financesTextArray[i] = new TextField();
  financesTextArray[i].setMaxWidth(100);
  financesTextArray[i].setPromptText("Cost Monthly");
  
  financesTextArray2[i] = new TextField();
  financesTextArray2[i].setMaxWidth(100);
  financesTextArray2[i].setPromptText("Cost Monthly");
  
  financesTextArray3[i] = new TextField();
  financesTextArray3[i].setMaxWidth(100);
  financesTextArray3[i].setPromptText("Cost Monthly");
  
  financesTextArray4[i] = new TextField();
  financesTextArray4[i].setMaxWidth(100);
  financesTextArray4[i].setPromptText("Cost Monthly");
  
  financesTextArray5[i] = new TextField();
  financesTextArray5[i].setMaxWidth(100);
  financesTextArray5[i].setPromptText("Cost Monthly");
}
```
These two loops allowed me to initialize the TextFields prior to the methods that used them. This allows for the Panes, and TextFields, to keep all of the information that the user priviously inputted into the fields if the user decides to switch between calculators in the program before finishing either of them.

## Test
If running the JUnit 4 test is desired, the files needed are the HoursAndFinances.java and the HoursAndFinancesTest.java. The IDE needs to be capable of running a JUnit 4 test case as well. These are the only necessary files and all of the others are for the JavaDoc or the HoursAndFinances.java output.


## Contributors
Contributions made by Jason Adams and Rich Mallek to help navagate around bugs in the program or any other issues that came with the code.

Some helpful links concerning finances and daily time managment to go along with the HoursAndFinances.java file are listed below.

Financial advice for students: https://www.greenamerica.org/green-economy-work/9-smart-money-tips-students-starting-college

Time management tips for all student: https://gradepowerlearning.com/10-time-management-tips-students/

Time management tips for online students: https://www.northeastern.edu/graduate/blog/time-management-tips-online-students/

Financial planning tips for small business owners: https://www.netsuite.com/portal/resource/articles/financial-management/small-business-financial-planning.shtml

Time management tips for small business owners: https://www.moo.com/blog/business-tips/time-management-tips-for-small-business-owners

Each of these links will help anyone, but they are more specifically aimed towards students or small business owners. If people are struggling with finances, it may be a good idea to find a financial advisor to help them with issues surrounding money habits. Do not take this information as professional help as I do not have any certifications surrounding financial help, but these articles may give a few ideas here and there. The articles surrounding time management are meant to help give ideas to manage time in a more efficient manner rather than just reacting to every situation that comes up, you may try to plan ahead for those moments.
