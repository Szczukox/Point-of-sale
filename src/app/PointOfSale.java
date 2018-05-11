package app;

import java.util.logging.Logger;

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
                database.dropTable();
                break;
            }
            else if (inputFromScanner.equals("")){
                display.displayInvalidBarCodeMessage();
            } else {
                int idProduct;
                try {
                    idProduct = Integer.parseInt(inputFromScanner);
                } catch (Exception e) {
                    Logger.getLogger(PointOfSale.class.getName()).info("Critical error.");
                    continue;
                }
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
