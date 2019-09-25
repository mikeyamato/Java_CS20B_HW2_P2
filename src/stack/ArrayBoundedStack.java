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

  @Override
  public void push(T element) throws StackOverflowException {
    if(isFull())
      throw new StackOverflowException("Uh oh, no more space on stack to add.");
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
      throw new StackUnderflowException("Hmmm, nothing in the stack.");
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

  @Override
  public int size(){
    return topIndex + 1;
  }

  public void popSome(int count){
    if (count == -1)
      throw new StackUnderflowException("Uh oh, there is nothing to remove.");
    stack[count] = null;
    topIndex--;
  }

  @Override
  public boolean swapStart(){
    if(stack.length < 2)
      return false;
    T topStackItem = stack[topIndex];
    T nextStackItem = stack[topIndex - 1];
    for (int i = 0; i < 2; i++)
      popSome(topIndex);
    push(topStackItem);
    push(nextStackItem);
    return true;
  }

  @Override
  public String toString(){
    return stack.toString();
  }
}
