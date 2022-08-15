package tutorials.Services;

public class MappingService {
    private static String[] arrayMapping = {
        "findMax",
        "findMin",
        "findAvg",
        "searchNumber",
        "findSum",
        "findCount",
        "addNumber",
        "deleteNumber"
    };

    private static String[] assocArrayMapping = {
        "findMax",
        "findMin",
        "findAvg",
        "searchNumber",
        "findSum",
        "findCount",
        "addNumber",
        "deleteNumber",
        "findBiggestSumElement"
    };

    private static String[] listMapping = {
        "findMax",
        "findMin",
        "findAvg",
        "searchNumber",
        "findSum",
        "findCount",
        "addNumber",
        "deleteNumber",
        "removeTail",
        "removeHead"
    };

    public static String findByTypeAndKey(String type, byte key){
        String method = "";

        switch (type){
            case "array":
                method = arrayMapping[key-1];
                break;
            case "assoc_array":
                method = assocArrayMapping[key-1];
                break;
            case "list":
                method = listMapping[key-1];
                break;
        }

        return method;
    }
}
