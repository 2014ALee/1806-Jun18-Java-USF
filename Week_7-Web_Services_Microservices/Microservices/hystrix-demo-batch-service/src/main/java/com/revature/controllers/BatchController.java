package com.revature.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Associate;

@RestController
public class BatchController {

	private static Map<String, List<Associate>> trainingBatches = new HashMap<String, List<Associate>>();

	static {
		trainingBatches = new HashMap<String, List<Associate>>();

		List<Associate> associateList = new ArrayList<Associate>();
		Associate associate = new Associate("Algustus", "Lee");
		associateList.add(associate);
		associate = new Associate("Christian", "DeFaria");
		associateList.add(associate);

		trainingBatches.put("TRNG-00000399", associateList);

		associateList = new ArrayList<Associate>();
		associate = new Associate("Yosef", "ElSadaany");
		associateList.add(associate);
		associate = new Associate("Nahom", "Tsadu");
		associateList.add(associate);

		trainingBatches.put("TRNG-00000297", associateList);
	}

	@GetMapping(value = "/{trainingBatchId}/associates")
	public List<Associate> getStudents(@PathVariable String trainingBatchId) {
		System.out.println("Getting Associate details for " + trainingBatchId);

		List<Associate> associateList = trainingBatches.get(trainingBatchId);
		if (associateList == null) {
			associateList = new ArrayList<Associate>();
			Associate associate = new Associate("Not Found", "N/A");
			associateList.add(associate);
		}
		return associateList;
	}
}
