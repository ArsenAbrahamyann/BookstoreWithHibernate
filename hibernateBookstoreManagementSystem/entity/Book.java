package hibernateBookstoreManagementSystem.entity;


import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "books", schema = "public")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String genre;
    @Column(nullable = false)
    private Double price;
    @Column(name = "quantity_in_stock", nullable = false)
    private Integer quantityInStock;

    /**
     * Sets the unique identifier (ID) of the book.
     *
     * @param bookId The new ID to set for the book.
     */
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    /**
     * Gets the title of the book.
     *
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title The new title to set for the book.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the author of the book.
     *
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     *
     * @param author The new author to set for the book.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the genre of the book.
     *
     * @return The genre of the book.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the book.
     *
     * @param genre The new genre to set for the book.
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Gets the price of the book.
     *
     * @return The price of the book.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets the price of the book.
     *
     * @param price The new price to set for the book.
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Gets the quantity of the book in stock.
     *
     * @return The quantity of the book in stock.
     */
    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    /**
     * Sets the quantity of the book in stock.
     *
     * @param quantityInStock The new quantity in stock to set for the book.
     */
    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    /**
     * Returns a string representation of the Book object.
     *
     * @return A string representation of the Book object.
     */
    @Override
    public String toString() {
        return "Book{" +
               "bookId=" + bookId +
               ", title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", genre='" + genre + '\'' +
               ", price=" + price +
               ", quantityInStock=" + quantityInStock +
               '}';
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o The reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId) &&
               Objects.equals(title, book.title) &&
               Objects.equals(author, book.author) &&
               Objects.equals(genre, book.genre) &&
               Objects.equals(price, book.price) &&
               Objects.equals(quantityInStock, book.quantityInStock);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, author, genre, price, quantityInStock);
    }
}
