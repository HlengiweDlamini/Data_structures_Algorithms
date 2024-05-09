package lab01;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    private ArrayList<String> todoList;

    public TodoList() {
        todoList = new ArrayList<>();
    }

    //ADD ITEMS TO LIST
    public void addTodo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter To-do: ");
        String todo = scanner.nextLine();
        todoList.add(todo);
        System.out.println("To-do item has been added");
    }

    //VIEW ITEMS IN LIST
    public void viewTodoList() {
        if (todoList.isEmpty()) {
            System.out.println("To-do List is empty");
        } else {
            System.out.println("To-do List: ");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i + 1) + ". " + todoList.get(i));
            }
        }
    }

    //DELETE ITEMS IN LIST
    public void deleteTodo() {
        Scanner scanner = new Scanner(System.in);
        if (todoList.isEmpty()) {
            System.out.println("To-do List is empty");
        } else {
            System.out.print("Enter index of To-do to delete: ");
            int indexToDelete = scanner.nextInt();
            if (indexToDelete >= 1 && indexToDelete <= todoList.size()) {
                todoList.set(indexToDelete - 1, "");
                System.out.println("To-do item has been deleted");
            } else {
                System.out.println("Invalid index");
            }
        }
    }
    public void exitTodoList() {
        System.out.println("Exiting application...");
        System.exit(0);
    }

    public static void main(String[] args) {
        TodoList todoApp = new TodoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n-------------TO-DO LIST MENU-------------");
            System.out.println("1. Add item");
            System.out.println("2. View To-do List");
            System.out.println("3. Delete item");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    todoApp.addTodo();
                    break;
                case 2:
                    todoApp.viewTodoList();
                    break;
                case 3:
                    todoApp.deleteTodo();
                    break;
                case 4:
                    todoApp.exitTodoList();
                    break;
                default:
                    System.out.println("Invalid choice, please enter a valid option.");
            }
        }
    }
}

