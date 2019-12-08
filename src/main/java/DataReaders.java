import utilities.CSV;

import java.util.List;

public class DataReaders {
    public static void main(String[] args) {
        readCSV();
    }

    public static void readCSV(){
        String fileName = "./src/main/resources/UserAccounts.csv";
        List<String[]> records = CSV.get(fileName);

        // Iterating through the list
        for (String[] record: records) {
            for (String field: record) {
                System.out.println(field);
            }
        }
    }
}
