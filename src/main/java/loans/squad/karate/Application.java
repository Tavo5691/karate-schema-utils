package loans.squad.karate;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.common.base.CaseFormat;

public class Application {
	
	private static List<String> schemaList = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the service response JSON in one-line format:");
		String input = scanner.nextLine();
		scanner.close();
		//String input = "{ \"meta\": { \"method\": true, \"operation\": \"v1/pom/loans/holding/sarasa\", \"paging\": null, \"coso\": 1337655600000 } }";
		//String input = "{ \"meta\": { \"method\": \"PUT\", \"operation\": \"v1/pom/loans/holding/sarasa\", \"paging\": null }, \"data\": { \"loan_contract_account_identification\": { \"backend_id\": null, \"bank_country\": \"AR\", \"bank_key\": \"90000007\", \"account_number\": \"sarasa\" }, \"installment_number\": 0, \"due_date\": null }, \"errors\": [] }";
		//String input = "{ \"data\": { \"amortization_system\": { \"amortization_system_code\": { \"value\": \"NN\", \"list_id\": null, \"list_agency_id\": null }, \"amortization_system_description\": \"FRANCES DIAS PERIODO =30,41666\" }}, \"errors\": [] }";
		//String input = "{ \"meta\": { \"method\": \"GET\", \"operation\": \"v1/pom/loans/I00124100212/details\", \"paging\": null }, \"data\": { \"operational_product\": null, \"bank_sales_product\": { \"bank_sales_product_id\": \"LHEHBC\", \"bank_sales_product_description\": \"LET HIPOTEC\", \"bank_sales_product_version\": null }, \"commitment_capital\": { \"value\": 370000, \"currency_code\": \"NN\", \"currency_code_list_id\": \"MONEDA\", \"currency_code_list_agency_id\": \"007\" }, \"dates\": { \"start_of_term\": 1337655600000, \"date_of_creation\": 1337655600000, \"end_of_term\": 1653274800000 }, \"sales_concept\": \"\", \"contract_manager\": { \"id\": \"241\" }, \"amortization_system\": { \"amortization_system_code\": { \"value\": \"NN\", \"list_id\": null, \"list_agency_id\": null }, \"amortization_system_description\": \"FRANCES DIAS PERIODO =30,41666\" }}, \"errors\": [] }";
		//String input = "{ \"meta\": { \"method\": \"PUT\", \"operation\": \"v1/pom/loans/holding/sarasa\", \"paging\": null }, \"data\": [ { \"loan_contract_account_identification\": { \"backend_id\": null, \"bank_country\": \"AR\", \"bank_key\": \"90000007\", \"account_number\": \"sarasa\" }, \"installment_number\": 0, \"due_date\": null } ], \"errors\": [] }";
		//String input = "{ \"meta\": { \"method\": \"GET\", \"operation\": \"v1/pom/loans/I00124100212/details\", \"paging\": null }, \"data\": [ { \"operational_product\": null, \"bank_sales_product\": { \"bank_sales_product_id\": \"LHEHBC\", \"bank_sales_product_description\": \"LET HIPOTEC\", \"bank_sales_product_version\": null }, \"commitment_capital\": { \"value\": 370000, \"currency_code\": \"NN\", \"currency_code_list_id\": \"MONEDA\", \"currency_code_list_agency_id\": \"007\" }, \"dates\": { \"start_of_term\": 1337655600000, \"date_of_creation\": 1337655600000, \"end_of_term\": 1653274800000 }, \"sales_concept\": \"\", \"contract_manager\": { \"id\": \"241\" }, \"amortization_system\": { \"amortization_system_code\": { \"value\": \"NN\", \"list_id\": null, \"list_agency_id\": null }, \"amortization_system_description\": \"FRANCES DIAS PERIODO =30,41666\" }, \"use_of_founds\": { \"use_of_founds_code\": { \"value\": \"VIV\", \"list_id\": null, \"list_agency_id\": null }, \"use_of_founds_description\": \"COMPRA VIVIENDA UNICA\" }, \"debit_account\": { \"product\": { \"product_id\": null, \"currency\": { \"value\": \"01\", \"list_id\": \"MONEDA\", \"list_agency_id\": \"007\" }, \"nvproduct_id\": { \"subsystem_id\": 2, \"product_id\": \"CA\", \"sub_product_id\": \"GE\", \"modifier_id\": \"01\", \"sector_id\": \"T\" } }, \"account_identification\": { \"backend_id\": null, \"bank_country\": \"AR\", \"bank_key\": \"AR\", \"account_number\": \"241540107816\" } }, \"contract_status_code\": \"NN\", \"collateral_condition\": { \"collateral_condition_code\": { \"value\": \"LHI\", \"list_id\": \"GARANTIA\", \"list_agency_id\": \"310\" }, \"collateral_condition_description\": \"LET-HIP.S/MISMO INMUEBLE (P/VIV.PROPIA)\" }, \"interest_rate_type\": \"Vencida\", \"life_insurance\": { \"life_insurance_code\": { \"value\": \"NN\", \"list_id\": \"SEGURO VIDA\", \"list_agency_id\": \"310\" }, \"life_insurance_description\": \"VENCIDO COBRA DESDE EL 1ER VTO.\" }, \"goods_insurance\": { \"goods_insurance_code\": null, \"goods_insurance_description\": \"SEGURO DE GARANTIA (PREDEFINIDA)\" }, \"commission\": { \"commission_code\": { \"value\": \"NN\", \"list_id\": \"COMISION\", \"list_agency_id\": \"310\" }, \"commission_description\": \"ADELANTADA (COMIS.FIJA Y UNICA)\" }, \"credit_account\": { \"product\": { \"product_id\": null, \"currency\": { \"value\": \"01\", \"list_id\": \"MONEDA\", \"list_agency_id\": \"007\" }, \"nvproduct_id\": { \"subsystem_id\": null, \"product_id\": null, \"sub_product_id\": \"GE\", \"modifier_id\": null, \"sector_id\": \"T\" } }, \"account_identification\": { \"backend_id\": null, \"bank_country\": \"AR\", \"bank_key\": \"90000007\", \"account_number\": \"\" } }, \"amount_accredit\": { \"value\": 0, \"currency_code\": \"NN\", \"currency_code_list_id\": \"MONEDA\", \"currency_code_list_agency_id\": \"007\" }, \"number_of_installments\": { \"number_of_installments\": \"120 MESES\", \"total_number_of_installments\": 120, \"number_of_installments_outstanding\": 120 }, \"interest_rate_value\": 18, \"ref_interest_rate_value\": null, \"index_type\": null, \"calculate_type\": \"Simple\" } ], \"errors\": [] }";
		
