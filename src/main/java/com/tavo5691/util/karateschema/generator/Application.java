package com.tavo5691.util.karateschema.generator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.common.base.CaseFormat;

public class Application {
	
	// The list of schemas to be returned
	private static List<String> schemaList = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the service's response JSON in one-line format:");
		String input = scanner.nextLine();
		scanner.close();
		
		/*
		 * Test input JSONs in order of complexity. For testing uncomment one line and
		 * comment out the lines above
		 */
		//String input = "{ \"meta\": { \"method\": true, \"operation\": \"v1/pom/loans/holding/sarasa\", \"paging\": null, \"coso\": 1337655600000 } }";
		//String input = "{ \"meta\": { \"method\": \"PUT\", \"operation\": \"v1/pom/loans/holding/sarasa\", \"paging\": null }, \"data\": { \"loan_contract_account_identification\": { \"backend_id\": null, \"bank_country\": \"AR\", \"bank_key\": \"90000007\", \"account_number\": \"sarasa\" }, \"installment_number\": 0, \"due_date\": null }, \"errors\": [] }";
		//String input = "{ \"data\": { \"amortization_system\": { \"amortization_system_code\": { \"value\": \"NN\", \"list_id\": null, \"list_agency_id\": null }, \"amortization_system_description\": \"FRANCES DIAS PERIODO =30,41666\" }}, \"errors\": [] }";
		//String input = "{ \"meta\": { \"method\": \"GET\", \"operation\": \"v1/pom/loans/I00124100212/details\", \"paging\": null }, \"data\": { \"operational_product\": null, \"bank_sales_product\": { \"bank_sales_product_id\": \"LHEHBC\", \"bank_sales_product_description\": \"LET HIPOTEC\", \"bank_sales_product_version\": null }, \"commitment_capital\": { \"value\": 370000, \"currency_code\": \"NN\", \"currency_code_list_id\": \"MONEDA\", \"currency_code_list_agency_id\": \"007\" }, \"dates\": { \"start_of_term\": 1337655600000, \"date_of_creation\": 1337655600000, \"end_of_term\": 1653274800000 }, \"sales_concept\": \"\", \"contract_manager\": { \"id\": \"241\" }, \"amortization_system\": { \"amortization_system_code\": { \"value\": \"NN\", \"list_id\": null, \"list_agency_id\": null }, \"amortization_system_description\": \"FRANCES DIAS PERIODO =30,41666\" }}, \"errors\": [] }";
		//String input = "{ \"meta\": { \"method\": \"PUT\", \"operation\": \"v1/pom/loans/holding/sarasa\", \"paging\": null }, \"data\": [ { \"loan_contract_account_identification\": { \"backend_id\": null, \"bank_country\": \"AR\", \"bank_key\": \"90000007\", \"account_number\": \"sarasa\" }, \"installment_number\": 0, \"due_date\": null } ], \"errors\": [] }";
		//String input = "{ \"meta\": { \"method\": \"GET\", \"operation\": \"v1/pom/loans/I00124100212/details\", \"paging\": null }, \"data\": [ { \"operational_product\": null, \"bank_sales_product\": { \"bank_sales_product_id\": \"LHEHBC\", \"bank_sales_product_description\": \"LET HIPOTEC\", \"bank_sales_product_version\": null }, \"commitment_capital\": { \"value\": 370000, \"currency_code\": \"NN\", \"currency_code_list_id\": \"MONEDA\", \"currency_code_list_agency_id\": \"007\" }, \"dates\": { \"start_of_term\": 1337655600000, \"date_of_creation\": 1337655600000, \"end_of_term\": 1653274800000 }, \"sales_concept\": \"\", \"contract_manager\": { \"id\": \"241\" }, \"amortization_system\": { \"amortization_system_code\": { \"value\": \"NN\", \"list_id\": null, \"list_agency_id\": null }, \"amortization_system_description\": \"FRANCES DIAS PERIODO =30,41666\" }, \"use_of_founds\": { \"use_of_founds_code\": { \"value\": \"VIV\", \"list_id\": null, \"list_agency_id\": null }, \"use_of_founds_description\": \"COMPRA VIVIENDA UNICA\" }, \"debit_account\": { \"product\": { \"product_id\": null, \"currency\": { \"value\": \"01\", \"list_id\": \"MONEDA\", \"list_agency_id\": \"007\" }, \"nvproduct_id\": { \"subsystem_id\": 2, \"product_id\": \"CA\", \"sub_product_id\": \"GE\", \"modifier_id\": \"01\", \"sector_id\": \"T\" } }, \"account_identification\": { \"backend_id\": null, \"bank_country\": \"AR\", \"bank_key\": \"AR\", \"account_number\": \"241540107816\" } }, \"contract_status_code\": \"NN\", \"collateral_condition\": { \"collateral_condition_code\": { \"value\": \"LHI\", \"list_id\": \"GARANTIA\", \"list_agency_id\": \"310\" }, \"collateral_condition_description\": \"LET-HIP.S/MISMO INMUEBLE (P/VIV.PROPIA)\" }, \"interest_rate_type\": \"Vencida\", \"life_insurance\": { \"life_insurance_code\": { \"value\": \"NN\", \"list_id\": \"SEGURO VIDA\", \"list_agency_id\": \"310\" }, \"life_insurance_description\": \"VENCIDO COBRA DESDE EL 1ER VTO.\" }, \"goods_insurance\": { \"goods_insurance_code\": null, \"goods_insurance_description\": \"SEGURO DE GARANTIA (PREDEFINIDA)\" }, \"commission\": { \"commission_code\": { \"value\": \"NN\", \"list_id\": \"COMISION\", \"list_agency_id\": \"310\" }, \"commission_description\": \"ADELANTADA (COMIS.FIJA Y UNICA)\" }, \"credit_account\": { \"product\": { \"product_id\": null, \"currency\": { \"value\": \"01\", \"list_id\": \"MONEDA\", \"list_agency_id\": \"007\" }, \"nvproduct_id\": { \"subsystem_id\": null, \"product_id\": null, \"sub_product_id\": \"GE\", \"modifier_id\": null, \"sector_id\": \"T\" } }, \"account_identification\": { \"backend_id\": null, \"bank_country\": \"AR\", \"bank_key\": \"90000007\", \"account_number\": \"\" } }, \"amount_accredit\": { \"value\": 0, \"currency_code\": \"NN\", \"currency_code_list_id\": \"MONEDA\", \"currency_code_list_agency_id\": \"007\" }, \"number_of_installments\": { \"number_of_installments\": \"120 MESES\", \"total_number_of_installments\": 120, \"number_of_installments_outstanding\": 120 }, \"interest_rate_value\": 18, \"ref_interest_rate_value\": null, \"index_type\": null, \"calculate_type\": \"Simple\" } ], \"errors\": [] }";
		
