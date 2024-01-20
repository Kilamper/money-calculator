package software.ulpgc.moneycalculator.money;

import software.ulpgc.moneycalculator.currency.Currency;

import java.util.List;

public interface MoneyDialog {
    MoneyDialog define(List<Currency> currencies);
    Money get();
}
