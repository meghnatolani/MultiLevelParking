package model;

/**@author Meghna Tolani
 * FixedStack : Data structure for stacking vehicles in a parking space.
 * */
public class FixedStack<E>
{
    private E[] stack;
    private int size;
    private int top;

    public FixedStack(int size)
    {
        this.stack = (E[]) new Object[size];
        this.top = -1;
        this.size = size;
    }

    public void push(E obj)
    {
        if (top >= size)
            throw new IndexOutOfBoundsException("Stack size = " + size);
        stack[++top] = obj;
    }

    public E pop()
    {
        if (top < 0) throw new IndexOutOfBoundsException();
        E obj = stack[top--];
        stack[top + 1] = null;
        return obj;
    }

    public int elements()
    {
        return top + 1;
    }

    public boolean checkSpace(){
        if (top == size - 1)
            return false;
        return true;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public boolean isFull(){
        return top==size-1;
    }
}
