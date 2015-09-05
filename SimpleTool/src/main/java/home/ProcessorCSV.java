package home;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class ProcessorCSV {

	private static List<FamilyMember> parseCSVToBeanList() throws IOException {
		HeaderColumnNameTranslateMappingStrategy<FamilyMember> beanStrategy = new HeaderColumnNameTranslateMappingStrategy<FamilyMember>();
		beanStrategy.setType(FamilyMember.class);
		Map<String, String> columnMapping = new HashMap<String, String>();
		columnMapping.put("Name", "name");
		columnMapping.put("Age", "age");
		columnMapping.put("Sex", "sex");
		columnMapping.put("Birthday", "birthday");
		beanStrategy.setColumnMapping(columnMapping);
		CsvToBean<FamilyMember> csvToBean = new CsvToBean<FamilyMember>();
		CSVReader reader = new CSVReader(new FileReader("src/main/resources/source.csv"));
		List<FamilyMember> members = csvToBean.parse(beanStrategy, reader);
		System.out.println("Print out the plan list object.");
		System.out.println(members);
		return members;
	}

	private static void convertToJson(List list) {
		String json = new Gson().toJson(list);
		System.out.println("Using GSON to convert List to JSON format.");
		System.out.println("JSON string: " + json);
	}

	void readCSV() throws Exception {
		CSVReader reader = new CSVReader(new FileReader("src/main/resources/source.csv"));
		List myEntries = reader.readAll();
		for (int i = 0; i < myEntries.size(); i++) {
			String[] cell = (String[]) myEntries.get(i);
			for (int j = 0; j < cell.length; j++) {
				System.out.println(cell[j]);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main Running for OpenCSV");
		try {
			List<FamilyMember> list = ProcessorCSV.parseCSVToBeanList();
			ProcessorCSV.convertToJson(list);
		} catch (Exception e) {
			System.err.println(e.getMessage());

		}
	}

}
