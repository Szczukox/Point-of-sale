package test;

import app.Printer;
import app.Product;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PrinterTest {

    @Mock
    private Printer mockPrinter;

    @Before
    public void setUp() {
        mockPrinter = mock(Printer.class);
    }

    @Test
    public void printReceipt() {
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product(0, "Water", 1.59));
        products.add(new Product(4, "Ham", 9.99));
        Mockito.doNothing().when(mockPrinter).printReceipt(products, 11.58);
    }
}