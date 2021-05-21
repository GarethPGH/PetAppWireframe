/**
 * Count: Static class so that CreateJSON can continue to create JSON files,
 * every time button is clicked.
 * 
 */
public class Count {
    public static int counter = 0;

    /** Increments counter to create a global counter variable */
    public static void increment() {
        counter++;
    }
}
