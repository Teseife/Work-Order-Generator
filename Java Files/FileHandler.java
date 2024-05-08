import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * The type File handler.
 */
public class FileHandler {

    /**
     * Write data.
     *
     * @param workOrderFileName the work order file name
     */
    public static void writeData( String workOrderFileName){
        logger("Writing Work Order Data to File");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(workOrderFileName))) {

            writer.write("customer_id,customer_first_name,customer_last_name,ticket_id,ticket_createdAt,workorder_createdAt,employee_id,employee_first_name,employee_last_name,clocked_in,certification");
            writer.newLine();

            for (WorkOrder workOrder : Project3.workOrderList) {
                String workOrderData = workOrder.getFileData();
                writer.write(workOrderData);
                writer.newLine();
                logger(workOrderData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Read employee data.
     *
     * @param employeeFileName the employee file name
     */
    public static void readEmployeeData(String employeeFileName){
        logger( "Loading employee data");
        File Employeefile = new File(employeeFileName);
        try(Scanner scnr = new Scanner(Employeefile)) {
            if(scnr.hasNextLine()){

                scnr.nextLine();
            }
            while (scnr.hasNextLine()){
                String[] line = scnr.nextLine().split(",");

                String employeeId = line[0];
                String firstName = line[1];
                String lastName = line[2];
                String email = line[3];
                String address = line[4];
                String phoneNumber = line[5];
                String clockedIn = line[6];
                String dateHired = line[7];
                String tier = line[8];
                String certification = line[9];

                if(tier.equals("tier1")){
                    Employee Employee = new Employee(firstName,lastName,address,phoneNumber,email,employeeId,clockedIn,dateHired);
                    Project3.employeeList.add(Employee);
                }
                else if (tier.equals("tier2")) {
                    Tier2Employee tier2Employee = new Tier2Employee(firstName,lastName,address,phoneNumber,email,certification,clockedIn,dateHired,certification);
                    Project3.employeeList.add(tier2Employee);
                }
            }// end while

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }

    /**
     * Read ticket data linked list.
     *
     * @param ticketFileName the ticket file name
     * @return the linked list
     */
    public static LinkedList<Ticket> readTicketData(String ticketFileName){
        String loadingMessage = "Loading ticket data";
        logger(loadingMessage);

        File ticketFile = new File(ticketFileName);
        LinkedList<Ticket> ticketList = new LinkedList<>();

        try (Scanner scnr = new Scanner(ticketFile)){

            if(scnr.hasNextLine()){
                scnr.nextLine();
            }
            while (scnr.hasNextLine()){

                String[] line = scnr.nextLine().split(",");

                String customerId = line[0];
                String firstName = line[1];
                String lastName = line[2];
                String email = line[3];
                String address = line[4];
                String phoneNumber = line[5];
                String accountNumber = line[6];
                String ticketId = line[7];
                String createdAt = line[8];

                Customer customer = new Customer(firstName,lastName,address,phoneNumber,email,customerId,accountNumber);
                Ticket ticket = new Ticket(customer, createdAt, ticketId);

                ticketList.add(ticket);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return ticketList;
    }

    private static void logger(String log){
        SimpleDateFormat formatter = new SimpleDateFormat();
        Date date = new Date();
        String logMessage = ("log: " + formatter.format(date) + " : " + log);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true)))
        {
            writer.write(logMessage);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Closing message.
     */
    public static void closingMessage(){
        logger("Work Orders created. Program Exiting");
    }
}

