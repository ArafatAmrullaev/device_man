import java.util.Random;
import java.util.Scanner;

class Device {
    private String type;
    private double price;
    private double weight;

    public Device(String type, double price, double weight) {
        this.type = type;
        this.price = price;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

class Smartphone extends Device {
    private double screenSize;
    private int cameraResolution;

    public Smartphone(String type, double price, double weight, double screenSize, int cameraResolution) {
        super(type, price, weight);
        this.screenSize = screenSize;
        this.cameraResolution = cameraResolution;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getCameraResolution() {
        return cameraResolution;
    }

    public void setCameraResolution(int cameraResolution) {
        this.cameraResolution = cameraResolution;
    }
}

class Laptop extends Device {
    private String processor;
    private int ram;

    public Laptop(String type, double price, double weight, String processor, int ram) {
        super(type, price, weight);
        this.processor = processor;
        this.ram = ram;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}

class Tablet extends Device {
    private String operatingSystem;

    public Tablet(String type, double price, double weight, String operatingSystem) {
        super(type, price, weight);
        this.operatingSystem = operatingSystem;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}

public class DeviceManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter the number of devices you want to create (between 1 and 20): ");
        int numDevices = scanner.nextInt();
        scanner.nextLine();  

        if (numDevices < 1 || numDevices > 20) {
            System.out.println("Please enter a valid number between 1 and 20.");
            return;
        }

        double totalPrice = 0;
        double totalWeight = 0;
        int distinctDeviceTypes = 0;

        for (int i = 0; i < numDevices; i++) {
            String type;
            if (i % 3 == 0) {
                type = "Smartphone";
            } else if (i % 3 == 1) {
                type = "Laptop";
            } else {
                type = "Tablet";
            }

            double price = 100 + random.nextDouble() * 1900; 
            double weight = 200 + random.nextDouble() * 1800;  

            if (type.equals("Smartphone")) {
                double screenSize = 4 + random.nextDouble() * 6; 
                int cameraResolution = 5 + random.nextInt(16);  
                Smartphone smartphone = new Smartphone(type, price, weight, screenSize, cameraResolution);
                totalPrice += price;
                totalWeight += weight;
            } else if (type.equals("Laptop")) {
                String processor = "Intel i" + (3 + random.nextInt(8)) + " CPU";  
                int ram = 4 + random.nextInt(13);  
                Laptop laptop = new Laptop(type, price, weight, processor, ram);
                totalPrice += price;
                totalWeight += weight;
            } else {
                String operatingSystem = "Android " + (4 + random.nextInt(15)); 
                Tablet tablet = new Tablet(type, price, weight, operatingSystem);
                totalPrice += price;
                totalWeight += weight;
            }

            distinctDeviceTypes++;
        }

        System.out.println("Number of distinct device types created: " + distinctDeviceTypes);
        System.out.println("Total price of all devices: $" + totalPrice);
        System.out.println("Total weight of all devices: " + totalWeight + " grams");
    }
}
