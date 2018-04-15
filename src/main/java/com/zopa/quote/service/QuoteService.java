package com.zopa.quote.service;

import com.zopa.quote.model.InputParameters;

public class QuoteService {
	
	private CsvService csvService = new CsvService();

	public QuoteService(InputParameters inputParameters) {

		// process csv file and get a list of lenders
		csvService.loadData(inputParameters.getFile());
		
		
	}

}
 