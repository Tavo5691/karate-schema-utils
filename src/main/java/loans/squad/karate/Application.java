package loans.squad.karate;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.common.base.CaseFormat;

public class Application {
	
	private static List<String> schemaList = new ArrayList<>();

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Ingrese json a parsear");
//		String input = scanner.nextLine();
//		scanner.close();
		//String input = "{ \"meta\": { \"method\": true, \"operation\": \"v1/pom/loans/holding/sarasa\", \"paging\": null, \"coso\": 1337655600000 } }";
		String input = "{ \"meta\": { \"method\": \"PUT\", \"operation\": \"v1/pom/loans/holding/sarasa\", \"paging\": null }, \"data\": { \"loan_contract_account_identification\": { \"backend_id\": null, \"bank_country\": \"AR\", \"bank_key\": \"90000007\", \"account_number\": \"sarasa\" }, \"installment_number\": 0, \"due_date\": null }, \"errors\": [] }";
		//String input = "{ \"meta\": { \"method\": \"PUT\", \"operation\": \"v1/pom/loans/holding/sarasa\", \"paging\": null }, \"data\": [ { \"loan_contract_account_identification\": { \"backend_id\": null, \"bank_country\": \"AR\", \"bank_key\": \"90000007\", \"account_number\": \"sarasa\" }, \"installment_number\": 0, \"due_date\": null } ], \"errors\": [] }";

		StringBuilder sb = new StringBuilder();
		sb.append("microserviceResponseSchema = { ");
		
		JSONObject inputJson = new JSONObject(input);
		
		Set<String> inputKeys = inputJson.keySet();
		Iterator<String> inputIterator = inputKeys.iterator();
		
		while (inputIterator.hasNext()) {
			String inputKey = inputIterator.next();
			String inputSchemaName = (CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, inputKey)) + "Schema";
			
			if (inputJson.get(inputKey) instanceof JSONObject) {
				JSONObject currentObject = inputJson.getJSONObject(inputKey);
				
				String schema = getSchema(currentObject);
				schemaList.add(inputSchemaName + " = " + schema);
				sb.append(inputKey + ": '#(" + inputSchemaName + ")'");
			} else if (inputJson.get(inputKey) instanceof JSONArray) {
				JSONArray currentArray = inputJson.getJSONArray(inputKey);
				
				if (!currentArray.isEmpty()) {
					JSONObject currentObject = currentArray.getJSONObject(0);
					getSchema(currentObject);
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
		
		System.out.println(responseSchema);
		for (String string : schemaList) {
			System.out.println(string);
		}

	}
	
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
			} else if (value instanceof Integer || value instanceof Long) {
				sb.append("'#number'");
			} else if (value instanceof Boolean) {
				sb.append("'#boolean'");
			} else if (value instanceof JSONObject) {
				String innerSchema = getSchema((JSONObject) value);
				schemaList.add(key + "Schema = " + innerSchema);
			}
			
			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}
		
		sb.append(" }");
		return sb.toString();
	}
}
