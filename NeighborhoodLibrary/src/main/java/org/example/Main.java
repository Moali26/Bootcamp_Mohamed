package org.example;

import java.util.Scanner;

//This template is to help you know where certain code should live
//This is to help you along if you're stuck
public class Main {
    public static void main(String[] args) {
        //You will only need ONE scanner
        Scanner scanner = new Scanner(System.in);

        // Create 20 Book objects manually in an array
        //Or have ChatGPT help you
        Book[] books = new Book[20];

        books[0] = new Book(1, "9780743273565", "The Great Gatsby");
        books[1] = new Book(2, "9780061120084", "To Kill a Mockingbird");
        books[2] = new Book(3, "9780451524935", "1984");
        books[3] = new Book(4, "9780547928227", "The Hobbit");
        books[4] = new Book(5, "9780316769488", "The Catcher in the Rye");
        books[5] = new Book(6, "9780141439518", "Pride and Prejudice");
        books[6] = new Book(7, "9780062315007", "The Alchemist");
        books[7] = new Book(8, "9780439023481", "The Hunger Games");
        books[8] = new Book(9, "9781451673319", "Fahrenheit 451");
        books[9] = new Book(10, "9780544336261", "The Giver");
        books[10] = new Book(11, "9780451526342", "Animal Farm");
        books[11] = new Book(12, "9780142407332", "The Outsiders");
        books[12] = new Book(13, "9780441172719", "Dune");
        books[13] = new Book(14, "9780375842207", "The Book Thief");
        books[14] = new Book(15, "9780307387899", "The Road");
        books[15] = new Book(16, "9781594631931", "The Kite Runner");
        books[16] = new Book(17, "9780156027328", "Life of Pi");
        books[17] = new Book(18, "9780553418026", "The Martian");
        books[18] = new Book(19, "9780307743657", "The Shining");
        books[19] = new Book(20, "9780307474278", "The Da Vinci Code");

        //This while loop runs forever
        //That means the program will run until we tell it to stop.
        while (true) {
            //Show a menu to the user
            //Use the scanner to take in the user input
            //For example
            System.out.println("=== BOOK STORE HOME SCREEN ===");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int userInput = scanner.nextInt();
            if (userInput == 1) {
                for (int i = 0; i < books.length; i++) {
                    if (!books[i].isCheckedOut()) {
                        System.out.println("ID: " + books[i].getId());
                        System.out.println("ISBN: " + books[i].getIsbn());
                        System.out.println("Title: " + books[i].getTitle());


                    }
                }
                System.out.print("Enter book ID (0 to go back): ");
                int bookId = scanner.nextInt();

                if (bookId == 0) {
                    continue;
                }
                for (int i = 0; i < books.length; i++) {
                    if (books[i].getId() == bookId) {

                        if (!books[i].isCheckedOut()) {
                            scanner.nextLine();
                            System.out.println("Enter your name");
                            String name = scanner.nextLine();

                            books[i].checkOut(name);

                        } else {
                            System.out.println("Sorry, this book is already checked out");
                        }


                    }
                }

            }else if (userInput == 2) {
                    for (int i = 0; i < books.length; i++) {
                        if (books[i].isCheckedOut()) {
                            System.out.println("ID: " + books[i].getId());
                            System.out.println("ISBN: " + books[i].getIsbn());
                            System.out.println("Title: " + books[i].getTitle());
                            System.out.println("Checked out to: " + books[i].getCheckOutTo());
                            System.out.println("--------------------");
                        }
                    }
                    System.out.println("C- Check In a Book");
                    System.out.println("x - Return to Home Screen");

                    String choice = scanner.next();

                    if (choice.equalsIgnoreCase("C")) {
                        System.out.println("Enter the book ID to check in:");
                        int returnId = scanner.nextInt();

                        for (int i = 0; i < books.length; i++) {
                            if (books[i].getId() == returnId && books[i].isCheckedOut()) {
                                books[i].checkIn();
                                System.out.println("Book successfully returned");
                                break;
                            }
                        }
                    } else if (choice.equalsIgnoreCase("X")) {
                        continue;
                    }
                }
                 else if (userInput == 3) {
                    System.out.println("Thank you for using the Neighborhood Libary");
                    break;

                } else {
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
                }

                //Now use if statements depending on what the person typed
                //How many possibilities are there? Write your if statement structure first

                //Loop through your array of books and use if statements
                //Do we show all books? Only checked-in books?

                //How do we exit the program?
                //This command kills the program at whatever point its at.
                //System.exit(0);

                //break
            }
        }
    }
