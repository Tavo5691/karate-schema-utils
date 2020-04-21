# karate-schema-utils
This app generates JSON Schemas based on an input JSON for use in Karate integration tests.


# How to use

<ul>
  <li>Make sure you have Maven installed</li>
  <li>Clone the repo using:</li>
  <code>git clone https://github.com/Tavo5691/karate-schema-utils</code>
  <li>Open the terminal and go to the downloaded folder</li>
  <li>Use the command:</li>
  <code>mvn clean package</code>
  <li>Now move to the target folder</li>
  <code>cd target/</code>
  <li>Execute the jar file using:</li>
  <code>java -jar karate-schema-utils-1.x.x-SNAPSHOT.jar</code>
  <li>Minify the JSON to be processed using any tool you want</li>
  <code>Recommended: https://codebeautify.org/jsonminifier</code>
</ul>

## Example Input

<code>{"meta":[{"operation":"string","url":"string","paging":0}],"data":[{"name":"string","age":0,"id":"string","pets":[{"name":"string","age":0},{"name":"string","age":0}]}],"errors":[]}</code>

## Example Output

* def petsSchema = { name: '#string', age: '#number' }
* def dataSchema = { pets: '#[] (petsSchema)', name: '#string', id: '#string', age: '#number' }
* def metaSchema = { paging: '#number', operation: '#string', url: '#string' }
* def microserviceResponseSchema = { data: '#[] (dataSchema)', meta: '#[] (metaSchema)', errors: [] }
