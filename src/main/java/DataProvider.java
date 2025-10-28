import java.util.ArrayList;

/// The fundamental unit of abstraction for our project.
///
/// An implementor of DataProvider shall
/// 1. Fetch some system information in its constructor.
/// 2. Implement getName() to return a human-readable name for the data being provided.
/// 3. Implement hasData() to return true if data is available, false otherwise.
/// 4. Implement getData() to return an ArrayList of Strings representing the data.
///
/// This allows the Main class to treat all data providers uniformly.
public interface DataProvider {
    String getName();

    ArrayList<String> getData();

    boolean hasData();
}