import java.util.Arrays;

/**
 * Created by stfcr on 4/15/2017.
 */
public class Stack{
    private int[] Elements;
    private int size;
    private int top = -1;

    Stack(int size){
        this.size=size;
        Elements = new int[size];
        Arrays.fill(Elements, -1);
    }

    public void push(int input){
        if(top+1<size){
            Elements[++top]=input;
        }
        else{
            System.out.print("Stack is full");
        }
    }

    public void displayStack(){
        for (int i=0;i<top;i++){
            System.out.print(Elements[i]+" ");
        }
        System.out.println();
    }

    public void pop(){
        if(top>=0){
            Elements[top]=-1;
            top--;
        }
        else{
            System.out.println("The stack is empty");
        }
    }

    public void peek(){
        System.out.println(Elements[top]);
    }

    public int top(){
        if(top>-1)
            return Elements[top];
        return -1;
    }
}
