/**
 * The type Employee.
 */
public class Employee extends Person{
    private String employeeID;
    private String clockedIn;
    private String hiredDate;

    /**
     * Instantiates a new Employee.
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param address     the address
     * @param phoneNumber the phone number
     * @param email       the email
     * @param employeeID  the employee id
     * @param clockedIn   the clocked in
     * @param hiredDate   the hired date
     */
    public Employee(String firstName, String lastName, String address, String phoneNumber, String email, String employeeID,String clockedIn,String hiredDate) {
        super(firstName, lastName, address, phoneNumber, email);
        this.employeeID = employeeID;
        this.clockedIn = clockedIn;
        this.hiredDate = hiredDate;

    }

    /**
     * Gets employee id.
     *
     * @return the employee id
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * Sets employee id.
     *
     * @param employeeID the employee id
     */
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * Gets clocked in.
     *
     * @return the clocked in
     */
    public String getClockedIn() {
        return clockedIn;
    }

    /**
     * Sets clocked in.
     *
     * @param clockedIn the clocked in
     */
    public void setClockedIn(String clockedIn) {
        this.clockedIn = clockedIn;
    }

    /**
     * Gets hired date.
     *
     * @return the hired date
     */
    public String getHiredDate() {
        return hiredDate;
    }

    /**
     * Sets hired date.
     *
     * @param hiredDate the hired date
     */
    public void setHiredDate(String hiredDate) {
        this.hiredDate = hiredDate;
    }

    @Override
    public String getFileData(){
         return getEmployeeID()  + " , " + super.getFileData() +  " , " + getClockedIn();
    }
}
