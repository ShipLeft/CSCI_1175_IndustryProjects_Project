package com.example.csci_1175_project1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import javafx.scene.text.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DecimalFormat;

/**
 * <h1>HoursAndFinances</h1>
 *
 * <p>This is my project for CSCI 1175. This program is an hours calculator (to see how
 * many hours a user is using during the week) and a financial calculator (to calculate
 * expenses, income, and totals left over after income and expenses for the month). This
 * class makes the GUI and states the functionality of all buttons, textfields, and menu Items.</p>
 *
 * <p>Created 01/20/2022</p>
 *
 * @author Rhett Boatright
 */
public class HoursAndFinances extends Application {

    //JavaFx items for the GUI
    private Pane pane = new Pane();
    private VBox mainVBox = new VBox();
    private VBox vBoxHours = new VBox();
    private VBox vBoxFinances = new VBox();
    private MenuItem hoursItem = new MenuItem("Time Scheduler");
    private MenuItem financesItem = new MenuItem("Finances");
    private MenuItem exitItem = new MenuItem("Exit");
    private GridPane gridPaneHours = new GridPane();
    private GridPane gridPaneFinances = new GridPane();
    private BorderPane borderPaneHours = new BorderPane();
    private BorderPane borderPaneFinances = new BorderPane();
    Label max = new Label("Maximum lines is 16");
    MenuBar selection = new MenuBar();


    //TextFields for both calculators
    private TextField[] nameTextArrayHours = new TextField[16];
    private TextField[] timeTextArray = new TextField[16];
    private TextField[] nameTextArrayIncome = new TextField[16];
    private TextField[] incomeTextFieldArray = new TextField[16];
    private TextField[] nameTextArrayExpenses = new TextField[16];
    private TextField[] financesTextArray = new TextField[16];
    private TextField[] financesTextArray2 = new TextField[16];
    private TextField[] financesTextArray3 = new TextField[16];
    private TextField[] financesTextArray4 = new TextField[16];
    private TextField[] financesTextArray5 = new TextField[16];

    //Objects for total amounts
    private HoursObject hoursObject = new HoursObject();
    private Finances financesObject = new Finances();

    //ints for checking the times to run and the week or month that is being worked on
    private int timesHours = 1, timesIncome = 1, timesExpenses = 1;
    private int week = 0, month = 0;

    //Variables for hours method
    private double totalHoursSaved = 0;
    private String[] nameArrayHours = new String[16];
    private String[] textTime = new String[16];
    private double[] timeArray = new double[16];
    private double totalTimeUsed = 0;

    //Variables for finances method
    private double totalMoneyLeft = 0;
    private double totalMoneySpent = 0;
    private double totalMoneyGained = 0;
    private String[] nameArrayIncome = new String[16];
    private String[] incomeTextArray = new String[16];
    private double[] incomeArray = new double[16];
    private String[] nameArrayExpense = new String[16];
    private String[] expenseTextArray = new String[16];
    private double[] expenseArray = new double[16];
    private String[] expense2TextArray = new String[16];
    private double[] expense2Array = new double[16];
    private String[] expense3TextArray = new String[16];
    private double[] expense3Array = new double[16];
    private String[] expense4TextArray = new String[16];
    private double[] expense4Array = new double[16];
    private String[] expense5TextArray = new String[16];
    private double[] expense5Array = new double[16];

    //Buttons for hours
    Button addHours = new Button("Add Line");
    Button minusHours = new Button("Subtract Line");
    Button btAgain = new Button("Next Week");

    //Buttons for finances
    Button addIncome = new Button("Add Income");
    Button minusIncome = new Button("Delete Income");
    Button addExpense = new Button("Add Expense");
    Button minusExpense = new Button("Delete Expense");
    Button again = new Button("New Calculator");

    //Alert for incorrect input from the user
    Alert incorrectField = new Alert(Alert.AlertType.ERROR);

    //DecimalFormat for $ amounts
    DecimalFormat df = new DecimalFormat("#.00");

