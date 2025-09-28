class CustomStack {
    private int[] stack;
    private int[] inc;
    private int top;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        inc = new int[maxSize];
        top = -1;
    }

    public void push(int x) {
        if (top < stack.length - 1) {
            stack[++top] = x;
        }
    }

    public int pop() {
        if (top < 0) return -1;
        int res = stack[top] + inc[top];
        if (top > 0) inc[top - 1] += inc[top];
        inc[top] = 0;
        top--;
        return res;
    }

    public void increment(int k, int val) {
        int idx = Math.min(k - 1, top);
        if (idx >= 0) inc[idx] += val;
    }

    public static void main(String[] args) {
        CustomStack st = new CustomStack(3);
        st.push(1);
        st.push(2);
        System.out.println(st.pop()); // 2
        st.push(2);
        st.push(3);
        st.push(4);
        st.increment(5, 100);
        st.increment(2, 100);
        System.out.println(st.pop()); // 103
        System.out.println(st.pop()); // 202
        System.out.println(st.pop()); // 201
        System.out.println(st.pop()); // -1
    }
}
