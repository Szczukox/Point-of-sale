package test;

import app.Database;
import app.Product;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseTest {

    @Mock
    private Database mockDatabase;

    private Database database;

    @Before
    public void setUp() {
        mockDatabase = mock(Database.class);
        database = new Database();
    }

    @Test
    public void isInStock() {
        Mockito.when(mockDatabase.isInStock(2)).thenReturn(true);
        assertTrue(database.isInStock(2));

        Mockito.when(mockDatabase.isInStock(0)).thenReturn(true);
        assertTrue(database.isInStock(0));

        Mockito.when(mockDatabase.isInStock(4)).thenReturn(true);
        assertTrue(database.isInStock(4));


        Mockito.when(mockDatabase.isInStock(3333)).thenReturn(false);
        assertFalse(database.isInStock(3333));

        Mockito.when(mockDatabase.isInStock(-56)).thenReturn(false);
        assertFalse(database.isInStock(-56));

        Mockito.when(mockDatabase.isInStock(1000000000)).thenReturn(false);
        assertFalse(database.isInStock(1000000000));
    }

    @Test
    public void getProductFromDatabase() {
        Product testProduct1 = new Product(0, "Water", 1.59);
        Mockito.when(mockDatabase.getProductFromDatabase(0)).thenReturn(testProduct1);
        assertEquals(testProduct1.getId(), database.getProductFromDatabase(0).getId());
        assertEquals(testProduct1.getName(), database.getProductFromDatabase(0).getName());
        assertEquals(testProduct1.getPrice(), database.getProductFromDatabase(0).getPrice(), 0.0);

        Product testProduct2 = new Product(1, "Cheese", 3.99);
        Mockito.when(mockDatabase.getProductFromDatabase(1)).thenReturn(testProduct2);
        assertEquals(testProduct2.getId(), database.getProductFromDatabase(1).getId());
        assertEquals(testProduct2.getName(), database.getProductFromDatabase(1).getName());
        assertEquals(testProduct2.getPrice(), database.getProductFromDatabase(1).getPrice(), 0.0);

        Product testProduct3 = new Product(3, "Pasta", 2.99);
        Mockito.when(mockDatabase.getProductFromDatabase(3)).thenReturn(testProduct3);
        assertEquals(testProduct3.getId(), database.getProductFromDatabase(3).getId());
        assertEquals(testProduct3.getName(), database.getProductFromDatabase(3).getName());
        assertEquals(testProduct3.getPrice(), database.getProductFromDatabase(3).getPrice(), 0.0);

        Mockito.when(mockDatabase.getProductFromDatabase(-88)).thenReturn(null);
        assertNull(database.getProductFromDatabase(-88));

        Mockito.when(mockDatabase.getProductFromDatabase(1000000000)).thenReturn(null);
        assertNull(database.getProductFromDatabase(1000000000));

        Mockito.when(mockDatabase.getProductFromDatabase(11)).thenReturn(null);
        assertNull(database.getProductFromDatabase(11));
    }

    @Test
    public void dropTable() {
        Mockito.doNothing().when(mockDatabase).dropTable();
    }
}