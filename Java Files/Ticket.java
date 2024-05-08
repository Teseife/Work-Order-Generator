/**
 * The type Ticket.
 */
public class Ticket implements Printable {
    private Customer customer;
    private String createdAt;
    private String ticketId;

    /**
     * Instantiates a new Ticket.
     *
     * @param customer  the customer
     * @param createdAt the created at
     * @param ticketId  the ticket id
     */
    public Ticket(Customer customer, String createdAt, String ticketId){
        this.setCustomer(customer);
        this.setCreatedAt(createdAt);
        this.setTicketId(ticketId);
    }

    /**
     * Gets customer.
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets customer.
     *
     * @param customer the customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets ticket id.
     *
     * @return the ticket id
     */
    public String getTicketId() {
        return ticketId;
    }

    /**
     * Sets ticket id.
     *
     * @param ticketId the ticket id
     */
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public String getFileData() {
        return customer.getFileData() + " , " + getTicketId()+ " , " + getCreatedAt() ;
    }
}
