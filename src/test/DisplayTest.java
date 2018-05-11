package test;

import app.Display;
import app.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DisplayTest {

    @Mock
    private Display mockDisplay;

    private Display display;
    private ByteArrayOutputStream byteArrayOutputStream;

    @Before
    public void setUp() {
        mockDisplay = mock(Display.class);
        display = new Display();
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    public void displayInvalidBarCodeMessage() {
        Mockito.doNothing().when(mockDisplay).displayInvalidBarCodeMessage();
        display.displayInvalidBarCodeMessage();
        assertEquals("Invalid bar-code." + System.getProperty("line.separator"), byteArrayOutputStream.toString());
    }

    @Test
    public void displayProductNotFoundMessage() {
        Mockito.doNothing().when(mockDisplay).displayProductNotFoundMessage();
        display.displayProductNotFoundMessage();
        assertEquals("Product not found." + System.getProperty("line.separator"), byteArrayOutputStream.toString());
    }

    @Test
    public void displayProductInfo() {
        Product testProduct1 = new Product(0, "Water", 1.59);
        Mockito.doNothing().when(mockDisplay).displayProductInfo(testProduct1);
        display.displayProductInfo(testProduct1);
        assertEquals("Water" + System.getProperty("line.separator") + "1,59" + System.getProperty("line.separator"), byteArrayOutputStream.toString());

        Product testProduct2 = new Product(25, "Bread", 1.99);
        Mockito.doNothing().when(mockDisplay).displayProductInfo(testProduct2);
        display.displayProductInfo(testProduct2);
        assertEquals("Water" + System.getProperty("line.separator") + "1,59" + System.getProperty("line.separator") +
                "Bread" + System.getProperty("line.separator") + "1,99" + System.getProperty("line.separator"), byteArrayOutputStream.toString());

        Product testProduct3 = new Product(-99, "Cola", 3.19);
        Mockito.doNothing().when(mockDisplay).displayProductInfo(testProduct3);
        display.displayProductInfo(testProduct3);
        assertEquals("Water" + System.getProperty("line.separator") + "1,59" + System.getProperty("line.separator") +
                "Bread" + System.getProperty("line.separator") + "1,99" + System.getProperty("line.separator") +
                "Cola" + System.getProperty("line.separator") + "3,19" + System.getProperty("line.separator"), byteArrayOutputStream.toString());
    }

    @Test
    public void displayTotalSum() {
        Mockito.doNothing().when(mockDisplay).displayTotalSum();
        display.displayTotalSum();
        assertEquals("TOTAL SUM: 0,00" + System.getProperty("line.separator"),byteArrayOutputStream.toString());
    }

    @After
    public void afterTests() {
        System.setOut(System.out);
    }
}