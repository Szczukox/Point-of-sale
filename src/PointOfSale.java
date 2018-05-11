public class PointOfSale {

    public static void main(String[] args) {
        Database database = new Database();

        Scanner scanner = new Scanner();

        while (true) {
            String inputFromScanner = scanner.readBarCode();
            if (inputFromScanner.equals("exit")) {
                break;
            }
            else {
                System.out.println(inputFromScanner);
            }
        }
    }
}
