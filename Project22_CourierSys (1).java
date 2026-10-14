import java.util.Scanner;

public class Project22_CourierSys {
    public static void main(String[] args) {
        String[] route = {"Warehouse", "Sorting Hub", "Customer Address"};
        String parcelId;
        int currentStopIndex = 0;
        String status = "REGISTERED";

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Parcel ID: ");
            parcelId = scanner.nextLine().trim();

            while (parcelId.isEmpty()) {
                System.out.print("Parcel ID cannot be empty. Enter Parcel ID: ");
                parcelId = scanner.nextLine().trim();
            }

            System.out.println("\n--- Assigned Route ---");
            for (int i = 0; i < route.length; i++) {
                System.out.println("Stop " + (i + 1) + ": " + route[i]);
            }

            boolean keepTracking = true;
            while (keepTracking) {
                System.out.println("\nParcel ID: " + parcelId);
                System.out.println("Current Location: " + route[currentStopIndex]);
                System.out.println("Current Status: " + status);

                if (currentStopIndex == route.length - 1) {
                    break;
                }

                System.out.println("1 = Move to next stop");
                System.out.println("2 = Check current status");
                System.out.println("3 = Exit tracking");
                System.out.print("Choose an action: ");

                String input = scanner.nextLine().trim();
                int choice;
                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter 1, 2, or 3.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        currentStopIndex++;
                        status = "IN_TRANSIT";
                        System.out.println("--> Package moved to: " + route[currentStopIndex]);
                        break;
                    case 2:
                        System.out.println("--> Parcel " + parcelId + " is " + status
                                + " at " + route[currentStopIndex] + ".");
                        break;
                    case 3:
                        keepTracking = false;
                        System.out.println("Tracking stopped. Current status: " + status);
                        break;
                    default:
                        System.out.println("Invalid choice! Please select 1, 2, or 3.");
                }
            }

            if (currentStopIndex == route.length - 1) {
                System.out.println("\n--- Destination Reached: "
                        + route[currentStopIndex] + " ---");

                String confirmation;
                while (true) {
                    System.out.print("Confirm delivery? (yes/no): ");
                    confirmation = scanner.nextLine().trim();

                    if (confirmation.equalsIgnoreCase("yes")) {
                        status = "DELIVERED";
                        System.out.println("SUCCESS: Parcel " + parcelId
                                + " is marked as " + status + "!");
                        break;
                    } else if (confirmation.equalsIgnoreCase("no")) {
                        status = "FAILED_DELIVERY";
                        System.out.println("ALERT: Parcel " + parcelId
                                + " delivery failed at destination.");
                        break;
                    } else {
                        System.out.println("Please enter only 'yes' or 'no'.");
                    }
                }
            }

            System.out.println("\n--- Final Tracking Summary ---");
            System.out.println("Parcel ID: " + parcelId);
            System.out.println("Last Location: " + route[currentStopIndex]);
            System.out.println("Final Status: " + status);
        }
    }
}
