/**
 * The type Work order.
 */
public class WorkOrder implements Printable {
    private Employee employee;
    private Ticket ticket;
    private String createdAt;


    /**
     * Instantiates a new Work order.
     *
     * @param employee  the employee
     * @param ticket    the ticket
     * @param createdAt the created at
     */
    public WorkOrder(Employee employee, Ticket ticket, String createdAt){
        this.setEmployee(employee);
        this.setTicket(ticket);
        this.setCreatedAt(createdAt);

    }

    /**
     * Gets employee.
     *
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Sets employee.
     *
     * @param employee the employee
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Gets ticket.
     *
     * @return the ticket
     */
    public Ticket getTicket() {
        return ticket;
    }

    /**
     * Sets ticket.
     *
     * @param ticket the ticket
     */
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
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

    @Override
    public String getFileData() {

        return ticket.getCustomer().getCustomerId() + " , " + ticket.getCustomer().getFileData()  + " , " + ticket.getTicketId()  + " , " + ticket.getCreatedAt()  + " , " + getCreatedAt() + " , " + employee.getFileData();
    }
}
