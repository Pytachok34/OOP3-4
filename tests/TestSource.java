import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestSource {
    private DollarAdapter adapter;

    @Before
    public void setUp() {
        adapter = new DollarAdapter(1000.0);
    }

    @Test
    public void testGiveCashSuccess() {
        double moneyGiven = adapter.giveCash(100, "Рубли");
        assertEquals(100 / 89.79, moneyGiven, 0.01);
        assertEquals(1000.0 - (100 / 89.79), adapter.amountOfMoney, 0.01);
    }

    @Test
    public void testGiveCashInsufficientFunds() {
        adapter = new DollarAdapter(10.0);
        double moneyGiven = adapter.giveCash(1000, "Рубли");
        assertEquals(0, moneyGiven,0.01);
        assertEquals(10.0, adapter.amountOfMoney, 0.01);
    }

    @Test
    public void testTakeCashNegativeAmount() {
        adapter.takeCash(-100, "Рубли");
        assertEquals(1000.0, adapter.amountOfMoney, 0.01);
    }

    @Test
    public void testTakeCashPositiveAmount() {
        adapter.takeCash(100, "Евро");
        assertEquals(1000.0 + (100 * 1.08), adapter.amountOfMoney, 0.01);
    }

    @Test
    public void testSwitchMoneyRublesToDollars() {
        double converted = adapter.switchMoney(100, "Рубли");
        assertEquals(100 / 89.79, converted, 0.01);
    }

    @Test
    public void testSwitchMoneyEurosToDollars() {
        double converted = adapter.switchMoney(100, "Евро");
        assertEquals(100 * 1.08, converted, 0.01);
    }
}