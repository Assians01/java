import java.util.Scanner;

class SubnetCalculator {
    private String ipAddress;
    private int numSubnets;
    private int[] ipOctets = new int[4];
    private int prefixLength;
    private int newPrefixLength;
    private int subnetMask;
    private int subnetSize;

    public void takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter IP address (e.g., 192.168.1.0):");
        ipAddress = sc.nextLine();
        System.out.println("Enter the current prefix length (e.g., 24):");
        prefixLength = sc.nextInt();
        System.out.println("Enter the number of subnets:");
        numSubnets = sc.nextInt();

        String[] ipParts = ipAddress.split("\\.");
        for (int i = 0; i < 4; i++) {
            ipOctets[i] = Integer.parseInt(ipParts[i]);
        }

        calculateNewPrefixLength();
        calculateSubnetMask();
        calculateSubnetSize();
        printSubnets();
    }

    private void calculateNewPrefixLength() {
        int bitsRequired = (int) Math.ceil(Math.log(numSubnets) / Math.log(2));
        newPrefixLength = prefixLength + bitsRequired;
    }

    private void calculateSubnetMask() {
        subnetMask = 0xFFFFFFFF << (32 - newPrefixLength);
    }

    private void calculateSubnetSize() {
        subnetSize = 1 << (32 - newPrefixLength);
    }

    private void printSubnets() {
        System.out.println("Subnet Mask: " + ((subnetMask >>> 24) & 0xFF) + "." +
                                            ((subnetMask >>> 16) & 0xFF) + "." +
                                            ((subnetMask >>> 8) & 0xFF) + "." +
                                            (subnetMask & 0xFF));
        int baseIP = (ipOctets[0] << 24) | (ipOctets[1] << 16) | (ipOctets[2] << 8) | ipOctets[3];

        for (int i = 0; i < numSubnets; i++) {
            int subnetIP = baseIP + (i * subnetSize);
            int subnetOctet1 = (subnetIP >>> 24) & 0xFF;
            int subnetOctet2 = (subnetIP >>> 16) & 0xFF;
            int subnetOctet3 = (subnetIP >>> 8) & 0xFF;
            int subnetOctet4 = subnetIP & 0xFF;
            System.out.println("Subnet " + (i + 1) + " Start Address: " + subnetOctet1 + "." + subnetOctet2 + "." + subnetOctet3 + "." + subnetOctet4);
        }
    }

    public static void main(String[] args) {
        SubnetCalculator calculator = new SubnetCalculator();
        calculator.takeInput();
    }
}
