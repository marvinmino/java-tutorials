package tutorials.Services;

import tutorials.interfaces.Action;
import tutorials.resources.Result;
import java.util.Collections;

public class ArrayService implements Action {

    public ArrayService(){

    }

    public void findMax(Result result, double input){
        Double max = (double) Collections.max(result.arrayData);
        System.out.println("Array max value : " + max);
    }

    public void findMin(Result result, double input){
        Double min = (double) Collections.min(result.arrayData);
        System.out.println("Array min value : " + min);
    }

    public void findAvg(Result result, double input){
        Double avg = (result.arrayData).stream()
                .mapToDouble(val -> (double) val)
                .average()
                .orElse(0.0);

        System.out.println("Array average value : " + avg);
    }

    public void findSum(Result result, double input){
        Double sum = (result.arrayData).stream()
                .mapToDouble(val -> (double) val)
                .sum();

        System.out.println("Array sum value : " + sum);
    }

    public void searchNumber(Result result, double input){
        System.out.println("The element" + input + "is found: " + (result.arrayData).contains(input));
    }

    public void findCount(Result result, double input){
        System.out.println("Total count: " + (result.arrayData).stream().count());
    }

    public void addNumber(Result result, double input){
        (result.arrayData).add(input);
        System.out.println("Element added: " + input);
        System.out.println("Your array is now: " + result.arrayData);
    }

    public void deleteNumber(Result result, double input){
        int index = (result.arrayData).indexOf(input);
        (result.arrayData).remove(index);
        System.out.println("Element removed: " + input);
        System.out.println("Your array is now: " + result.arrayData);
    }
}