    @Override
    /**
     * This method will create the Menu and its items, the scene, and the stage. It will
     * also tell what the menu items will do when selected.
     */
    public void start(Stage primaryStage) throws Exception {
        selection.prefWidthProperty().bind(primaryStage.widthProperty());
        mainVBox.getChildren().add(selection);
        pane.getChildren().add(mainVBox);
        Menu menuSelection = new Menu("Options");
        selection.getMenus().add(menuSelection);
        menuSelection.getItems().addAll(hoursItem, financesItem, exitItem);

        //Initialize TextFields for hours
        for (int i = 0; i < 16; i++) {
            nameTextArrayHours[i] = new TextField();
            timeTextArray[i] = new TextField();
            nameTextArrayHours[i].setMaxWidth(200);
            timeTextArray[i].setMaxWidth(100);
            nameTextArrayHours[i].setPromptText("String");
            timeTextArray[i].setPromptText("Double #");
        }

        //Initialize TextFields for finances
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


        Scene scene = new Scene(pane, 1200, 600);
        primaryStage.setTitle("Hours and Finances");
        primaryStage.setScene(scene);
        primaryStage.show();

        hoursItem.setOnAction(e -> { //When the hours menu is selected
            hours();

        });

        financesItem.setOnAction(e -> { //When the finances menu is selected
            finances();

        });

        exitItem.setOnAction(e -> { //When exit menu is selected
            System.exit(0); //Exit with code 0
        });


    }

