package app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Printer {

    private OutputStreamWriter outputStreamWriter;
    private DecimalFormat priceFormat;

    public Printer() {
        try {
            this.outputStreamWriter = new OutputStreamWriter(new FileOutputStream("receipt.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        priceFormat = new DecimalFormat("0.00");
    }

    /**
     * Print product names, product prices and total sum of product prices, save it as receipt to file
     * @param products array of products
     * @param totalSum total sum of prices array of products
     */
    public void printReceipt(ArrayList<Product> products, double totalSum) {
        try {
            outputStreamWriter.write("PRODUCTS\t\t\t\t\tPRICE\n");
            outputStreamWriter.write("**************************************************************\n");
            for (Product product : products) {
                outputStreamWriter.write(product.getName() + "\t\t\t\t\t" + priceFormat.format(product.getPrice()) + "\n");
            }
            outputStreamWriter.write("**************************************************************\n");
            outputStreamWriter.write("TOTAL SUM:\t\t\t\t\t" + priceFormat.format(totalSum));
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
