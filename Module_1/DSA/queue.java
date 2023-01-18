/******************************************************************************

                            Queue Using LinkedList
		Go to the program: https://onlinegdb.com/rDNBih6qye
*******************************************************************************/

import java.util.Scanner;
class Main
{
    static Scanner sc = new Scanner(System.in);
    static Node front;
    static Node rear;
    public static void main(String []args)
    {
        int choice=0;
        int data=0;
        do
        {
            System.out.println();
            System.out.println("*********************************Queue***************************");
            System.out.println("Enter 1 to create a Queue: ");
            System.out.println("Enter 2 to Enqueue: ");
            System.out.println("Enter 3 to Dequeue: ");
            System.out.println("Enter 4 to display the Queue: ");
            System.out.println("Enter 0 to exit the program: ");
            choice=Main.sc.nextInt();
            
            switch(choice)
            {
                case 0: System.out.println("Program terminated successfully!"); break;
                
                case 1: if(Main.front!=null)
                {
                    System.out.println("Queue already created!");
                }
                else
                {
                    System.out.println("Enter data to be Enqueued: ");
                    data = Main.sc.nextInt();
                    Main.front=create(data);
                    System.out.println("Queue created successfully!");
                } break;
                
                case 2: if(Main.front==null)
                {
                    System.out.println("Queue not created! Create a Queue first....");
                }
                else
                {
                    Main.rear=enqueue(Main.rear);
                } break;
                
                case 3: if(Main.front==null)
                {
                    System.out.println("Queue not created! Create a Queue first....");
                }
                else
                {
                    Main.front=dequeue(Main.front);
                } break;
                
                case 4: if(Main.front==null)
                {
                    System.out.println("Queue not creatd! Create a Queue first....");
                }
                else
                {
                    display(Main.front);
                } break;
                
                default: System.out.println("Invalid Choice!");
            }
        } while(choice!=0);
    }
    
    public static Node create(int data)
    {
        Main.front=new Node(data);
        Main.rear=front;
        return rear;
    }
    
    public static Node enqueue(Node rear)
    {
        System.out.println("Enter data to be Enqueued: ");
        int data = Main.sc.nextInt();
        Node node = new Node(data);
        rear.radd=node;
        rear=node;
        return rear;
    }
    
    public static Node dequeue(Node front)
    {
        System.out.println("Dequeued data: "+front.data);
        front=front.radd;
        return front;
    }
    
    public static void display(Node front)
    {
        if(front==null)
            return;
        System.out.print(front.data+" ");
        display(front.radd);
    }
    
}

class Node
{
    int data;
    Node radd=null;
    Node(int data)
    {
        this.data=data;
    }
}