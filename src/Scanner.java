import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Scanner {

    private BufferedReader bufferedReader;

    public Scanner() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readBarCode() {
        String productID = null;
        try {
            productID = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productID;
    }
}
