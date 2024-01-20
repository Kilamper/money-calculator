package software.ulpgc.moneycalculator.exchangerate;

import software.ulpgc.moneycalculator.currency.Currency;

import java.time.LocalDate;

public record ExchangeRate(Currency from, Currency to, LocalDate date, double rate) {
}
