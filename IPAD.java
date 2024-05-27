import java.util.Scanner;

class IPAnalyzer {
    private int firstOctet, secondOctet, thirdOctet, fourthOctet;
    private Scanner sc = new Scanner(System.in);

    public void takeIP() {
        System.out.println("Enter first octet value:");
        firstOctet = sc.nextInt();
        System.out.println("Enter second octet value:");
        secondOctet = sc.nextInt();
        System.out.println("Enter third octet value:");
        thirdOctet = sc.nextInt();
        System.out.println("Enter fourth octet value:");
        fourthOctet = sc.nextInt();
        System.out.println("IP Address in dotted decimal form is: " + firstOctet + "." + secondOctet + "." + thirdOctet + "." + fourthOctet);
    }

    public String getClass1() {
        if (firstOctet >= 0 && firstOctet <= 127) {
            return "Class A";
        } else if (firstOctet >= 128 && firstOctet <= 191) {
            return "Class B";
        } else if (firstOctet >= 192 && firstOctet <= 223) {
            return "Class C";
        } else if (firstOctet >= 224 && firstOctet <= 239) {
            return "Class D";
        } else if (firstOctet >= 240 && firstOctet <= 255) {
            return "Class E";
        } else {
            return "Invalid";
        }
    }

    public void findNet() {
        if (firstOctet >= 0 && firstOctet <= 127) {
            System.out.println("Default mask is: 255.0.0.0");
            System.out.println("Net ID is: " + firstOctet + ".0.0.0");
        } else if (firstOctet >= 128 && firstOctet <= 191) {
            System.out.println("Default mask is: 255.255.0.0");
            System.out.println("Net ID is: " + firstOctet + "." + secondOctet + ".0.0");
        } else if (firstOctet >= 192 && firstOctet <= 223) {
            System.out.println("Default mask is: 255.255.255.0");
            System.out.println("Net ID is: " + firstOctet + "." + secondOctet + "." + thirdOctet + ".0");
        } else if (firstOctet >= 224 && firstOctet <= 239) {
            System.out.println("Default mask is: 255.255.255.255");
            System.out.println("Net ID is: " + firstOctet + "." + secondOctet + "." + thirdOctet + "." + fourthOctet);
        } else {
            System.out.println("Invalid IP address for finding network.");
        }
    }

    public void findHost() {
        if (firstOctet >= 0 && firstOctet <= 127) {
            System.out.println("Host ID is: " + secondOctet + "." + thirdOctet + "." + fourthOctet);
        } else if (firstOctet >= 128 && firstOctet <= 191) {
            System.out.println("Host ID is: " + thirdOctet + "." + fourthOctet);
        } else if (firstOctet >= 192 && firstOctet <= 223) {
            System.out.println("Host ID is: " + fourthOctet);
        } else if (firstOctet >= 224 && firstOctet <= 239) {
            System.out.println("Multicast addresses do not have Host IDs.");
        } else {
            System.out.println("Invalid IP address for finding host.");
        }
    }
}

public class IPv4Analyzer {
    public static void main(String[] args) {
        IPAnalyzer analyzer = new IPAnalyzer();
        analyzer.takeIP();
        String ipClass = analyzer.getClass1();
        System.out.println("IP Class: " + ipClass);
        analyzer.findNet();
        analyzer.findHost();
    }
}

