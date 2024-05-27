import java.util.Scanner;

class ClasslessIPAnalyzer {
    private String ipAddress;
    private int prefixLength;
    private int[] ipOctets = new int[4];
    private int[] subnetMask = new int[4];
    private int[] netID = new int[4];
    private int[] hostID = new int[4];

    public void takeIPAndPrefix() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter IP address in CIDR notation (e.g., 192.168.1.1/24):");
        String input = sc.nextLine();
        String[] parts = input.split("/");
        ipAddress = parts[0];
        prefixLength = Integer.parseInt(parts[1]);

        String[] ipParts = ipAddress.split("\\.");
        for (int i = 0; i < 4; i++) {
            ipOctets[i] = Integer.parseInt(ipParts[i]);
        }

        calculateSubnetMask();
        calculateNetID();
        calculateHostID();
    }

    private void calculateSubnetMask() {
        int mask = 0xFFFFFFFF << (32 - prefixLength);
        subnetMask[0] = (mask >>> 24) & 0xFF;
        subnetMask[1] = (mask >>> 16) & 0xFF;
        subnetMask[2] = (mask >>> 8) & 0xFF;
        subnetMask[3] = mask & 0xFF;

        System.out.println("Subnet Mask is: " + subnetMask[0] + "." + subnetMask[1] + "." + subnetMask[2] + "." + subnetMask[3]);
    }

    private void calculateNetID() {
        for (int i = 0; i < 4; i++) {
            netID[i] = ipOctets[i] & subnetMask[i];
        }
        System.out.println("Net ID is: " + netID[0] + "." + netID[1] + "." + netID[2] + "." + netID[3]);
    }

    private void calculateHostID() {
        for (int i = 0; i < 4; i++) {
            hostID[i] = ipOctets[i] & ~subnetMask[i];
        }
        System.out.println("Host ID is: " + hostID[0] + "." + hostID[1] + "." + hostID[2] + "." + hostID[3]);
    }

    public static void main(String[] args) {
        ClasslessIPAnalyzer analyzer = new ClasslessIPAnalyzer();
        analyzer.takeIPAndPrefix();
    }
}
