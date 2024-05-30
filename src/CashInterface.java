public interface CashInterface {
    double giveCash(double price, String currency);
    void takeCash(double price, String currency);
    void showAmountOfMoney();
}
