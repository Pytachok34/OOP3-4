public class DollarAdapter implements CashInterface {
    double amountOfMoney;

    public DollarAdapter(double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public double giveCash(double money, String currency) {
        double moneyTmp = money;
        if (money > 0) {
            moneyTmp = switchMoney(money,currency);
            if (amountOfMoney < moneyTmp)
                System.out.println("В кассе нет столько денег");
            else {
                amountOfMoney -= moneyTmp;
                System.out.println("Вы получили " + moneyTmp + " в долларах");
            }
        }
        return moneyTmp;
    }

    private double switchMoney(double money, String currency) {
        double moneyTmp = money;
        if (money > 0) {
            switch (currency) {
                case "Рубли":
                    moneyTmp /= 89.79;
                    break;
                case "Евро":
                    moneyTmp *= 1.08;
                    break;
                default:
                    break;
            }
        }
        return moneyTmp;
    }
    public void takeCash(double money, String currency) {
        if (money <= 0)
            System.out.println("Нельзя положить меньше или равную нулю сумму!");
        else {
            System.out.println("Вы положили " + money + " в " + currency);
            amountOfMoney += switchMoney(money, currency);
        }
    }
    @Override
    public void showAmountOfMoney(){System.out.println("В кассе "+amountOfMoney);}
}
