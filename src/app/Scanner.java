package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Scanner {

    private BufferedReader bufferedReader;


    public Scanner() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Load input bar-code and return product ID
     * @return product ID from input stream
     */
    public String readBarCode() {
        String productID = "";
        try {
            productID = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productID;
    }
}
