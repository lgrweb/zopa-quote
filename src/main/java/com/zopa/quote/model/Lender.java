package com.zopa.quote.model;

import com.zopa.quote.util.Converters;

public class Lender {

    private String name;
    private Double rate;
    private Integer amount;

    public Lender(final String name, final String rate, final String amount) {
        this.name = name;
        this.rate = convertRateFromString(rate);
        this.amount = convertAmountFromString(amount);
    }

    private Double convertRateFromString(final String rate) {
        return Converters.stringToDouble(rate);
    }

    private Integer convertAmountFromString(final String amount) {
        return Converters.stringToInteger(amount);
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the rate
     */
    public final Double getRate() {
        return rate;
    }

    /**
     * @param rate
     *            the rate to set
     */
    public final void setRate(final Double rate) {
        this.rate = rate;
    }

    /**
     * @return the amount
     */
    public final Integer getAmount() {
        return amount;
    }

    /**
     * @param amount
     *            the amount to set
     */
    public final void setAmount(final Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Lender [name=" + name + ", rate=" + rate + ", amount=" + amount + "]";
    }

}
