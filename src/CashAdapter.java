public class CashAdapter{
    public CashInterface cashInterface;
    public  CashAdapter(CashInterface cI){cashInterface=cI;}
    public double giveMoney(double money,String currency)
    {
        return cashInterface.giveCash(money, currency);
    }
    public void takeMoney(double money,String currency)
    {
        cashInterface.takeCash(money, currency);
    }
    public void showAmountOfMoney(){cashInterface.showAmountOfMoney();}
}
