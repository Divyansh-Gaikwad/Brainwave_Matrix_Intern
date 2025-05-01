import java.util.*;
import java.io.*;

public class HospitalManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static Map<String, Patient> patients = FileHandler.loadPatients("patients.dat");
    static List<Appointment> appointments = FileHandler.loadList("appointments.dat");
    static List<HealthRecord> records = FileHandler.loadList("records.dat");
    static List<Bill> bills = FileHandler.loadList("bills.dat");
    static List<InventoryItem> inventory = FileHandler.loadList("inventory.dat");
    static Map<String, Staff> staffMap = loadStaffMap("staff.dat");

    static String currentUser = null;

    public static void main(String[] args) {
        if (!login()) return;

        while (true) {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Register Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. Add Health Record");
            System.out.println("4. Generate Bill");
            System.out.println("5. Manage Inventory");
            System.out.println("6. View Data");
            System.out.println("7. Add Staff");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> registerPatient();
                case 2 -> scheduleAppointment();
                case 3 -> addHealthRecord();
                case 4 -> generateBill();
                case 5 -> manageInventory();
                case 6 -> viewDataMenu();
                case 7 -> addStaff();
                case 8 -> {
                    saveAll();
                    System.out.println("Data saved. Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static boolean login() {
        System.out.println("--- Login ---");
        System.out.print("Enter Staff ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        Staff s = staffMap.get(id);
        if (s != null && s.name.equalsIgnoreCase(name)) {
            currentUser = s.name;
            System.out.println("Login successful. Welcome, " + currentUser + "!");
            return true;
        } else {
            System.out.println("Invalid credentials.");
            return false;
        }
    }

    static void registerPatient() {
        System.out.print("Enter Patient ID: ");
        String id = sc.nextLine();
        if (patients.containsKey(id)) {
            System.out.println("Patient already exists.");
            return;
        }
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Gender: ");
        String gender = sc.nextLine();
        patients.put(id, new Patient(id, name, age, gender));
        System.out.println("Patient registered.");
    }

    static void scheduleAppointment() {
        System.out.print("Enter Patient ID: ");
        String id = sc.nextLine();
        if (!patients.containsKey(id)) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.print("Doctor Name: ");
        String doctor = sc.nextLine();
        System.out.print("Date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        appointments.add(new Appointment(id, doctor, date));
        System.out.println("Appointment scheduled.");
    }

    static void addHealthRecord() {
        System.out.print("Enter Patient ID: ");
        String id = sc.nextLine();
        if (!patients.containsKey(id)) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.print("Diagnosis: ");
        String diagnosis = sc.nextLine();
        System.out.print("Prescription: ");
        String prescription = sc.nextLine();
        records.add(new HealthRecord(id, diagnosis, prescription));
        System.out.println("Health record added.");
    }

    static void generateBill() {
        System.out.print("Enter Patient ID: ");
        String id = sc.nextLine();
        if (!patients.containsKey(id)) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.print("Amount: ");
        double amt = Double.parseDouble(sc.nextLine());
        bills.add(new Bill(id, amt));
        System.out.println("Bill generated.");
    }

    static void manageInventory() {
        System.out.print("Item Name: ");
        String item = sc.nextLine();
        System.out.print("Quantity: ");
        int qty = Integer.parseInt(sc.nextLine());

        boolean found = false;
        for (InventoryItem i : inventory) {
            if (i.itemName.equalsIgnoreCase(item)) {
                i.quantity += qty;
                found = true;
                break;
            }
        }
        if (!found) {
            inventory.add(new InventoryItem(item, qty));
        }
        System.out.println("Inventory updated.");
    }

    static void viewDataMenu() {
        System.out.println("View:");
        System.out.println("1. Patients");
        System.out.println("2. Appointments");
        System.out.println("3. Health Records");
        System.out.println("4. Bills");
        System.out.println("5. Inventory");
        System.out.println("6. Staff");
        System.out.print("Choice: ");
        int c = Integer.parseInt(sc.nextLine());
        switch (c) {
            case 1 -> patients.values().forEach(System.out::println);
            case 2 -> appointments.forEach(System.out::println);
            case 3 -> records.forEach(System.out::println);
            case 4 -> bills.forEach(System.out::println);
            case 5 -> inventory.forEach(System.out::println);
            case 6 -> staffMap.values().forEach(System.out::println);
            default -> System.out.println("Invalid.");
        }
    }

    static void addStaff() {
        System.out.print("Staff ID: ");
        String id = sc.nextLine();
        if (staffMap.containsKey(id)) {
            System.out.println("Staff already exists.");
            return;
        }
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Role: ");
        String role = sc.nextLine();
        staffMap.put(id, new Staff(id, name, role));
        System.out.println("Staff added.");
    }

    static void saveAll() {
        FileHandler.saveData(patients, "patients.dat");
        FileHandler.saveData(appointments, "appointments.dat");
        FileHandler.saveData(records, "records.dat");
        FileHandler.saveData(bills, "bills.dat");
        FileHandler.saveData(inventory, "inventory.dat");
        FileHandler.saveData(new ArrayList<>(staffMap.values()), "staff.dat");
    }

    static Map<String, Staff> loadStaffMap(String filename) {
        List<Staff> list = FileHandler.loadList(filename);
        Map<String, Staff> map = new HashMap<>();
        for (Staff s : list) {
            map.put(s.id, s);
        }
        return map;
    }
}
