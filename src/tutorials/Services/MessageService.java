package tutorials.Services;

import tutorials.resources.Result;

public class MessageService {
    public static final String ARRAY = "array";
    final static String ASSOC_ARRAY = "assoc_array";
    final static String LIST = "list";
    public void startMessage(){
        System.out.println("Please enter one of this options below:");
        System.out.println("1) Array(array)");
        System.out.println("2) Multidimensional Array(assoc_array)");
        System.out.println("3) Linked List(list)");
    }

    public void insertMessage(String type) throws Exception{
        switch (type){
            case ARRAY:
                System.out.println("Please enter as many numbers as you want, to stop enter \"finish\".");
                break;
            case ASSOC_ARRAY:
                System.out.println("Please enter as many numbers as you want, to end the element array insertions enter \"finish\", to finish the process enter \"stop\".");
                break;
            case LIST:
                System.out.println("Please enter as many numbers as you want, to stop enter \"stop\".");
                break;
            default:
                throw new Exception("Type provided not valid");
        }
    }
    public void arrayMessages(){
        System.out.println("Please chose one of the options below");
        System.out.println("1) MAX number inserted");
        System.out.println("2) MIN number inserted");
        System.out.println("3) AVERAGE number");
        System.out.println("4) Search for a number");
        System.out.println("5) SUM of all numbers");
        System.out.println("6) Total number count");
        System.out.println("7) Add a new number");
        System.out.println("8) Delete a number");
    }

    public void assocArrayMessages(){
        System.out.println("Please chose one of the options below");
        System.out.println("1) MAX number inserted");
        System.out.println("2) MIN number inserted");
        System.out.println("3) AVERAGE number");
        System.out.println("4) Search for a number");
        System.out.println("5) SUM of all numbers");
        System.out.println("6) Total number count");
        System.out.println("7) Add a new number");
        System.out.println("8) Delete a number");
        System.out.println("9) Find array with the biggest sum");
    }

    public void listMessages(){
        System.out.println("Please chose one of the options below");
        System.out.println("1) MAX number inserted");
        System.out.println("2) MIN number inserted");
        System.out.println("3) AVERAGE number");
        System.out.println("4) Search for a number");
        System.out.println("5) SUM of all numbers");
        System.out.println("6) Total number count");
        System.out.println("7) Add a new number");
        System.out.println("8) Delete a number");
    }

    public void restartMessage(){
        System.out.println("Error happened please restart from the beginning");
    }

    public void retry(){
        System.out.println("Not Accepted please retry");
    }

    public void printByType(String type, Result data){
        switch (type){
            case ARRAY:
                System.out.println("The data you entered is: " + data.arrayData);
                arrayMessages();
                break;
            case ASSOC_ARRAY:
                System.out.println("The data you entered is: " + data.assocArrayData);
                assocArrayMessages();
                break;
            case LIST:
                System.out.println("The data you entered is: " + data.listData);
                listMessages();
                break;
            default:
                System.out.println("No data found");
        }
    }
}