		StringBuilder sb = new StringBuilder();
		sb.append("microserviceResponseSchema = { ");
		
		JSONObject inputJson = new JSONObject(input);
		System.out.println("Generating schemas...");
		//Thread.sleep(250); 
		
		Set<String> inputKeys = inputJson.keySet();
		Iterator<String> inputIterator = inputKeys.iterator();
		
		while (inputIterator.hasNext()) {
			String inputKey = inputIterator.next();
			String inputSchemaName = getSchemaName(inputKey);
			
			if (inputJson.get(inputKey) instanceof JSONObject) {
				JSONObject currentObject = inputJson.getJSONObject(inputKey);
				
				Map<String, String> schemaMap = getSchema(currentObject);
				String schema = schemaMap.get("schema");
				schemaList.add(0, inputSchemaName + " = " + schema);
				sb.append(inputKey + ": '#(" + inputSchemaName + ")'");
			} else if (inputJson.get(inputKey) instanceof JSONArray) {
				JSONArray currentArray = inputJson.getJSONArray(inputKey);
				
				if (!currentArray.isEmpty()) {
					JSONObject currentObject = currentArray.getJSONObject(0);
					
					Map<String, String> schemaMap = getSchema(currentObject);
					String schema = schemaMap.get("schema");
					schemaList.add(0, inputSchemaName + " = " + schema);
					sb.append(inputKey + ": '#[] (" + inputSchemaName + ")'");
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

	
	private static Map<String, String> getSchema(JSONObject object) {
		Map<String, String> schemaMap = new HashMap<>();
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
			} else if (value instanceof Integer || value instanceof Long) {
				sb.append("'#number'");
			} else if (value instanceof Boolean) {
				sb.append("'#boolean'");
			} else if (value instanceof JSONObject) {
				String schemaName = getSchemaName(key);
				sb.append("'#(" + schemaName + ")'");
				schemaMap.put("schemaName", schemaName);
				
				Map<String, String> innerSchemaMap = getSchema((JSONObject) value);
				String innerSchema = innerSchemaMap.get("schema");
				schemaList.add(schemaName + " = " + innerSchema);
				
			} else if (value instanceof JSONArray) {
				String schemaName = getSchemaName(key);
				JSONArray currentArray = (JSONArray) value;
				
				if (!currentArray.isEmpty()) {
					JSONObject currentObject = currentArray.getJSONObject(0);
					
					Map<String, String> innerSchemaMap = getSchema(currentObject);
					String schema = innerSchemaMap.get("schema");
					schemaList.add(0, schemaName + " = " + schema);
					sb.append("'#[] (" + schemaName + ")'");
				} else {
					sb.append("[]");
				}
			}
			
			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}
		
		sb.append(" }");
		String schema = sb.toString();
		schemaMap.put("schema", schema);
		return schemaMap;
	}
	
	private static String getSchemaName(String inputKey) {
		return (CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, inputKey)) + "Schema";
	}
	
	private static void printOutput() {
		System.out.println("Output:");
		System.out.println("================================================================================");
		
		for (String string : schemaList) {
			System.out.println(string);
		}
	}
}
