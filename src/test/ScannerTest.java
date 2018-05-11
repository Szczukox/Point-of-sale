package test;

import app.Scanner;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ScannerTest {

    @Mock
    private Scanner mockScanner;

    @Before
    public void setUp() {
        mockScanner = mock(Scanner.class);
    }

    @Test
    public void readBarCode() {
        Mockito.when(mockScanner.readBarCode()).thenReturn("");
    }
}