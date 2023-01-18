/******************************************************************************

                            Stack Using LinkedList
		Go to the Program: https://onlinegdb.com/oBcAE0SOn
*******************************************************************************/

import java.util.Scanner;
class Main
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String []args)
    {
        int choice=0;
        int data=0;
        Node root=null;
        do
        {
            System.out.println();
            System.out.println("*********************************Stack***************************");
            System.out.println("Enter 1 to create a Stack: ");
            System.out.println("Enter 2 to push into the Stack: ");
            System.out.println("Enter 3 to pop out of the Stack: ");
            System.out.println("Enter 4 to display the Stack: ");
            System.out.println("Enter 0 to exit the program: ");
            choice=Main.sc.nextInt();
            
            switch(choice)
            {
                case 1: if(root!=null)
                {
                    System.out.println("Stack already created!");
                }
                else
                {
                    System.out.println("Enter data to be pushed: ");
                    data = Main.sc.nextInt();
                    root=create(data);
                    System.out.println("Stack created successfully!");
                } break;
                
                case 2: if(root==null)
                {
                    System.out.println("Stack not created! Create a stack first....");
                }
                else
                {
                    root=push(root);
                } break;
                
                case 3: if(root==null)
                {
                    System.out.println("Stack not created! Create a stack first....");
                }
                else
                {
                    root=pop(root);
                } break;
                
                case 4: if(root==null)
                {
                    System.out.println("Stack not creatd! Create a stack first....");
                }
                else
                {
                    display(root);
                } break;
                
                default: System.out.println("Invalid Choice!");
            }
        } while(choice!=0);
    }
    
    public static Node create(int data)
    {
        return new Node(data);
    }
    
    public static Node push(Node root)
    {
        System.out.println("Enter data to be pushed: ");
        int data = Main.sc.nextInt();
        Node node = new Node(data);
        node.radd=root;
        return node;
    }
    
    public static Node pop(Node root)
    {
        System.out.println("Popped data: "+root.data);
        return root.radd;
    }
    
    public static void display(Node root)
    {
        while(root!=null)
        {
            System.out.print(root.data+" ");
            root=root.radd;
        }
        System.out.println();
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