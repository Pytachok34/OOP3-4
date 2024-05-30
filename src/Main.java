public class Main {
    public static void main(String[] args) {
        CashInterface dollarAdapter = new DollarAdapter(1000);
        CashInterface euroAdapter = new EuroAdapter(1000);
        double wallet = 0;
        wallet+=dollarAdapter.giveCash(10,"Рубли");
        dollarAdapter.takeCash(wallet,"Евро");
        dollarAdapter.showAmountOfMoney();
    }
}