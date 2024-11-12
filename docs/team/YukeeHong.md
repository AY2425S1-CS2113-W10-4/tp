# Zhai Yihong - Project Portfolio Page

## Project Overview: uNivUSaver

uNivUSaver is a CLI-based software designed to help students develop better money management habits, aiming to prevent users from running out of money before the end of the month. It is written in Java.

### Summary of Contributions

#### Code contributed
* **Code contributed**: [RepoSense link](https://nus-cs2113-ay2425s1.github.io/tp-dashboard/?search=Zhai&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2024-09-20&tabOpen=true&tabType=authorship&tabAuthor=YukeeHong&tabRepo=AY2425S1-CS2113-W10-4%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

#### Enhancements implemented
* **New Feature**: Category Management System
    * What it does: Introduces a system to create and manage expense categories, such as "Food", "Entertainment", "Transport", etc., which helps users organize their expenses more effectively. The categories can be added, deleted, and customized by the user.
    * Justification: This feature enhances the usability of the application by allowing users to categorize their expenses, which helps in more efficient financial tracking and better budgeting insights. By providing default categories and allowing customization, users can maintain categories that best suit their individual needs.
    * Highlights:
        - Category Creation: Users can create new categories dynamically. The system prevents duplication by checking if a category already exists.
        - Default Categories: When the application starts without any predefined categories, default categories such as "Food" and "Utilities" are initialized for convenience.
        - Category Deletion: Users can remove categories they no longer find relevant. Deleting a category requires checking its existence to ensure smooth user interaction.
        - Interactive Category Addition: Allows users to add categories interactively, making the application more user-friendly.
* **Enhanced Test Coverage**:
*  What I did: Implemented comprehensive unit tests for multiple critical components
    * Command Tests:
        * `AddExpenseCommand`: Tests for expense creation with various parameters
        * `UpdateCategoryCommand`: Tests for category modification scenarios
        * `KeywordsSearchCommand`: Tests for search functionality with different keywords
        * `DeleteTransactionCommand`: Tests for transaction deletion edge cases
        * `AddCategoryCommand`: Tests for category creation and validation
    * Utility Tests:
        * `LocalDateTimeAdapter`: Tests for date-time parsing and formatting

* Justification:
    * Ensured reliability of core application commands
    * Validated proper handling of edge cases and error conditions
    * Protected against regression bugs in critical functionality

* Highlights:
    * Covered both valid and invalid input scenarios
    * Implemented boundary value testing
    * Ensured proper error handling and messages and verified proper state updates after command execution

* Key Test Scenarios:
    * Invalid input validation
    * Null handling
    * Edge cases (empty strings, boundary values)
    * Error conditions
    * Command execution results
#### Documentation
* **User Guide**:
    * Added documentation for the features in v1.0
    * Fixed errors of user guide after v2.0
  
* **Developer Guide**:
    * Added implementation details of the Category class.
    * Fixed bugs for the sequence diagrams

#### Contributions to Team-based Tasks
* Participated in weekly team meetings
* Helped maintain project documentation
* Contributed to user testing

#### Community
* **Review/Mentoring Contributions**:

* **Contributions Beyond the Project Team**:
