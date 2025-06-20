import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    int id;
    String name;
    int age;
    String disease;

    public Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Disease: " + disease);
        System.out.println("--------------------");
    }
}

public class HospitalManagement {
    static ArrayList<Patient> patients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient by ID");
            System.out.println("4. Delete Patient");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    searchPatient();
                    break;
                case 4:
                    deletePatient();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void addPatient() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear buffer
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        patients.add(new Patient(id, name, age, disease));
        System.out.println("Patient added successfully!");
    }

    static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients to show.");
        } else {
            for (Patient p : patients) {
                p.display();
            }
        }
    }

    static void searchPatient() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Patient p : patients) {
            if (p.id == id) {
                p.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Patient not found.");
        }
    }

    static void deletePatient() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        boolean removed = patients.removeIf(p -> p.id == id);

        if (removed) {
            System.out.println("Patient deleted successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }
}
