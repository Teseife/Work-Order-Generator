import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Queue;

/* Author: Thomas Seife
 * Project 3: COP 3503
 * Title :  Work Order Generator
 * Due Date: 04/28/2024
 * Objective: The `Project3` program automates the creation of work orders from ticket data, assigning tickets to
 * employees based on their roles and writing the results to a file. This streamlines the processing of service
 *  requests, improving efficiency and management.
 */
public class Project3 {
    /**
     * The constant employeeFileName.
     */
    public static String employeeFileName;
    /**
     * The constant tier1TicketFileName.
     */
    public static String tier1TicketFileName;
    /**
     * The constant tier2TicketFileName.
     */
    public static String tier2TicketFileName;
    /**
     * The constant workOrderFileName.
     */
    public static String workOrderFileName;
    /**
     * The constant employeeList.
     */
    public static ArrayList<Employee> employeeList = new ArrayList<Employee>();
    /**
     * The Tier 1 ticket list.
     */
    public static Queue<Ticket> tier1TicketList;
    /**
     * The Tier 2 ticket list.
     */
    public static Queue<Ticket> tier2TicketList;
    /**
     * The constant workOrderList.
     */
    public static ArrayList<WorkOrder> workOrderList = new ArrayList<WorkOrder>();

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
       System.out.println("Project 3 work order generator");
       System.out.println("");
       employeeFileName = "src\\employee_data.csv";
       tier1TicketFileName = "src\\tier1_ticket_data.csv";
       tier2TicketFileName = "src\\tier2_ticket_data.csv";
       workOrderFileName = "src\\workorder_data.csv";
       System.out.println("Loading Employee Data");
       FileHandler.readEmployeeData(employeeFileName);
       System.out.println("Loading Ticket Data");
       tier1TicketList = FileHandler.readTicketData(tier1TicketFileName);
       tier2TicketList = FileHandler.readTicketData(tier2TicketFileName);
       System.out.println("Creating Work Orders");
       createWorkOrders();
       System.out.println("Writing Work Order Data to File");// console
       FileHandler.writeData(workOrderFileName);// file
       System.out.println("Work Orders created. Program Exiting"); // console
       FileHandler.closingMessage();// file
    }

    /**
     * Create work orders.
     */
    public static void createWorkOrders(){

        int employeeIndex = 0;

        for (Ticket ticket : tier1TicketList) {
            Employee employee = employeeList.get(employeeIndex);

            if (employee instanceof Employee) {
                WorkOrder myWorkOrder = new WorkOrder(employee, ticket, currentDate());
                workOrderList.add(myWorkOrder);
            }


            employeeIndex = (employeeIndex + 1) % employeeList.size();
        }



        for (Ticket ticket : tier2TicketList) {
            Employee employee = employeeList.get(employeeIndex);

            if (employee instanceof Tier2Employee) {
                WorkOrder myWorkOrder = new WorkOrder(employee, ticket, currentDate());
                workOrderList.add(myWorkOrder);
            }
            // warp around
            employeeIndex = (employeeIndex + 1) % employeeList.size();
        }

    }
    /**
     * A Helper Method to Create Current Date and Time.
     */
    private static String currentDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = new Date();
        String createdAt =  formatter.format(date);
        return createdAt;
    }
}