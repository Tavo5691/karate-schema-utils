package loans.squad.karate;

import java.io.ObjectInputStream.GetField;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.json.JSONObject;

public class Application {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Ingrese json a parsear");
//		String inputJson = scanner.nextLine();
//		scanner.close();
		String inputJson = "{ \"meta\": { \"method\": \"PUT\", \"operation\": \"v1/pom/loans/holding/sarasa\", \"paging\": null, \"coso\": 1337655600000 } }";
		
		JSONObject input = new JSONObject(inputJson);
		
		JSONObject meta = input.getJSONObject("meta");
		
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		
		Set<String> keys = meta.keySet();
		Iterator<String> iterator = keys.iterator();
		
		while (iterator.hasNext()) {
			String key = iterator.next();
			sb.append(key);
			sb.append(": ");
			
			Object value = meta.get(key);
			
			if (value instanceof String) {
				sb.append("'#string'");
			} else if (value.equals(null)) {
				sb.append("'#present'");
			} else if (value instanceof Integer) {
				sb.append("'#number'");
			}
			
			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}
		
		sb.append(" }");
		
		System.out.println(sb.toString());

	}
	
	private static void getSchema() {
		
	}
}
