import java.util.Arrays;

public class MyStack {
    private int[] storage;//存放栈中元素的数组
    private int capacity;//栈的容量
    private int count;//栈中元素数量
    private static final int GROW_FACTOR = 2;

    //TODO：不带初始容量的构造方法。默认容量为8
    public MyStack() {
        this.capacity = 8;//栈的容量
        this.storage=new int[8];//存放栈中元素的数组
        this.count = 0;//栈中元素数量
    }

    //TODO：带初始容量的构造方法
    public MyStack(int initialCapacity) {
        if (initialCapacity < 1)
            throw new IllegalArgumentException("Capacity too small.");

        this.capacity = initialCapacity;//栈的容量
        this.storage = new int[initialCapacity];//存放栈中元素的数组
        this.count = 0;
    }

    //TODO：入栈
    public void push(int value) {
        if (count == capacity) {//一满就扩容
            ensureCapacity();
        }
        storage[count++] = value;//存放栈中元素的数组
    }

    //TODO：确保容量大小
    private void ensureCapacity() {
        int newCapacity = capacity * GROW_FACTOR;//扩容
        storage = Arrays.copyOf(storage, newCapacity);//存放栈中元素的数组
        capacity = newCapacity;//栈的容量
    }

    //TODO：返回栈顶元素并出栈
    private int pop() {
        count--;
        if (count == -1)
            throw new IllegalArgumentException("Stack is empty.");

        return storage[count];
    }

    //TODO：返回栈顶元素不出栈
    private int peek() {
        if (count == 0){
            throw new IllegalArgumentException("Stack is empty.");
        }else {
            return storage[count-1];
        }
    }

    //TODO：判断栈是否为空
    private boolean isEmpty() {
        return count == 0;
    }

    //TODO：返回栈中元素的个数
    private int size() {
        return count;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(3);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);
        myStack.push(8);
        System.out.println(myStack.peek());//8
        System.out.println(myStack.size());//8
        for (int i = 0; i < 8; i++) {
            System.out.println(myStack.pop());
        }
        System.out.println(myStack.isEmpty());//true
        myStack.pop();//报错：java.lang.IllegalArgumentException: Stack is empty.
    }
}


