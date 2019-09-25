package stack;

public class ArrayBoundedStack<T> implements IStackInterface<T> {
  protected final int DEFCAP = 100;
  protected T[] stack;
  protected int topIndex = -1;

  public ArrayBoundedStack(){
    stack = (T[]) new Object[DEFCAP];
  }

  public ArrayBoundedStack(int maxSize){
    stack = (T[]) new Object[maxSize];
  }

  public int size(){
    return stack.length;
  }

  public void popSome(int count){
    if (count == -1)
      new StackUnderflowException("Uh oh, there is nothing to remove.");
    stack[count] = null;
    topIndex--;
  }

  public boolean swapStart(){
    
    return false;
  }

  @Override
  public String toString(){
    return stack.toString();
  }

  @Override
  public void push(T element) throws StackOverflowException {
    if(isFull())
      new StackOverflowException("Uh oh, no more space on stack to add.");
    topIndex++;
    stack[topIndex] = element;
  }

  @Override
  public void pop() throws StackUnderflowException {
    popSome(topIndex);
//    if(isEmpty())
//      new StackUnderflowException("Uh oh, there is nothing to remove.");
//    stack[topIndex] = null;
//    topIndex--;
  }

  @Override
  public T top() throws StackUnderflowException {
    if(isEmpty())
      new StackUnderflowException("Hmmm, nothing in the stack.");
    return stack[topIndex];
  }

  @Override
  public boolean isFull() {
    if(topIndex == (stack.length -1))
      return true;
    return false;
  }

  @Override
  public boolean isEmpty() {
    if (topIndex == -1)
      return true;
    return false;
  }
}
