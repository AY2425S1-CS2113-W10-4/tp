# uNivUSaver User Guide
## Table of Contents
1. [Introduction](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#introduction)
2. [Quick Start](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#quick-start)
3. [Features](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#features)
   - [View command list: `help`](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#view-command-list-help)
   - [Adding](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#adding)
     - [Add an expense: `add-expense`](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#add-an-expense-add-expense)
     - [Add an income: `add-income`](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#add-an-income-add-income)
     - [Add a category: `add-category`](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#add-a-category-add-category)
     - [Add a budget: `add-budget`](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#add-a-budget-add-budget)
   - [Deleting](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#deleting)
     - [Delete an expense/income: `delete-transaction`](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#delete-an-expenseincome-delete-transaction)
     - [Delete a category: `delete-category`](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#delete-a-category-delete-category)
   - [Updating](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#updating)
     - [Update an expense category: `categorize`](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#update-an-expense-category-categorize)
   - [Viewing list](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#viewing-list)
     - [List all categories: `view-category`](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#list-all-categories-view-category)
     - [View expenses: `view-expense`](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#view-expenses-view-expense)
     - [View income: `view-income`](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#view-income-view-income)
     - [View transaction history: `history`](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#view-transaction-history-history)
   - [View total amount in account: `view-total`](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#view-total-amount-in-account-view-total)
   - [Searching: `search`](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#searching-search)
   - [Tracking: `track`](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#tracking-track)
   - [Leave the app: `bye`](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#leave-the-app-bye)
5. [Command Summary](https://ay2425s1-cs2113-w10-4.github.io/tp/UserGuide.html#command-summary)

---
## Introduction
uNivUSaver is a CLI-based software that helps students to develop a better habit of managing money, which will help you avoid using up your money before the end of month

## Quick Start
1. Ensure that you have Java 17 or above installed.
2. Download the latest version of `uNivUSaver` from [here](https://github.com/AY2425S1-CS2113-W10-4/tp/releases).
3. Copy the file to the folder you want the program to stay in, make sure the data files `(*.json)` is in the same folder with the `uNivUSaver.jar` file.
4. Open a command terminal, run the following:
   ```
   cd Path/to/directory # Change directory into the folder you put the jar file in
   java -jar uNivUSaver.jar # Start the program.
   ```
5. The data files will be read automatically
6. Type `help` to view the command list and syntax.

## Features
> **&#9432;** **NOTES ON THE COMMAND FORMAT:**
>- Words in UPPER_CASE are the parameters to be supplied by the user.
>- Parameters in [] are optional (e.g. `[f/ DATE]`)
>- The keywords must be followed by **at least one space** before adding the associated parameter (e.g. `d/ DATE`)
>- Parameters can be in any order, except for the parameters without keyword (e.g. `DESCRIPTION`)
>- Extraneous parameters for commands that do not take in parameters (such as help, bye) will be ignored.
>- Empty commands will be ignored.
>- The date and time format for input is `yyyy-MM-dd [hhMM]`. Time is optional, the system will automatically take '2359' or '0000' for time.
>- The month format for input is `yyyy-MM-dd`
>- Description and category names cannot exceed 40 characters.
>- Please enter one command at a time


> **&#9432;** **NOTES ON THE TRANSACTION LIST:**
>- The transaction list will be sorted in time order.
>- Any updating action (e.g. deleting, re-categorizing...) will be performed on the whole transaction list, not the sole expense/ income list
>- The upper limit for each transaction is 1000000000 (1 billion)

> **&#9432;** **NOTES ON SAVE AND LOAD FUNCTIONALITY (FOR ADVANCED USERS)**
> - The Save & Load Functionality is implemented by serialising TransactionList, CategoryList and budgets and save as JSON files in the local storage
> - It is not advisable to edit JSON files directly as a corrupted JSON file may lead to unwanted effects
> - JSON Error Handling:
>   - Corruption within objects (eg. invalid key or value, incorrect syntax): The programme will skip these objects while loading the JSON file
>   - Corruption of JSON file structure: The content will be cleared and reinitialised, previously stored objects will be lost
> - [JSON Guide](JSON)
### View command list: `help`
- View all available commands in the application.
- **Format:** `help`

### Adding
#### Add an expense: `add-expense`
- Add an amount of expense into the history.
- **Format:** `add-expense [DESCRIPTION] a/ AMOUNT [d/ DATE] [c/ CATEGORY]`
- **Tips:**
  - If the category is not entered, the program will prompt you to enter a category or to leave it empty
  - You may either fill in a category already in the category list or create a new category if it is not present in the list
  - If the date is not entered, the system will take the current day.
- **Examples:**
  ```
  add-expense a/ 17 d/ 2024-07-09 c/ FnB
  add-expense Amusement park a/ 52 d/ 2024-08-09
  add-expense ChiCha San Chen a/ 6 d/ 2024-09-09 c/ FnB
  ```


#### Add an income: `add-income`
- Add an amount of income into the history.
- **Format:** `add-income [DESCRIPTION] a/ AMOUNT [d/ DATE]`
- **Tip:**
  - If the date is not entered, the system will take the current day.
- **Examples:**
  ```
  add-income Monthly allowance a/ 300 d/ 2024-09-19 1100
  add-income a/ 52 d/ 2024-09-19 1100
  ```

  
#### Add a category: `add-category`
- Add a category into the category list.
- **Format:** `add-category CATEGORY_NAME`
- **Tip:**
  - Category name must be unique.
- **Examples:**
  ```
  add-category FnB
  add-category Laundry
  ```

#### Add a budget: `add-budget`
- Sets a monthly budget to track spending against.
- **Format:** `add-budget a/ AMOUNT m/ MONTH`
- **Tips:**
  - The month should be specified in the format `yyyy-MM` (e.g., `2024-11`).
  - The amount represents the budget limit for that month.
  - Budget can only be set for current or future months
- **Examples:**
  ```
  add-budget a/ 1000 m/ 2024-11 
  add-budget a/ 200 m/ 2025-02
  ```

---
### Deleting
#### Delete an expense/income: `delete-transaction`
- Delete an expense or income from the history.
- **Format:** `delete-transaction i/ INDEX`
- **Example:**
  ```
  delete-transaction i/ 7
  ```

#### Delete a category: `delete-category`
- Delete a category from the category list.
- **Format:** `delete-category CATEGORY_NAME`
- **Example:**
  ```
  delete-category FnB
  ```
  
---
### Updating

#### Update an expense category: `categorize`
- Update the category field of an expense (the category must be in the transaction list).
- **Format:** `categorize i/ INDEX c/ CATEGORY`
- **Example:**
  ```
  categorize i/ 6 c/ Food
  ```
  
---
### Viewing list

#### List all categories: `view-category`
- View the category list.
- **Format:** `view-category`

#### View expenses: `view-expense`
- View the expenses with optional start/end time and category. If left blank, full history will be shown.
- **Format:** `view-expense [c/ CATEGORY] [f/ DATE] [t/ DATE]`
- **Examples:**
  ```
  view-expense c/ food
  view-expense f/ 2024-09-16 t/ 2024-09-19
  ```

#### View income: `view-income`
- View the income in an optional start and end time. If start and end time are left blank, full history will be shown.
- **Format:** `view-income [f/ DATE] [t/ DATE]`
- **Example:**
  ```
  view-income f/ 2024-09-16 t/ 2024-09-19
  view-income
  ```

#### View transaction history: `history`
- View transaction history with an optional start and end time. If left blank, full history will be shown.
- **Format:** `history [f/ DATE] [t/ DATE]`
- **Examples:**
  ```
  history f/ 2024-09-16 t/ 2024-09-19
  history
  ```

---
### View total amount in account: `view-total`
- View the total amount of money currently in the account.
- **Format:** `view-total`

### Searching: `search`
- Search for transaction or transactions in the transactionList using one or multiple keywords. The command counts exact match, with case ignore.
- **Format:** `search k/ [keyword_1] [keyword_2] ... [keyword_n]`
- **Example:**
  ```
  search k/ school
  search k/ school fee ABC
  ```
  
### Tracking: `track`
- Track the progress towards budget for a certain month to make sure you are within the budget
- **Format:** `track m/ MONTH`
- **Tips:**
  - The month should be specified in the format `yyyy-MM` (e.g., `2024-11`).
  - Tracking of progress is only available for current or past months.
- **Example:**
  ```
  track m/ 2024-11
  track m/ 2020-10
  ```

### Leave the app: `bye`
- Peacefully leave the application
- **Format:** `bye`

## JSON Editing ##
- JSON basic syntax:
    - data is in key/value pairs ```"key":"value"```
    - Data is separated by commas 
    - Curly braces hold objects ```{"key":"value"}```
    - Square brackets hold arrays ```[{"key1":"value1"},{"key2":"value2"}]```
- TransactionList and CategoryList in the programme are stored as Array of Transaction object and Category object respectively, Budgets are stored as key/value pairs
- TransactionList Syntax:
```
[
    {
      "type": "expense",
      "category": {
         "name": ""
       },
      "amount": 52.0,
      "description": "Amusement park",
      "dateTimeString": "2024-08-09 0000"
    },
    {
    "type": "income",
    "amount": 300.0,
    "description": "Monthly allowance",
    "dateTimeString": "2024-09-19 1100"
    }
]
```
- CategoryList Syntax:
```
[
  {
    "name": "Food"
  },
  {
    "name": "Transport"
  },
  {
    "name": "Entertainment"
  },
  {
    "name": "FnB"
  }
]
```
- Budgets Syntax:
```
{
  "2024-11": 100.0,
  "2024-12": 200.0
}
```
## Command Summary

### Command List

| **Command Word**     |                          **Syntax**                           |                     **Example**                     |
|----------------------|:-------------------------------------------------------------:|:---------------------------------------------------:|
| `help`               |                            `help`                             |                       `help`                        |
| `add-expense`        | `add-expense [DESCRIPTION] a/ AMOUNT [d/ DATE] [c/ CATEGORY]` |    `add-expense Food a/ 17 d/ 2024-07-09 c/ FnB`    |
| `add-income`         |        `add-income [DESCRIPTION] a/ AMOUNT [d/ DATE]`         | `add-income Monthly allowance a/ 300 d/ 2024-09-19` |
| `add-category`       |                    `add-category CATEGORY_NAME`               |                `add-category FnB`                   |
| `add-budget`         |                `add-budget a/ AMOUNT m/ MONTH`                |           `add-budget a/ 1000 m/ 2024-12`           |
| `delete-transaction` |                 `delete-transaction i/ INDEX`                 |              `delete-transaction i/ 7`              |
| `delete-category`    |             `delete-category CATEGORY_NAME`                   |               `delete-category FnB`                 |
| `categorize`         |              `categorize i/ INDEX c/ CATEGORY`                |              `categorize i/ 6 c/ Food`              |
| `view-category`      |                        `view-category`                        |                   `view-category`                   |
| `view-expense`       |       `view-expense [c/ CATEGORY] [f/ DATE] [t/ DATE]`        |   `view-expense c/ food f/ 2024-09-16 t/ 2024-09-19`|
| `view-income`        |               `view-income [f/ DATE] [t/ DATE]`               |      `view-income f/ 2024-09-16 t/ 2024-09-19`      |
| `history`            |                 `history [f/ DATE] [t/ DATE]`                 |        `history f/ 2024-09-16 t/ 2024-09-19`        |
| `view-total`         |                         `view-total`                          |                    `view-total`                     |
| `search`             |     `search k/ [keyword_1] [keyword_2] ... [keyword_n]`       |                 `search k/ school fee ABC`          |
| `track`              |                       `track m/ MONTH`                        |                 `track m/ 2024-11`                  |
| `bye`                |                            `bye`                              |                       `bye`                         |
           

