package software.ulpgc.moneycalculator.money;

import software.ulpgc.moneycalculator.currency.Currency;

public record Money(double amount, Currency currency) {
    @Override
    public String toString() {
        return round(amount) + " " + currency;
    }

    private double round(double value) {
        double factor = Math.pow(10, 2);
        value = value * factor;
        return Math.round(value) / factor;
    }
}
