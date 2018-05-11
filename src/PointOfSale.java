public class PointOfSale {

    public static void main(String[] args) {
        Database database = new Database();

        Scanner scanner = new Scanner();
        Display display = new Display();
        Printer printer = new Printer();

        while (true) {
            String inputFromScanner = scanner.readBarCode();
            if (inputFromScanner.equals("exit")) {
                display.displayTotalSum();
                printer.printReceipt(display.getProducts(), display.getTotalSum());
                break;
            }
            else if (inputFromScanner.equals("")){
                display.displayInvalidBarCodeMessage();
            } else {
                int idProduct = Integer.parseInt(inputFromScanner);
                if (database.isInStock(idProduct)) {
                    display.displayProductInfo(database.getProductFromDatabase(idProduct));
                }
                else {
                    display.displayProductNotFoundMessage();
                }
            }
        }
    }
}
