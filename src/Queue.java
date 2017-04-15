import java.util.Arrays;

/**
 * Created by stfcr on 4/15/2017.
 */
public class Queue{
    private int[] elements;
    private int size;
    private int front=0, rear=0, numberOfItems=0;

    public Queue(int size){
        this.size=size;
        elements=new int[size];
        Arrays.fill(elements,-1);
    }

    public void insert(int value){
        if(numberOfItems<size)
        {
            elements[numberOfItems]=value;
            numberOfItems++;
        }
        else{
            System.out.print("Queue is full");
        }
    }

    public void remove(){
        if(numberOfItems>0){
            for(int i=front;i<numberOfItems-1;i++)
            {
                elements[i]=elements[i+1];
            }
            numberOfItems--;
            elements[numberOfItems]=-1;
        }
        else{
            System.out.println("Can'r remove from empty queue");
        }
    }

    public void display(){
        for(int i=0;i<numberOfItems;i++)
            System.out.print(elements[i]+" ");
        System.out.println();
    }

    public void peek(){
        System.out.println(elements[front]);
    }

    public int front(){
        if(front!=-1)
            return elements[front];
        return -1;
    }

    public void priorityInsert(int value){
        int i;
        if(numberOfItems ==0){
            insert(value);
        }
        else{
            for(i=numberOfItems;i>=0;i--){
                if(value>elements[i])
                    elements[i+1]=elements[i];
                else break;
            }
            elements[i+1] = value;
            numberOfItems++;
        }
    }

}
