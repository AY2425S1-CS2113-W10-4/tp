/*
package seedu.functions;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CategoryList categoryManager = new CategoryList();
        TransactionList transactionList = new TransactionList();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Category");
            System.out.println("2. Delete Category");
            System.out.println("3. List Categories");
            System.out.println("4. Add Transaction");
            System.out.println("5. Delete Transaction");
            System.out.println("6. List Transactions");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
            case 1:
                System.out.print("Enter category name to add: ");
                String categoryName = scanner.nextLine();
                categoryManager.addCategory(categoryName);
                break;
            case 2:
                System.out.print("Enter category name to delete: ");
                String deleteCategoryName = scanner.nextLine();
                categoryManager.deleteCategory(deleteCategoryName);
                break;
            case 3:
                categoryManager.listCategories();
                break;
            case 4:
                System.out.print("Enter transaction amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter transaction description: ");
                String description = scanner.nextLine();
                System.out.print("Enter transaction date: ");
                String date = scanner.nextLine();
                categoryManager.listCategories();
                System.out.print("Enter category number: ");
                int categoryIndex = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (categoryIndex > 0 && categoryIndex <= categoryManager.getCategories().size()) {
                    Category category = categoryManager.getCategories().get(categoryIndex - 1);
                    Transaction transaction = new Transaction(amount, description, date, category);
                    transactionList.addTransaction(transaction);
                } else {
                    System.out.println("Invalid category index!");
                }
                break;
            case 5:
                System.out.print("Enter transaction index to delete: ");
                int transactionIndex = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                transactionList.deleteTransaction(transactionIndex - 1);
                break;
            case 6:
                transactionList.listTransactions();
                break;
            case 7:
                System.out.println("Exiting...");
                scanner.close();
                return;
            default:
                System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}*/
