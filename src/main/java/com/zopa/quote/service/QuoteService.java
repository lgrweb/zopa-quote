package com.zopa.quote.service;

import java.util.Comparator;
import java.util.List;

import com.zopa.quote.exceptions.InvalidCsvFile;
import com.zopa.quote.model.InputParameters;
import com.zopa.quote.model.Lender;

public class QuoteService {

    private final CsvService csvService = new CsvService();

    public QuoteService(final InputParameters inputParameters) throws InvalidCsvFile {

        final List<Lender> avialableLenders = csvService.loadLendersData(inputParameters.getFile());

        sortLendersByRateAndAmount(avialableLenders);

        avialableLenders.forEach((l) -> System.out.println(l));

    }

    /**
     * Sort loaded lenders by rate ASC and amount ASC
     *
     * @param lenders
     */
    private void sortLendersByRateAndAmount(final List<Lender> lenders) {

        final Comparator<Lender> comparator = Comparator.comparing(Lender::getRate, (l1, l2) -> l1.compareTo(l2))
                .thenComparing(Lender::getAmount, (l1, l2) -> l1.compareTo(l2));

        lenders.sort(comparator);
    }

}
