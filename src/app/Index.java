package app;

import stack.ArrayBoundedStack;
import stack.IStackInterface;

public class Index{
  public static void main (String[] args){
    IStackInterface<String> arr = new ArrayBoundedStack<>();
    arr.push("cat");
    System.out.println(arr.top());
    arr.push("dog");
    System.out.println(arr.top());
    System.out.println(arr.size());
    arr.swapStart();
    System.out.println(arr.top());
    arr.pop();
    System.out.println(arr.top());
  }
}