    /**
     * This method is not needed unless the IDE requires a launch.
     *
     * @param args (String; placeholder for the main method)
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This method creates the GUI for the hours calculator. It sets the buttons and
     * tells what the buttons will do. It will call upon timeGridPane and totalSaved
     * to create textFields and correctly calculate the user's weekly hour usage.
     */
    public void hours() {
        //Clear all Panes and VBoxes
        mainVBox.getChildren().clear();
        mainVBox.getChildren().add(selection);
        vBoxHours.getChildren().clear();
        gridPaneHours.getChildren().clear();
        borderPaneHours.getChildren().clear();
        vBoxHours.getChildren().add(new Label("Hours Calculator"));

        timeGridPane(timesHours); //Show GridPane

        //Setting the alert name and message.
        incorrectField.setTitle("Incorrect Input");
        incorrectField.setContentText("Please make sure that the fields are all correctly entered." +
                "If a number is needed, enter a number.");


        HBox buttonPlacement = new HBox(); //Hbox for calculate button

        //Add save button
        Button save = new Button("Save");
        buttonPlacement.getChildren().addAll(addHours, minusHours, save);

        gridPaneHours.setVgap(5);
        gridPaneHours.setHgap(5); //Spacing between gridPane options

        //Set the vBoxHours into the mainVBox with the gridPane, HBox, and the borderPane
        borderPaneHours.setBottom(buttonPlacement);
        borderPaneHours.setCenter(gridPaneHours);
        vBoxHours.getChildren().add(borderPaneHours);
        mainVBox.getChildren().add(vBoxHours);

        addHours.setOnAction(e -> { //When addHours is selected
            timeGridPane(++timesHours); //Call upon timeGridPane
        });


        minusHours.setOnAction(e -> { //When minusHours is selected
            timeGridPane(--timesHours); //Call upon timeGridPane
        });


        save.setOnAction(e -> { //When save is selected
            try {
                //Calculate hour usage
                totalSaved(timesHours);


                gridPaneHours.getChildren().clear();//Clear the gridPane


                VBox vBoxTotalHours = new VBox(); //New VBox to set totals in
                Text totalActivityTime = new Text //Text for totals
                        (50, 50, ("Week: " + week + "\n" + hoursObject.totalString() + "\n"));
                totalActivityTime.setFont //Font for totals
                        (Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20));
                vBoxTotalHours.getChildren().add(totalActivityTime); //Add totals to the VBox

                //For loop to print out the items entered by the user
                for (int i = 0; i < timesHours - 1; i++) {
                    Text activityTime = new Text //Text for the name and time spent
                            (50, 50, (nameArrayHours[i] + "   Time spent: " + timeArray[i] + " hours\n"));
                    activityTime.setFont
                            (Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));
                    vBoxTotalHours.getChildren().add(activityTime); //Add the text into the VBox
                }

                borderPaneHours.getChildren().clear(); //Clear the BorderPane
                borderPaneHours.setCenter(vBoxTotalHours); //Set the VBox in the center
                borderPaneHours.setBottom(btAgain); //Add again button
            } catch (NumberFormatException ex) {
                //If input is not correct, this will catch the error
                System.out.println("Please enter numbers in all 'Time in Hours' TextFields");
                incorrectField.showAndWait();
            }
        });

        btAgain.setOnAction(e -> { //When btAgain is selected
            borderPaneHours.getChildren().clear(); //Clear the borderPane
            timesHours = 1; //Set the times to zero
            totalTimeUsed = 0; //Set the total to zero

            //For loop to re-initialize the TextFields
            for (int i = 0; i < 16; i++) {
                nameTextArrayHours[i] = new TextField();
                timeTextArray[i] = new TextField();
                nameTextArrayHours[i].setMaxWidth(200);
                timeTextArray[i].setMaxWidth(100);
                nameTextArrayHours[i].setPromptText("String");
                timeTextArray[i].setPromptText("Double #");
            }

            timeGridPane(timesHours); //Show GridPane again
            //Reset for hours calculator
            borderPaneHours.setBottom(buttonPlacement);
            borderPaneHours.setCenter(gridPaneHours);

        });
    }

    /**
     * This method creates the gridPane for the hours calculator. It subtracts or
     * adds rows depending on what the user clicks on.
     *
     * @param times (int; times the for loop will run, from the hours method)
     */
    public void timeGridPane(int times) {
        System.out.println(times);
        System.out.println(timesHours);
        //This will run if the times is less than or equal to 16
        if (times <= 16) {
            gridPaneHours.getChildren().clear(); //Clear the pane as to not get overlapping

            //For loop to add/subtract rows from the gridPane
            for (int i = 0; i < times; i++) {
                vBoxHours.getChildren().remove(max);
                gridPaneHours.add(new Label("Item " + (i + 1)), 0, i);
                gridPaneHours.add(nameTextArrayHours[i], 1, i);

                gridPaneHours.add(new Label("Time in hours: "), 2, i);
                gridPaneHours.add(timeTextArray[i], 3, i);
            }
        }
        else if (times > 16) {
            vBoxHours.getChildren().remove(max);
            vBoxHours.getChildren().add(max); //Show the max line limit if reached
            timesHours = 16;
        }
    }

    /**
     * This method will use HoursObject to total amounts up and will print them out
     * to a separate text file using PrintStream to accomplish that.
     *
     * @param times (int; times that the for loop will run, from the hours method)
     */
    public void totalSaved(int times) {
        //If the times - 1 is less than 16
        if (times - 1 < 16) {

            //For loop to gather data from the textFields
            for (int i = 0; i < times; i++) {
                nameArrayHours[i] = nameTextArrayHours[i].getText();
                textTime[i] = timeTextArray[i].getText();
                timeArray[i] = Double.parseDouble(textTime[i]);

                totalTimeUsed += timeArray[i]; //Total time used
            }
            week++; //Week number depending on how many times the calculator has been used
            hoursObject.setTime(totalTimeUsed); //set the total time in the object

            try (
                    PrintStream printStream = //printStream for the txt file
                            new PrintStream(new FileOutputStream("HourPlanner.txt", true))
            ) {

                //Print the Data out to the file
                printStream.println("\nWeek " + week + ": ");
                printStream.println("Hours used and the activity: ");
                for (int i = 0; i < times - 1; i++) {
                    printStream.println("\n" + nameArrayHours[i] + "     Time spent: " + timeArray[i]);
                }
                printStream.println(hoursObject.totalString());
            }
            catch (IOException ex) { //IO exception for PrintStream
                System.out.println("File cannot be found/made");
            }
        }
    }

    /**
     * This method creates the GUI for the financial calculator. It sets the buttons and
     * tells what each will do. It calls upon incomeGridPane, expensesGridPane, incomeTotal, expensesTotal,
     * and moneyLeft methods with the Finances class to create an object and return accurate totals.
     */
    public void finances() {
        //Clear all Panes and VBoxes
        mainVBox.getChildren().clear();
        mainVBox.getChildren().add(selection);
        vBoxFinances.getChildren().clear();
        gridPaneFinances.getChildren().clear();
        borderPaneFinances.getChildren().clear();
        vBoxFinances.getChildren().add(new Label("Financial Tracker: "));

        incomeGridPane(timesIncome); //Show GridPane

        HBox buttonPlacement = new HBox(); //Hbox for buttons
        //Set alert title and message
        incorrectField.setTitle("Incorrect Input");
        incorrectField.setContentText("Please make sure that the fields are all correctly entered." +
                "If a number is needed, enter a number.");

        //Buttons for finances
        Button calculateFinances = new Button("Calculate"); //Button for calculating finances
        Button nextExpense = new Button("Expenses");


        gridPaneFinances.setVgap(5);
        gridPaneFinances.setHgap(5); //Set the gap between gridPane items

        buttonPlacement.getChildren().addAll(addIncome, minusIncome, nextExpense); //Add the buttons to the HBox
        //Place HBox and GridPane into the borderPane
        borderPaneFinances.setBottom(buttonPlacement);
        borderPaneFinances.setCenter(gridPaneFinances);

        //add borderPane into the VBox
        vBoxFinances.getChildren().add(borderPaneFinances);

        //Add the Vbox into the Main Vbox
        mainVBox.getChildren().add(vBoxFinances);


        //Add all button functionality
        nextExpense.setOnAction(e -> { //When nextExpense is selected
            try {
                incomeTotal(timesIncome); //Total the income up
                gridPaneFinances.getChildren().clear();
                buttonPlacement.getChildren().removeAll(addIncome, minusIncome, nextExpense);
                buttonPlacement.getChildren().addAll(addExpense, minusExpense, calculateFinances);
                expensesGridPane(timesExpenses);
            }catch (NumberFormatException ex){
                System.err.println(ex);
                incorrectField.showAndWait(); //Ask user to check inputs
            }
        });

        addIncome.setOnAction(e -> { //When addIncome is selected
            incomeGridPane(++timesIncome); //Call upon incomeGridPane
        });
        minusIncome.setOnAction(e -> { //When minusIncome is selected
            incomeGridPane(--timesIncome); //Call upon incomeGridPane
        });

        addExpense.setOnAction(e -> {//When addExpense is selected
            expensesGridPane(++timesExpenses);//Call upon expensesGridPane
        });
        minusExpense.setOnAction(e -> {//When minusExpense is selected
            expensesGridPane(--timesExpenses);//Call upon expensesGridPane
        });

        calculateFinances.setOnAction(e ->{ //When calculateFinances is selected
            try {
                expensesTotal(timesExpenses); //Total up expenses
                moneyLeft(timesIncome, timesExpenses); //Call upon moneyLeft to print out to a file
                gridPaneFinances.getChildren().clear(); //Clear the gridPane


                VBox vBoxTotalFinances = new VBox(); //New VBox for totals
                Text totalIncome = new Text //Text for total income
                        (50, 50, ("Month: " + month + "\n" + financesObject.getString() + "\n"));
                totalIncome.setFont
                        (Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20));
                vBoxTotalFinances.getChildren().add(totalIncome); //Add to the VBox

                //For loop to print out names and the money made
                for (int i = 0; i < timesIncome - 1; i++) {
                    Text income = new Text //Text for the income
                            (50, 50,
                                    (nameArrayIncome[i] + "   Money Made: $" + df.format(incomeArray[i]) + "\n"));
                    income.setFont
                            (Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));
                    vBoxTotalFinances.getChildren().add(income); //Add to the VBox
                }

                //For loop to print out expenses and money spent
                for(int i = 0; i < timesExpenses - 1; i++){
                    double totalExpense = (expenseArray[i] + expense2Array[i]
                            + expense3Array[i] + expense4Array[i] + expense5Array[i]); //Total spent on each item
                    Text expenses = new Text //Text for the expenses
                            (nameArrayExpense[i] + "   Money Spent: $" + df.format(totalExpense) + "\n");
                    expenses.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));
                    vBoxTotalFinances.getChildren().add(expenses); //Add to the VBox
                }

                borderPaneFinances.getChildren().clear(); //Clear the borderPane

                //Set the VBox and the again button into the borderPane
                borderPaneFinances.setCenter(vBoxTotalFinances);
                borderPaneFinances.setBottom(again);
            } catch (NumberFormatException ex) {
                //If the user inputs a wrong character, this will stop them from progressing.
                System.out.println("Please enter numbers in all 'Time in Hours' TextFields");
                incorrectField.showAndWait();
            }
        });
        again.setOnAction(e->{ //When again is selected
            borderPaneFinances.getChildren().clear(); //Clear the borderPane

            //Set all times and totals to zero
            timesIncome = 1;
            timesExpenses = 1;
            totalMoneyGained = 0;
            totalMoneySpent = 0;
            totalMoneyLeft = 0;

            //For loop to re-initialize the TextFields
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

            incomeGridPane(timesIncome); //Show gridPane again
            //Remove all buttons for expenses and replace with income buttons
            buttonPlacement.getChildren().removeAll(addExpense, minusExpense, calculateFinances);
            buttonPlacement.getChildren().addAll(addIncome, minusIncome, nextExpense);

            //Re set the HBox and gridPane
            borderPaneFinances.setBottom(buttonPlacement);
            borderPaneFinances.setCenter(gridPaneFinances);
        });
    }

    /**
     * This method creates the gridPane layout for the income section.
     * @param times
     */
    public void incomeGridPane(int times) {
        //This will loop if the times is <= 16
        if (timesIncome <= 16) {
            gridPaneFinances.getChildren().clear(); //Clear gridPane to stop overlapping

            //For loop to create the layout
            for (int i = 0; i < times; i++) {
                vBoxFinances.getChildren().remove(max);
                gridPaneFinances.add(new Label("Source: " + (i + 1)), 0, i);
                gridPaneFinances.add(nameTextArrayIncome[i], 1, i);

                gridPaneFinances.add(new Label("Amount: "), 2, i);
                gridPaneFinances.add(incomeTextFieldArray[i], 3, i);
            }
        } else {
            vBoxFinances.getChildren().remove(max);
            vBoxFinances.getChildren().add(max); //Show max lines if hit
            timesIncome = 16;
        }
    }

    /**
     * This method created the gridPane layout for the expenses section.
     * @param times
     */
    public void expensesGridPane(int times) {
        //Only run if the times <= 16
        if (timesExpenses <= 16) {
            gridPaneFinances.getChildren().clear(); //Clear the gridPane for no overlapping

            //For loop to create the new layout
            for (int i = 0; i < times; i++) {
                vBoxFinances.getChildren().remove(max);
                gridPaneFinances.add(new Label("Item " + i + ":"), 0, i);
                gridPaneFinances.add(nameTextArrayExpenses[i], 1, i);

                gridPaneFinances.add(new Label("Expense 1:"), 2, i);
                gridPaneFinances.add(financesTextArray[i], 3, i);

                gridPaneFinances.add(new Label("Expense 2:"), 4, i);
                gridPaneFinances.add(financesTextArray2[i], 5, i);

                gridPaneFinances.add(new Label("Expense 3:"), 6, i);
                gridPaneFinances.add(financesTextArray3[i], 7, i);

                gridPaneFinances.add(new Label("Expense 4:"), 8, i);
                gridPaneFinances.add(financesTextArray4[i], 9, i);

                gridPaneFinances.add(new Label("Expense 5:"), 10, i);
                gridPaneFinances.add(financesTextArray5[i], 11, i);
            }
        } else {
            vBoxFinances.getChildren().remove(max);
            vBoxFinances.getChildren().add(max); //Show max lines if hit
            timesExpenses = 16;
        }


    }

    /**
     * This method totals up the income and sets it into the Finances object
     *
     * @param times (int; times the for loop will be run)
     */
    public void incomeTotal(int times){
        //Only if the times -1 < 16
        if (times - 1 < 16) {

            //For loop to gather information from the TextFields
            for (int i = 0; i < times; i++) {
                nameArrayIncome[i] = nameTextArrayIncome[i].getText();

                incomeTextArray[i] = incomeTextFieldArray[i].getText();
                incomeArray[i] = Double.parseDouble(incomeTextArray[i]);

                totalMoneyGained += incomeArray[i]; //Total money gained
            }
            financesObject.setAmountMade(totalMoneyGained); //Set the total in the object
        }
    }

    /**
     * This method totals up the expenses and sets it into the Finances object.
     *
     * @param times (int; times the for loop will be run)
     */
    public void expensesTotal(int times){
        //Only run if times -1 < 16
        if (times - 1 < 16) {

            //For loop to gather information from the TextFields
            for (int i = 0; i < times; i++) {
                nameArrayExpense[i] = nameTextArrayExpenses[i].getText();

                expenseTextArray[i] = financesTextArray[i].getText();
                expenseArray[i] = Double.parseDouble(expenseTextArray[i]);

                expense2TextArray[i] = financesTextArray2[i].getText();
                expense2Array[i] = Double.parseDouble(expense2TextArray[i]);

                expense3TextArray[i] = financesTextArray3[i].getText();
                expense3Array[i] = Double.parseDouble(expense3TextArray[i]);

                expense4TextArray[i] = financesTextArray4[i].getText();
                expense4Array[i] = Double.parseDouble(expense4TextArray[i]);

                expense5TextArray[i] = financesTextArray5[i].getText();
                expense5Array[i] = Double.parseDouble(expense5TextArray[i]);

                //Total the expenses
                totalMoneySpent +=
                        expenseArray[i] + expense2Array[i] + expense3Array[i] + expense4Array[i] + expense5Array[i];
            }
            month++; //Check the month being worked on
            financesObject.setAmountSpent(totalMoneySpent); //Set the total into the object

        }
    }

    /**
     * This method will total the money left after income and Expenses and
     * will print out the information to the Text file made by the PrintStream.
     *
     * @param timesIncome1 (int; times the income for loop will be run)
     * @param timesExpenses1 (int; times the expenses for loop will be run)
     */
    public void moneyLeft(int timesIncome1, int timesExpenses1){
        try (
                //PrintStream to write to the created file
                PrintStream printStream =
                        new PrintStream(new FileOutputStream("FinancialTracker.txt", true))
        ) {
            //Print out the amounts with money gained
            printStream.println("\n\nMonth " + month + ": ");
            printStream.println("Money gained and the source: ");
            for (int i = 0; i < timesIncome1; i++) {
                printStream.println(nameArrayIncome[i] + "     Money made: $" + df.format(incomeArray[i]));
            }

            //Print the total amount gained
            printStream.println("\nTotal income: " + financesObject.getAmountMade() +
                    "\nMoney spent and the name of expenses: ");

            //For loop to print out Expenses and total expenses for each item
            for (int i = 0; i < timesExpenses1; i++){
                double totalExpense = (expenseArray[i] + expense2Array[i]
                        + expense3Array[i] + expense4Array[i] + expense5Array[i]);
                printStream.println(nameArrayExpense[i] + "   Expense 1: $" + df.format(expenseArray[i])
                        + "   Expense 2: $" + df.format(expense2Array[i]) + "   Expense 3: $"
                        + df.format(expense3Array[i]) + "   Expense 4: $" + df.format(expense4Array[i])
                        + "   Expense 5: $" + df.format(expense5Array[i]) + "   Total: $" + df.format(totalExpense));
            }
            //Print out the total expenses of all items and money leftover
            printStream.println("\nTotal expenses: " +
                    financesObject.getAmountSpent() + "\n" + financesObject.getString());
        } catch (IOException ex) { //IO exception for PrintStream
            System.out.println("File cannot be found/made");
        }
    }
}

