import java.util.Scanner;

public class Project22_CourierSys{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Parcel ID: ");
        String parcelId = scanner.nextLine();
        String[] route = {"Warehouse", "Sorting Hub", "Customer Address"};
        System.out.println("\n--- Assigned Route ---");
        for (int i = 0; i < route.length; i++) {
            System.out.println("Stop " + (i + 1) + ": " + route[i]);
        }
        int currentStopIndex = 0;
        String status = "REGISTERED";

        while (currentStopIndex < route.length - 1) {
            System.out.println("\nCurrently at Stop " + (currentStopIndex + 1) + ": " + route[currentStopIndex]);
            System.out.print("Enter action (1 = Move to next stop, 2 = Check current status): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    currentStopIndex++;
                    status = "IN_TRANSIT";
                    System.out.println("--> Package moved to: " + route[currentStopIndex]);
                    break;
                case 2:
                    System.out.println("--> Current Status: " + status);
                    break;
                default:
                    System.out.println("--> Invalid choice! Try again.");
                    break;
            }
        }

        System.out.println("\n--- Destination Reached: " + route[currentStopIndex] + " ---");
        System.out.print("Confirm delivery? (type 'yes' or 'no'): ");
        String confirmation = scanner.next();

        if (confirmation.equalsIgnoreCase("yes")) {
            status = "DELIVERED";
            System.out.println("SUCCESS: Parcel " + parcelId + " is marked as " + status + "!");
        } else {
            status = "FAILED_DELIVERY";
            System.out.println("ALERT: Parcel " + parcelId + " delivery failed at destination.");
        }
    }
}