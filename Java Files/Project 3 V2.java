import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.*;

/* Author: Thomas Seife
 * Project 3: COP 3503
 * Title :  Work Order Generator
 * Due Date: 05/08/2024
 * Objective: The Project3 program is designed to automate the creation of work orders from ticket data,
 * efficiently assigning tickets to employees based on their roles and documenting the outcomes to a file.
 * This version of the Work Order Generator leverages multithreading to optimize the processing of service
 * requests, thereby enhancing operational efficiency and management.
 *
 * This second version of the Work Order Generator emphasizes efficient modeling through the use of
 * multithreading, aiming to improve throughput and reduce processing time.
 */
public class Project3 {
    /**
     * The constant employeeFileName.
     */
    public static String employeeFileName = "src\\employee_data.csv";
    /**
     * The constant tier1TicketFileName.
     */
    public static String tier1TicketFileName = "src\\tier1_ticket_data.csv";
    /**
     * The constant tier2TicketFileName.
     */
    public static String tier2TicketFileName = "src\\tier2_ticket_data.csv";
    /**
     * The constant workOrderFileName.
     */
    public static String workOrderFileName = "src\\workorder_data.csv";
    /**
     * The constant employeeList.
     */
    public static ArrayList<Employee> employeeList = new ArrayList<>();
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
    public static ArrayList<WorkOrder> workOrderList = new ArrayList<>();

    private static ExecutorService executor = Executors.newFixedThreadPool(4);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        System.out.println("Project 3 work order generator");
        System.out.println("Loading Employee Data");

        Future<?> employeeFuture = executor.submit(() -> {
            FileHandler.readEmployeeData(employeeFileName);
        });

        Future<Queue<Ticket>> tier1Future = executor.submit(() -> {
            return FileHandler.readTicketData(tier1TicketFileName);
        });
        Future<Queue<Ticket>> tier2Future = executor.submit(() -> {
            return FileHandler.readTicketData(tier2TicketFileName);
        });

        // Wait for data loading to complete before proceeding
        try {
            employeeFuture.get();  // Ensure employee data is loaded
            tier1TicketList = tier1Future.get();
            tier2TicketList = tier2Future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Creating Work Orders");
        executor.submit(() -> createWorkOrders());

        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println("Executor did not terminate");
                }
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("Writing Work Order Data to File");
        FileHandler.writeData(workOrderFileName);
        System.out.println("Work Orders created. Program Exiting");
        FileHandler.closingMessage();

        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + " ms");
        System.out.println("All data loaded. Proceeding to process work orders.");
    }

    /**
     * Create work orders.
     */
    public static void createWorkOrders() {
        int employeeIndex = 0;
        // Assuming tier1TicketList and tier2TicketList are thread-safe implementations like ConcurrentLinkedQueue
        for (Ticket ticket : tier1TicketList) {
            Employee employee = employeeList.get(employeeIndex % employeeList.size());
            if (employee instanceof Employee) {
                WorkOrder myWorkOrder = new WorkOrder(employee, ticket, currentDate());
                synchronized (workOrderList) {
                    workOrderList.add(myWorkOrder);
                }
            }
            employeeIndex++;
        }

        for (Ticket ticket : tier2TicketList) {
            Employee employee = employeeList.get(employeeIndex % employeeList.size());
            if (employee instanceof Tier2Employee) {
                WorkOrder myWorkOrder = new WorkOrder(employee, ticket, currentDate());
                synchronized (workOrderList) {
                    workOrderList.add(myWorkOrder);
                }
            }
            employeeIndex++;
        }
    }

    private static String currentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = new Date();
        return formatter.format(date);
    }
}
