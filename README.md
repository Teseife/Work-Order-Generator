# Work-Order-Generator
The Work Order Generator is a Java-based application designed to automate the creation of work orders based on employee and ticket data. This project demonstrates the application of object-oriented programming principles, including class creation, inheritance, interface implementation, and basic file handling.
## Objectives
- Create class files from UML diagrams.
- Implement inheritance and interfaces.
- Manage data through file input/output operations.

## How to Run
To run the Work Order Generator, follow these steps:
1. Clone the repository:
   * git clone <repository-url>
3. Compile the Java files (ensure all 9 required .java files are present):
   * javac*.java
5. Execute the main class (replace `MainClassName` with the actual main class name):
   *java MainClassName

## Features
- **Employee Data Loading**: Loads employee data from a CSV file and logs the process.
- **Ticket Data Loading**: Imports ticket data and associates them with respective customer details.
- **Work Order Creation**: Generates work orders based on the available tickets and assigns them to the appropriate employees.
- **Data Output**: Outputs the newly created work orders to a CSV file and logs each step.

## CSV File Structure
The application expects the following CSV files in the project's working directory you can find the files in the [CSV File](https://github.com/Teseife/Work-Order-Generator/tree/main/Java%20Files/CSV%20File) Folder:
- `employee_data.csv`
- `tier1_ticket_data.csv`
- `tier2_ticket_data.csv`

The output and logs are written to:
- `workorder_data.csv`
- `log.txt`
  
## UML Represnting File relaitons:
![IMG_0092](https://github.com/Teseife/Work-Order-Generator/assets/92551215/84f286a2-8c85-479d-8816-c20ae2dfc53c)
## Benchmark Comparisons
We have introduced a new version of the Work Order Generator that utilizes multithreading to improve performance. Below are benchmark comparisons showing the performance improvements:

| Feature                  | Single-threaded Time | Multi-threaded Time |
|--------------------------|----------------------|---------------------|
| Load Employee Data       | 15s                  | 5s                  |
| Load Ticket Data         | 20s                  | 17s                 |
| Create Work Orders       | 30s                  | 10s                 |
| Write Work Order Data    | 10s                  | 7s                  |

Multithreading has reduced the processing time by approximatly 48%, enhancing the efficiency of the application especially in environments with large datasets.
[Work Order Generator V2](https://github.com/Teseife/Work-Order-Generator/blob/main/Java%20Files/Project%203%20V2.java)
<details>
  <summary><strong>🚨 Important Notice:</strong></summary>
  <p> Run times depend on the system. A faster processor may execute the application more quickly.</p>
</details>


## Example Output:
Project 3 Work Order Generator

* Loading Employee Data
* Loading Ticket Data
* Creating Work Orders
* Writing Work Order Data to File
* Work Orders Created. Program Exiting


## Contribution
Contributions are welcome. Please adhere to the provided coding styles and naming conventions.

## License
This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/Teseife/Work-Order-Generator/blob/main/LICENSE) file for details.

