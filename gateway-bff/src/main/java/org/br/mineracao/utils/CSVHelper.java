package org.br.mineracao.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.br.mineracao.dto.OpportunityDTO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {

    public static ByteArrayInputStream OppotunitiesToCSV(List<OpportunityDTO> oppotunities) {
        final CSVFormat format = CSVFormat.DEFAULT
                .withHeader("ID Proposta", "Cliente", "Preço por tonelada", "Melhor cotação de Moeda", "Toneladas");

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format); {

                for (OpportunityDTO opps : oppotunities) {

                    List<String> data = Arrays.asList(String.valueOf(opps.getProposalId()), opps.getCustomer(),
                            String.valueOf(opps.getPriceTonne()), String.valueOf(opps.getLastDollarQuotation()));

                    csvPrinter.printRecord(data);
                }
                csvPrinter.flush();

                return new ByteArrayInputStream(out.toByteArray());
            }
    } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: "
                    + e.getMessage());
        }
    }
}
