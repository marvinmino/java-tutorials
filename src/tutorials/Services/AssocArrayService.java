package tutorials.Services;

import tutorials.interfaces.Action;
import tutorials.resources.Result;

import java.util.ArrayList;
import java.util.Collections;

public class AssocArrayService implements Action {

    public AssocArrayService(){

    }

    public void findMax(Result result, double input){
        ArrayList maxes = new ArrayList();
        ArrayList<ArrayList> data = new ArrayList<>(result.assocArrayData);

        for(int i = 0; i < data.stream().count(); i++){
            maxes.add(Collections.max(data.get(i)));
        }

        Double max = (double) Collections.max(maxes);
        System.out.println("Array max value : " + max);
    }

    public void findMin(Result result, double input){
        ArrayList mins = new ArrayList();
        ArrayList<ArrayList> data = new ArrayList<>(result.assocArrayData);

        for(int i = 0; i < data.stream().count(); i++){
            mins.add(Collections.max(data.get(i)));
        }

        Double max = (double) Collections.max(mins);
        System.out.println("Array min value : " + max);
    }

    public void findAvg(Result result, double input){
        ArrayList avgs = new ArrayList();
        ArrayList<ArrayList> data = new ArrayList<>(result.assocArrayData);

        for(int i = 0; i < data.stream().count(); i++){
            avgs.add(data.get(i).stream()
                    .mapToDouble(val -> (double) val)
                    .average()
                    .orElse(0.0));
        }

        Double avg = avgs.stream()
                .mapToDouble(val -> (double) val)
                .average()
                .orElse(0.0);

        System.out.println("Array average value : " + avg);
    }

    public void findSum(Result result, double input){
        ArrayList sums = new ArrayList();
        ArrayList<ArrayList> data = new ArrayList<>(result.assocArrayData);

        for(int i = 0; i < data.stream().count(); i++){
            sums.add(data.get(i).stream()
                    .mapToDouble(val -> (double) val)
                    .sum());
        }

        Double sum = sums.stream()
                .mapToDouble(val -> (double) val)
                .sum();

        System.out.println("Array sum value : " + sum);
    }

    public void searchNumber(Result result, double input){
        boolean found = false;

        ArrayList<ArrayList> data = new ArrayList<>(result.assocArrayData);

        for(int i = 0; i < data.stream().count(); i++){
            found = data.get(i).contains(input);
            if(found){
                break;
            }
        }
        System.out.println("The element" + input + "is found: " + found);
    }

    public void findCount(Result result, double input){
        ArrayList<ArrayList> data = new ArrayList<>(result.assocArrayData);

        System.out.println("Total count: " + data.stream().count());
    }

    public void addNumber(Result result, double input){
        ArrayList<ArrayList> data = new ArrayList<>(result.assocArrayData);

        for(int i = 0; i < data.stream().count(); i++){
            data.get(i).add(input);
        }
        System.out.println("Element added on all elements: " + input);
        System.out.println("Your array is now: " + data);
    }

    public void deleteNumber(Result result, double input){
        ArrayList<ArrayList> data = new ArrayList<>(result.assocArrayData);

        for(int i = 0; i < data.stream().count(); i++){
            int index = data.get(i).indexOf(input);
            data.get(i).remove(index);
        }

        System.out.println("Element removed from all arrays: " + input);
        System.out.println("Your array is now: " + result.arrayData);
    }

    public void findBiggestSumElement(Result result, double input){
        ArrayList<ArrayList> data = new ArrayList<>(result.assocArrayData);
        int index = -1;
        double maxSum = 0;
        for(int i = 0; i < data.stream().count(); i++){
            double sum = data.get(i).stream()
                    .mapToDouble(val -> (double) val)
                    .sum();
            if(maxSum < sum){
                maxSum = sum;
                index = i;
            }
        }

        System.out.println("Element with max sum is: " + data.get(index));
        System.out.println("The sum is: " + maxSum);
    }
}
