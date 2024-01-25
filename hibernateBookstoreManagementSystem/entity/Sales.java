package hibernateBookstoreManagementSystem.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "sales", schema = "public")
public class Sales {
    @Id
    @Column(name = "sale_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saleId;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;
    @Column(name = "data_of_sale")
    private LocalDate dateOfSale;
    @Column(name = "quantity_solid", nullable = false)
    private Integer quantitySolid;
    @Column(name = "total_price", nullable = false)
    private Double totalPrice;

    /**
     * Sets the book associated with the sales transaction.
     *
     * @param book The book to be associated with the sales transaction.
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * Sets the customer associated with the sales transaction.
     *
     * @param customer The customer to be associated with the sales transaction.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Sets the date of the sales transaction.
     *
     * @param dateOfSale The date of the sales transaction.
     */
    public void setDateOfSale(LocalDate dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    /**
     * Sets the quantity of the book sold in the sales transaction.
     *
     * @param quantitySolid The quantity of the book sold.
     */
    public void setQuantitySolid(Integer quantitySolid) {
        this.quantitySolid = quantitySolid;
    }

    /**
     * Sets the total price of the sales transaction.
     *
     * @param totalPrice The total price of the sales transaction.
     */
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
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
        Sales sales = (Sales) o;
        return Objects.equals(saleId, sales.saleId) &&
               Objects.equals(dateOfSale, sales.dateOfSale) &&
               Objects.equals(quantitySolid, sales.quantitySolid) &&
               Objects.equals(totalPrice, sales.totalPrice);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(saleId, dateOfSale, quantitySolid, totalPrice);
    }

    /**
     * Returns a string representation of the Sales object.
     *
     * @return A string representation of the Sales object.
     */
    @Override
    public String toString() {
        return "Sales{" +
               "saleId=" + saleId +
               ", book=" + book.getTitle() +
               ", " + book.getAuthor() +
               ", " + book.getGenre() +
               ", " + book.getPrice() +
               ", customer=" + customer.getName() +
               ", dateOfSale=" + dateOfSale +
               ", quantitySolid=" + quantitySolid +
               ", totalPrice=" + totalPrice +
               '}';
    }
}

