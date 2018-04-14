package ro.bestem.doamneajuta.service.model;

import java.util.Map;

/**
 * Created by Andrei-Daniel Ene on 4/15/2018.
 */
public class ExchangeRate {
    private String base;
    private String date;
    private Map rates;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map getRates() {
        return rates;
    }

    public void setRates(Map rates) {
        this.rates = rates;
    }
}
