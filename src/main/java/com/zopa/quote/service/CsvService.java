package com.zopa.quote.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.zopa.quote.exceptions.InvalidCsvFile;
import com.zopa.quote.model.Lender;

public class CsvService {

    private static final String CVS_SEPARATOR = ",";

    public List<Lender> loadLendersData(final String filePath) throws InvalidCsvFile {

        List<Lender> lenders = new ArrayList<>();

        try {

            final File file = new File(filePath);
            final InputStream inputStream = new FileInputStream(file);
            final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // skip the header of the csv
            lenders = reader.lines().skip(1).map(mapToLender).collect(Collectors.toList());
            reader.close();
            inputStream.close();

        } catch (final IOException e) {
            throw new InvalidCsvFile(InvalidCsvFile.INVALID_FILE);
        }

        return lenders;
    }

    private final Function<String, Lender> mapToLender = (line) -> {

        final String[] row = line.split(CVS_SEPARATOR);

        return new Lender(row[0], row[1], row[2]);
    };
}
