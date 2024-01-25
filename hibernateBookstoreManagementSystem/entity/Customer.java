package hibernateBookstoreManagementSystem.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customers", schema = "public")
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @Column(nullable = false)
    private String name;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private String phone;

    /**
     * Sets the unique identifier (ID) of the customer.
     *
     * @param customerId The new ID to set for the customer.
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the name of the customer.
     *
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     *
     * @param name The new name to set for the customer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the email address of the customer.
     *
     * @param email The new email address to set for the customer.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the phone number of the customer.
     *
     * @param phone The new phone number to set for the customer.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Returns a string representation of the Customer object.
     *
     * @return A string representation of the Customer object.
     */
    @Override
    public String toString() {
        return "Customer{" +
               "customerId=" + customerId +
               ", name='" + name + '\'' +
               ", email='" + email + '\'' +
               ", phone='" + phone + '\'' +
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
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId) &&
               Objects.equals(name, customer.name) &&
               Objects.equals(email, customer.email) &&
               Objects.equals(phone, customer.phone);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(customerId, name, email, phone);
    }
}
