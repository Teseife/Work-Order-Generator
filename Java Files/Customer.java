/**
 * The type Customer.
 */
public class Customer extends Person{
    private String customerId;
    private String accountNumber;

    /**
     * Instantiates a new Customer.
     *
     * @param firstName     the first name
     * @param lastName      the last name
     * @param address       the address
     * @param phoneNumber   the phone number
     * @param email         the email
     * @param customerId    the customer id
     * @param accountNumber the account number
     */
    public Customer(String firstName, String lastName, String address, String phoneNumber, String email,String customerId,String accountNumber) {
        super(firstName, lastName, address, phoneNumber, email);
        this.setCustomerId(customerId);
        this.setAccountNumber(accountNumber);
    }

    /**
     * Gets customer id.
     *
     * @return the customer id
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets customer id.
     *
     * @param customerId the customer id
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets account number.
     *
     * @return the account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets account number.
     *
     * @param accountNumber the account number
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String getFileData() {
        return super.getFileData();
    }
}
