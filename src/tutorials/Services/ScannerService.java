package tutorials.Services;

import tutorials.resources.Result;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class ScannerService {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static MessageService messageService = new MessageService();

    public boolean finish = false;

    public String initialScan() {
        String type = SCANNER.next();

        try {
            messageService.insertMessage(type);
        }catch (Exception e){
            messageService.retry();
            type = initialScan();
        }

        return type;
    }

    public Result scanByType(String type) throws Exception{
        Result data = new Result();
        ArrayList arrayData = new ArrayList<>();
        ArrayList assocArrayData = new ArrayList<>();
        LinkedList listData = new LinkedList<>();

        try{
            switch (type){
                case "array":
                    arrayData = scanArray();
                    break;
                case "assoc_array":
                    assocArrayData = scanAssocArray();
                    break;
                case "list":
                    listData = scanList();
                    break;
            }
        } catch(Exception e){
            messageService.retry();
            data = scanByType(type);
        }

        Result.arrayData = arrayData;
        Result.assocArrayData = assocArrayData;
        Result.listData = listData;

        return data;
    }

    private ArrayList scanArray(){
       String input = "";
       ArrayList numbers = new ArrayList<>();
       while(!this.finish){
           input = SCANNER.next();

           if(!input.equals("finish")){
               numbers.add(Double.parseDouble(input));
           } else{
               break;
           }
       }
       return numbers;
    }

    private LinkedList scanList(){
        String input = "";
        LinkedList numbers = new LinkedList<>();

        while(true){
            input = SCANNER.next();

            if(!input.equals("finish")){
                numbers.add(Double.parseDouble(input));
            } else{
                break;
            }
        }
        return numbers;
    }

    private ArrayList scanAssocArray(){
        String input = "";
        ArrayList numbers = new ArrayList<>();
        ArrayList element = new ArrayList();
        while(true){
            input = SCANNER.next();
            if(!input.equals("stop")){
                if(!input.equals("finish")) {
                    element.add(Double.parseDouble(input));
                }
                else{
                    numbers.add(element);
                    element = new ArrayList();
                }
            } else{
                break;
            }

        }
        return numbers;
    }

    public void invokeByType(String type, Result result) throws Exception{
        String className;

        switch (type){
            case "array":
                className = "tutorials.Services.ArrayService";
                break;
            case "assoc_array":
                className = "tutorials.Services.AssocArrayService";
                break;
            case "list":
                className = "tutorials.Services.ListService";
                break;
            default:
                throw new Exception("There was an error");
        }

        try{
            byte key = SCANNER.nextByte();
            double input = scanSecondInput(key);
            Class arrayClass = Class.forName(className);
            Object arrayService = arrayClass.getDeclaredConstructor().newInstance();
            String methodName = MappingService.findByTypeAndKey(type, key);
            Class<?>[] paramTypes = {Result.class, double.class};
            Method action = arrayService.getClass().getMethod(methodName,paramTypes);
            action.invoke(arrayService, result, input);
        } catch(Exception e){
            e.printStackTrace();
            messageService.retry();
            messageService.arrayMessages();
            invokeByType(type, result);
        }
    }

    public double scanSecondInput(byte key){
        double input = 0;

        ArrayList needsSecondInput = new ArrayList();
        needsSecondInput.add((byte) 4);
        needsSecondInput.add((byte) 7);
        needsSecondInput.add((byte) 8);

        if(needsSecondInput.contains(key)){
            System.out.println("Enter here: ");
            input = SCANNER.nextDouble();
        }
        return input;
    }
}
