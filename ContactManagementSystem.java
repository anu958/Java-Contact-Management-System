import java.util.ArrayList;
import java.util.Scanner;

// Contact class to hold contact information
class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + emailAddress;
    }
}

// ContactManager class to manage contacts
class ContactManager {
    private ArrayList<Contact> contacts;

    public ContactManager() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("List of contacts:");
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }

    public void editContact(int index, String newName, String newPhoneNumber, String newEmailAddress) {
        if (index >= 0 && index < contacts.size()) {
            Contact contact = contacts.get(index);
            contact.setName(newName);
            contact.setPhoneNumber(newPhoneNumber);
            contact.setEmailAddress(newEmailAddress);
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void deleteContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            Contact deletedContact = contacts.remove(index);
            System.out.println("Contact " + deletedContact.getName() + " deleted successfully.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    public boolean isEmpty() {
        return contacts.isEmpty();
    }
}

// Main class to run the contact management program
public class ContactManagementSystem {
    private static ContactManager contactManager = new ContactManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    exitProgram();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nContact Management System");
        System.out.println("1. Add New Contact");
        System.out.println("2. View All Contacts");
        System.out.println("3. Edit a Contact");
        System.out.println("4. Delete a Contact");
        System.out.println("5. Exit");
    }

    private static int getChoice() {
        System.out.print("Enter your choice (1-5): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        return choice;
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter email address: ");
        String emailAddress = scanner.nextLine();

        Contact newContact = new Contact(name, phoneNumber, emailAddress);
        contactManager.addContact(newContact);
    }

    private static void viewContacts() {
        contactManager.viewContacts();
    }

    private static void editContact() {
        if (contactManager.isEmpty()) {
            System.out.println("No contacts to edit.");
            return;
        }

        contactManager.viewContacts();
        System.out.print("Enter the index of the contact to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        System.out.print("Enter new name (leave empty to keep current): ");
        String newName = scanner.nextLine();

        System.out.print("Enter new phone number (leave empty to keep current): ");
        String newPhoneNumber = scanner.nextLine();

        System.out.print("Enter new email address (leave empty to keep current): ");
        String newEmailAddress = scanner.nextLine();

        contactManager.editContact(index - 1, newName, newPhoneNumber, newEmailAddress);
    }

    private static void deleteContact() {
        if (contactManager.isEmpty()) {
            System.out.println("No contacts to delete.");
            return;
        }

        contactManager.viewContacts();
        System.out.print("Enter the index of the contact to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        contactManager.deleteContact(index - 1);
    }

    private static void exitProgram() {
        System.out.println("Exiting program...");
        scanner.close();
        System.exit(0);
    }
}