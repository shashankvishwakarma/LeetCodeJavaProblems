package dsa.stack;

public class DynamicStack extends CustomStack {

    public DynamicStack() {
        super();
    }

    public DynamicStack(int size) {
        super(size);
    }

    @Override
    public void push(int item) {
        if (isFull()) {
            int[] temp = new int[data.length * 2];

            for (int i = 0; i < data.length - 1; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
        super.push(item);
    }

    public static void main(String[] args) {
        CustomStack stack = new DynamicStack(5);

        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(9);
        stack.push(18);
        stack.push(89);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
