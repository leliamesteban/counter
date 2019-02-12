// https://github.com/gentlecat/counter/tree/master/src/main/java/me/tsukanov/counter/ui
import java.util.HashMap;
import java.util.Map;

public class Application {

    // static is very important!
    // http://www.siafoo.net/snippet/22
    public final static Map<String, Integer> counters = new HashMap<>();
    public static void main(String[] args) {
	System.out.print(counters.isEmpty());
	newCounter("beer"); // CREATE button shows input form and adds a new key-value pair to the map
	updCounter("beer", -3); // clicking on the input or the ADD button updates value to new value or increments it
	newCounter("groceries");
	// clrWhen();
	System.out.print(counters);
    }

    public static void newCounter(String key) {
	if (!counters.containsKey(key)) {
	    counters.put(key, 0);
	}
	// else fail
    }

    public static void updCounter(String key, Integer value) {
	// TODO make value an optional parameter that defaults to 1
	// https://stackoverflow.com/questions/965690/java-optional-parameter
	// consider static factory methods, overloading (declare function again with different params), builders
	// https://stackoverflow.com/questions/222214/managing-constructors-with-many-parameters-in-java/222295#222295

	// value = 1;

	// TODO final value should not be lower than 0
	// https://stackoverflow.com/questions/36316457/stop-decrementing-to-negative-values-when-the-value-of-a-variable-becomes-zero

	// TODO does this assume the key exists? it should because it should only get run when it exists
	counters.replace(key, counters.get(key) + value);
	// TODO remove if condition, uncomment above and add this as git commit : use replace instead of push to remove the if loop
	// https://stackoverflow.com/questions/35297537/difference-between-replace-and-put-for-hashmap
	if (counters.containsKey(key)) {
	    // No inc method function for hash map because immutable so define inline function
	    // https://stackoverflow.com/questions/4277388/increment-an-integer-within-a-hashmap
	    counters.put(key, counters.get(key) + value);
	}
	// else fail
    }

    public static void delCounter(String key) {
	if (!counters.containsKey(key)) {
	    counters.remove(key);
	}
	// else fail
    }

    // TODO turn the function into a loop
    public static void clrWhen() {
	// run this every monday at 00:00
	// TODO persistence
	// constructor that initialises counters map?
	// back up to csv file
	counters.replaceAll((k, v) -> 0);
    }
}
