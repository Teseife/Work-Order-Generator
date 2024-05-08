/**
 * The type Tier 2 employee.
 */
public class Tier2Employee extends Employee{
    private String certification;

    /**
     * Instantiates a new Tier 2 employee.
     *
     * @param firstName     the first name
     * @param lastName      the last name
     * @param address       the address
     * @param phoneNumber   the phone number
     * @param email         the email
     * @param employeeID    the employee id
     * @param clockedIn     the clocked in
     * @param hiredDate     the hired date
     * @param certification the certification
     */
    public Tier2Employee(String firstName, String lastName, String address, String phoneNumber, String email, String employeeID, String clockedIn, String hiredDate,String certification) {
        super(firstName, lastName, address, phoneNumber, email, employeeID, clockedIn, hiredDate);
        this.setCertification(certification);
    }

    /**
     * Gets certification.
     *
     * @return the certification
     */
    public String getCertification() {
        return certification;
    }

    /**
     * Sets certification.
     *
     * @param certification the certification
     */
    public void setCertification(String certification) {
        this.certification = certification;
    }

    @Override
    public String getFileData() {
        return super.getFileData() + " , " + getCertification();
    }
}
