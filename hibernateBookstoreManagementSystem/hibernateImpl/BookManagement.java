package hibernateBookstoreManagementSystem.hibernateImpl;

import hibernateBookstoreManagementSystem.HibernateImplConfig;
import hibernateBookstoreManagementSystem.entity.Book;
import hibernateBookstoreManagementSystem.validation.ValidationManagement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    private static final SessionFactory SESSION_FACTORY = HibernateImplConfig.getSessionFactory();
    private static Scanner sc = new Scanner(System.in);

    /**
     * Starts the book management system, allowing users to perform various operations.
     */
    public static void start() {
        int choirs = 0;
        while (true) {
            printManu();
            try {
                choirs = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                continue;
            }

            switch (choirs) {
                case 1:
                    insertBook();
                    break;
                case 2:
                    updateBook();
                    break;
                case 3:
                    listBooksByAuthor();
                    break;
                case 4:
                    listBooksByGenre();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }

    }

    /**
     * Prints a menu for book management options to the console.
     */
    public static void printManu() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nBooks Management System " +
                  "\n1. insert books " +
                  "\n2. update books " +
                  "\n3. search all  books by author " +
                  "\n4. search all  books by genre " +
                  "\n5. Back to Main Menu " +
                  "\nEnter your choice: ");
        System.out.print(sb);
    }

    /**
     * Inserts a book into the database.
     *
     * @param book The book to be inserted.
     */
    public static void insertService(Book book) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.save(book);
                transaction.commit();
                System.out.println("Book Inserted successfully.");
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                System.out.println("Error Inserting Book: " + e.getMessage());
            }
        }
    }

    /**
     * Inserts a new book into the database based on user input.
     * Prompts the user to enter information such as title, author, genre, price, and quantity in stock.
     */
    public static void insertBook() {
        Book book = new Book();
        System.out.println("Please enter title:");
        String title = ValidationManagement.getNonEmptyInput("Title cannot be empty.");
        book.setTitle(title);
        System.out.println("Please enter author:");
        String author = ValidationManagement.getNonEmptyInput("Author cannot be empty.");
        book.setAuthor(author);
        System.out.println("Please enter genre:");
        String genre = ValidationManagement.getNonEmptyInput("Genre cannot be empty.");
        book.setGenre(genre);
        System.out.println("Please enter price:");
        Double price = ValidationManagement.getPositiveDoubleInput("Invalid input. Please enter a valid price.");
        book.setPrice(price);
        System.out.println("Please enter quantity in stock:");
        int quantityInStock = ValidationManagement.getNonNegativeIntInput("Invalid input. " +
                                                                          "Please enter a valid quantity in stock.");
        book.setQuantityInStock(quantityInStock);
        insertService(book);
    }

    /**
     * Updates a book in the database.
     *
     * @param book The book to be updated.
     */
    public static void updateServes(Book book) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.update(book);
                transaction.commit();
                System.out.println("Book updated successfully.");
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                System.out.println("Error updating BookId does not exist: ");
            }
        }
    }

    /**
     * Prints details of all books in the database.
     */
    public static void printAllBook() {
        try (Session session = SESSION_FACTORY.openSession()) {
            Query query = session.createQuery("FROM Book ");
            List<Book> books = query.list();
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    /**
     * Updates a book in the database based on user input.
     * Prompts the user to enter information such as title, author, genre, price, and quantity in stock.
     */
    public static void updateBook() {
        printAllBook();
        Book book = new Book();
        System.out.println("Please enter id update");
        int bookId = ValidationManagement.getNonNegativeIntInput("Invalid input. " +
                                                                 "Please enter a valid quantity in stock.");
        book.setBookId((long) bookId);
        System.out.println("Please enter title:");
        String title = ValidationManagement.getNonEmptyInput("Title cannot be empty.");
        book.setTitle(title);
        System.out.println("Please enter author:");
        String author = ValidationManagement.getNonEmptyInput("Author cannot be empty.");
        book.setAuthor(author);
        System.out.println("Please enter genre:");
        String genre = ValidationManagement.getNonEmptyInput("Genre cannot be empty.");
        book.setGenre(genre);
        System.out.println("Please enter price:");
        Double price = ValidationManagement.getPositiveDoubleInput("Invalid input. Please enter a valid price.");
        book.setPrice(price);
        System.out.println("Please enter quantity in stock:");
        int quantityInStock = ValidationManagement.getNonNegativeIntInput("Invalid input. " +
                                                                          "Please enter a valid quantity in stock.");
        book.setQuantityInStock(quantityInStock);
        updateServes(book);
    }

    /**
     * search all  books by author.
     */
    public static void listBooksByAuthor() {
        System.out.println("Please enter author:");
        String author = ValidationManagement.getNonEmptyInput("Author cannot be empty.");

        try (Session session = SESSION_FACTORY.openSession()) {
            String hql = "FROM Book WHERE author = :author";
            Query<Book> query = session.createQuery(hql, Book.class);
            query.setParameter("author", author);

            List<Book> books = query.getResultList();

            if (books.isEmpty()) {
                System.out.println("No books found for the author: " + author);
            } else {
                System.out.println("Books by author " + author + ":");
                for (Book book : books) {
                    System.out.println(book);
                }
            }
        }
    }

    /**
     * search all  books by genre.
     */
    public static void listBooksByGenre() {
        System.out.println("please enter genre");
        String genre = ValidationManagement.getNonEmptyInput("Genre cannot by empty");
        try (Session session = SESSION_FACTORY.openSession()) {
            String hql = "FROM Book WHERE genre = :genre";
            Query<Book> query = session.createQuery(hql, Book.class);
            query.setParameter("genre", genre);
            List<Book> books = query.getResultList();
            if (books.isEmpty()) {
                System.out.println("No books found for the genre: " + genre);
            } else {
                System.out.println("Books by genre " + genre + ":");
                for (Book book : books) {
                    System.out.println(book);
                }
            }

        }
    }

    /**
     * Retrieves a book by its ID from the database.
     *
     * @param id The ID of the book to retrieve.
     * @return The book with the specified ID, or null if not found.
     */
    public static Book getById(Long id) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Book book = session.get(Book.class, id);
            return book;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