		JSONObject inputJson = new JSONObject(input);
		StringBuilder sb = new StringBuilder();
		
		System.out.println("\nGenerating schemas...\n");
		sb.append("microserviceResponseSchema = { ");
		
		Set<String> inputKeys = inputJson.keySet();
		Iterator<String> inputIterator = inputKeys.iterator();
		
		while (inputIterator.hasNext()) {
			String inputKey = inputIterator.next();
			String inputSchemaName = formatSchemaName(inputKey);
			
			if (inputJson.get(inputKey) instanceof JSONObject) {
				JSONObject currentObject = inputJson.getJSONObject(inputKey);
				String schema = getSchema(currentObject);
				
				sb.append(inputKey + ": '#(" + inputSchemaName + ")'");
				schemaList.add(0, inputSchemaName + " = " + schema);
			} else if (inputJson.get(inputKey) instanceof JSONArray) {
				JSONArray currentArray = inputJson.getJSONArray(inputKey);
				
				if (!currentArray.isEmpty()) {
					JSONObject firstObject = currentArray.getJSONObject(0);
					String schema = getSchema(firstObject);
					
					sb.append(inputKey + ": '#[] (" + inputSchemaName + ")'");
					schemaList.add(0, inputSchemaName + " = " + schema);
				} else {
					sb.append(inputKey + ": []");
				}
			}
			
			
			if (inputIterator.hasNext()) {
				sb.append(", ");
			}
		}
		
		sb.append(" }");
		String responseSchema = sb.toString();
		schemaList.add(0, responseSchema);
		
		printOutput();
	}

	
	/**
	 * Gets the schema given a JSON object
	 * 
	 * @param object the JSON object to parse the schema from
	 * @return the schema for the specified object with the references to other schemas if necessary
	 */
	private static String getSchema(JSONObject object) {
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		
		Set<String> keys = object.keySet();
		Iterator<String> iterator = keys.iterator();
		
		while (iterator.hasNext()) {
			String key = iterator.next();
			sb.append(key);
			sb.append(": ");
			
			Object value = object.get(key);
			
			if (value instanceof String) {
				sb.append("'#string'");
			} else if (value.equals(null)) {
				sb.append("'#present'");
			} else if (value instanceof Integer || value instanceof Long || value instanceof Double) {
				sb.append("'#number'");
			} else if (value instanceof Boolean) {
				sb.append("'#boolean'");
			} else if (value instanceof JSONObject) {
				String schemaName = formatSchemaName(key);
				String innerObjectSchema = getSchema((JSONObject) value);
				
				sb.append("'#(" + schemaName + ")'");
				schemaList.add(schemaName + " = " + innerObjectSchema);
			} else if (value instanceof JSONArray) {
				String schemaName = formatSchemaName(key);
				JSONArray currentArray = (JSONArray) value;
				
				if (!currentArray.isEmpty()) {
					JSONObject firstObject = currentArray.getJSONObject(0);
					String schema = getSchema(firstObject);
					
					sb.append("'#[] (" + schemaName + ")'");
					schemaList.add(0, schemaName + " = " + schema);
				} else {
					sb.append("[]");
				}
			} else {
				System.out.println("WARNING: Value not supported for key: " + key);
			}
			
			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}
		
		sb.append(" }");
		return sb.toString();
	}
	
	/**
	 * Gets the correct schema name for the entered key
	 * 
	 * @param inputKey the key from a key-value pair in a JSON object in snake_case format
	 * @return the schema name for such key in camelCase
	 */
	private static String formatSchemaName(String inputKey) {
		return (CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, inputKey)) + "Schema";
	}
	
	/**
	 * Prints the schema list to the console
	 */
	private static void printOutput() {
		System.out.println("\nOutput:");
		System.out.println("================================================================================");
		
		for (String string : schemaList) {
			System.out.println(string);
		}
	}
}