/**
 * <h1>HoursObject</h1>
 *
 * <p>This is the constructor for the HoursObject objects
 * this will allow the totals to be placed into it to be
 * used at a later time, and will create a total String as well.</p>
 *
 * <p>Created 01/19/2022</p>
 *
 * @author Rhett Boatright
 */
class HoursObject {
    //Variables to be used
    private double time;
    final int timeWeek = 168;

    HoursObject() {
    }

    //Getter and Setter for time used
    void setTime(double time1) {
        time = time1;
    }

    double getTime() {
        return time;
    }

    //totalString for printing out amounts
    String totalString() {
        DecimalFormat dfH = new DecimalFormat("#.0");
        return "\nTotal time used: " + dfH.format(time)
                + "\nAmount of time left in the week: " + dfH.format((timeWeek - time));
    }
}

/**
 * <h1>Finances</h1>
 *
 * <p>This is the constructor for the Finances object.
 * This will allow the totals to be place into it for later
 * use. This also creates a getString for printing out amounts</p>
 *
 * <p>Created 01/19/2022</p>
 *
 * @author Rhett Boatright
 */
class Finances {
    //Variables to be used
    private double amountMade;
    private double amountSpent;
    private DecimalFormat df = new DecimalFormat("#.00");//Dollar.Cents format

    Finances() {
    }

    //Getters and Setters
    void setAmountMade(double amountMade1) {
        amountMade = amountMade1;
    }

    String  getAmountMade() {
        return df.format(amountMade);
    }

    void setAmountSpent(double amountSpent1) {
        amountSpent = amountSpent1;
    }

    String  getAmountSpent() {
        return "$" + df.format(amountSpent);
    }

    //getString for printing out totals
    String getString(){
        return "Monthly income is: $" + df.format(amountMade)
                + "\nMonthly expenses total: $" + df.format(amountSpent)
                + "\nMoney left over after expenses: $" + df.format((amountMade - amountSpent));
    }

}
