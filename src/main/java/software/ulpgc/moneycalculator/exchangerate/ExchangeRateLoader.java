package software.ulpgc.moneycalculator.exchangerate;

import software.ulpgc.moneycalculator.currency.Currency;

import java.io.IOException;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to) throws IOException;
}
