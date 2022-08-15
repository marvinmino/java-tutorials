package tutorials.interfaces;

import tutorials.resources.Result;

public interface Action {
    public void findMax(Result result, double input);
    public void findMin(Result result, double input);
    public void findCount(Result result, double input);
    public void findAvg(Result result, double input);
    public void findSum(Result result, double input);
    public void searchNumber(Result result, double input);
    public void addNumber(Result result, double input);
    public void deleteNumber(Result result, double input);
}
