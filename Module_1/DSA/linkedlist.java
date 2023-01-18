/******************************************************************************

                                     LinkedList
		Go to the program: https://onlinegdb.com/Tqg5dQAp_
*******************************************************************************/

import java.util.*;
public class Main
{
    static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		int choice;
		Node root=null;
		do
		{
		    System.out.println();
		    System.out.println("***********LinkedList*************");
		    System.out.println("Enter 1 to create a LinkedList");
		    System.out.println("Enter 2 to add data into the LinkedList");
		    System.out.println("Enter 3 to update data into the LinkedList");
		    System.out.println("Enter 4 to delete data in the LinkedList");
		    System.out.println("Enter 5 to search a element in the LinkedList");
		    System.out.println("Enter 6 to sort the LinkedList");
		    System.out.println("Enter 7 to display the LinkedList");
		    System.out.println("Enter 0 to exit the program");
		    choice=Main.sc.nextInt();
		    
		    switch(choice)
		    {
		        case 0: System.out.println("Program Terminated Successfully!");break;
		        case 1: if(root!=null)
		        {
		            System.out.println("List already created!");
		        }
		        else
		        {
		            root = create();
		            if(root!=null)
		            {
		                System.out.println("List created successfully!");
		            }
		            else
		            {
		                System.out.println("List not created!");
		            }
		        }break;
		        
		        case 2: root = add(root); break;
		        
		        case 3: if(update(root))
		        {
		            System.out.println("Data updated successfully!");
		        }
		        else
		        {
		            System.out.println("Update failed!");
		        } break;
		        
		        case 4: root = delete(root); break;
		        case 5: int pos = search(root); 
		        if(pos==0)
		        {
		            System.out.println("Data not present!");
		        }
		        else
		        {
		            System.out.println("Data present at position: "+pos);
		        }
		        break;
		        case 6: sort(root);
		        System.out.println("Enter 7 to view the sorted LinkedList"); break;
		        case 7: display(root); break;
		        default : System.out.println("Invalid choice!");
		           
		    }
		}
		while(choice!=0);
	}
	
	public static Node create()
	{
	    System.out.println("Enter data to be inserted: ");
	    int data=Main.sc.nextInt();
	    Node root = new Node(data);
	    return root;
	}
	
	public static Node add(Node root)
	{
	    if(root==null)
	    {
	        System.out.println("List not created! Create a list first....");
	        return root;
	    }
	        
	    else
	    {
	        System.out.println("Enter Position: ");
	        int pos = Main.sc.nextInt();
	        if(pos>size(root)+1)
	        {
	            System.out.println("Enter valid position! It should be less than "+size(root)+2);
	            return root;
	        }
	        else
	        {
	            System.out.println("Enter Data: ");
	            int data = Main.sc.nextInt();
	            if(pos==1)
	            {
	                Node node = new Node(data);
	                node.radd=root;
	                root=node;
	                return root;
	            }
	            
	            else if(pos==size(root)+1)
	            {
	                Node node = new Node(data);
	                Node tail = tail(root);
	                tail.radd=node;
	                return root;
	            }
	            
	            else
	            {
	                Node node = new Node(data);
	                Node prev=null;
	                Node temp=root;
	                for(int i=1; i<pos; i++)
	                {
	                    prev=temp;
	                    temp=temp.radd;
	                }
	                prev.radd=node;
	                node.radd=temp;
	                return root;
	            }
	        }
	            
	    }
	}
	
	public static boolean update(Node root)
	{
	    if(root==null)
	        return false;
	    else
	    {
	        System.out.println("Enter Position: ");
	        int pos = Main.sc.nextInt();
	        if(pos>size(root))
	        {
	            System.out.println("Enter valid position! It should be less than "+size(root)+1);
	            return false;
	        }
	        else
	        {
	            System.out.println("Enter new data: ");
	            int data = Main.sc.nextInt();
	            if(pos==1)
	            {
	               root.data = data; 
	               return true;
	            }
	            else
	            {
	                Node temp=root;
	                for(int i=1; i<pos; i++)
	                {
	                    temp=temp.radd;
	                }
	                temp.data=data;
	                return true;
	            }
	        }
	    }
	}
	
	public static Node delete(Node root)
	{
	    if(root==null)
	    {
	        System.out.println("Data deletion failed! List not created, Create a list first....");
            return root;
	    }
	        
	    else
	    {
	        System.out.println("Enter Position: ");
	        int pos = Main.sc.nextInt();
	        if(pos>size(root))
	        {
	            System.out.println("Enter valid position! It should be less than "+size(root)+1);
	            System.out.println("Data deletion failed!");
	            return root;
	        }
	        else
	        {
	            int data=-1;
	            if(pos==1)
	            {
	               data=root.data;
	               root = root.radd;
	               System.out.println("Deleted data: "+data);
	               return root;
	            }
	            else
	            {
	                Node temp=root;
	                for(int i=1; i<pos-1; i++)
	                {
	                    temp=temp.radd;
	                }
	                data=temp.radd.data;
	                temp.radd=temp.radd.radd;
	                System.out.println("Deleted data: "+data);
	                return root;
	            }
	        }
	    }
	}
	
	public static int search(Node root)
	{
	    int pos=0;
	    if(root==null)
	    {
	        System.out.println("List not created! Create a list first....");
	        return 0;
	    }
	    else
	    {
	        System.out.println("Enter data: ");
	        int data = Main.sc.nextInt();
	        Node temp = root;
    	    while(temp!=null)
    	    {
    	        pos++;
    	        if(temp.data==data)
    	            return pos;
    	        temp=temp.radd;
    	    }
    	    return 0;
	    }
	}
	
	public static void sort(Node root)
	{
	    if(root==null)
	    {
	        System.out.println("List not created! Create a list first....");
	    }
	    
	    int arr[] = new int[size(root)];
	    Node temp = root;
	    int i=0;
	    while(temp!=null)
	    {
	        arr[i]=temp.data;
	        temp=temp.radd;
	        i++;
	    }
	    Arrays.sort(arr);
	    temp=root;
	    i=0;
	    while(temp!=null)
	    {
	        temp.data=arr[i];
	        temp=temp.radd;
	        i++;
	    }
	}
	
	public static int size(Node root)
	{
	    Node temp = root;
	    int size=0;
	    while(temp!=null)
	    {
	        size++;
	        temp=temp.radd;
	    }
	    return size;
	}
	
	public static Node tail(Node root)
	{
	    Node tail = root;
	    while(tail.radd!=null)
	    {
	        tail=tail.radd;
	    }
	    return tail;
	}
	
	public static void display(Node root)
	{
	    if(root==null)
	    {
	        System.out.println("List not created! Create a list first....");
	    }
	    else
	    {
	        Node temp = root;
    	    while(temp!=null)
    	    {
    	        System.out.print(temp.data+" ");
    	        temp=temp.radd;
    	    }
	    }
	    
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

