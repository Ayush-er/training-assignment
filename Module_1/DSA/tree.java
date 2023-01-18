/******************************************************************************

                             Binary Search Tree
		Go to the program: https://onlinegdb.com/j2ajtPCmC
*******************************************************************************/

import java.util.*;
public class Main
{
    static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
        
        Node root=null;
        int data=0;
        int choice=0;
        
        do{
            System.out.println();
            System.out.println("**************************************Binary Search Tree********************************************");
            System.out.println("Enter 1 to create a Tree");
            System.out.println("Enter 2 to insert data in the Tree");
            System.out.println("Enter 3 to delete data in the Tree");
            System.out.println("Enter 4 to search data in the Tree");
            System.out.println("Enter 5 to view Preorder Traversal of the Tree");
            System.out.println("Enter 6 to view Inorder Traversal of the Tree");
            System.out.println("Enter 7 to view Postorder Traversal of the Tree");
            System.out.println("Enter 0 to exit the program");
            
            choice = Main.sc.nextInt();
            switch(choice)
            {
                case 0: System.out.println("program terminated successfully!"); break;
                case 1: if(root!=null)
                {
                    System.out.println("Tree already exist!");
                }
                else
                {
                    System.out.println("Enter data to be inserted: ");
                    data=Main.sc.nextInt();
                    root=create(data);
                    System.out.println("Tree created successfully!");
                } break;
                
                case 2: if(root==null)
                {
                    System.out.println("Tree not created! Create a Tree first....");
                }
                else
                {
                    System.out.println("Enter data to be inserted: ");
                    data = Main.sc.nextInt();
                    root=add(root, data);
                } break;
                
                case 3: if(root==null)
                {
                    System.out.println("Tree not created! Create a Tree first");
                }
                else
                {
                    System.out.println("Enter data to be deleted: ");
                    data = Main.sc.nextInt();
                    if(delete(root, data)!=null)
                    {
                        System.out.println("Data deleted successfully!");
                    }
                    else
                    {
                        System.out.println("Data doesn't exist!");
                    }
                } break;
                case 4: if(root==null)
                {
                    System.out.println("Tree not created! Create a Tree first");
                }
                else
                {
                    System.out.println("Enter data to be searched: ");
                    data = Main.sc.nextInt();
                    if(search(root, data))
                    {
                        System.out.println("Data found successfully!");
                    }
                    else
                    {
                        System.out.println("Data does'nt exist!");
                    }
                } break;
                
                case 5: if(root==null)
                {
                    System.out.println("Tree not created! Create a Tree first");
                }
                else
                {
                    preorder(root);
                } break;
                
                case 6: if(root==null)
                {
                    System.out.println("Tree not created! Create a Tree first");
                }
                else
                {
                    inorder(root);
                } break;
                
                case 7: if(root==null)
                {
                    System.out.println("Tree not created! Create a Tree first");
                }
                else
                {
                    postorder(root);
                } break;
                
                default : System.out.println("Invalid choice!");
            }
        } while(choice!=0);
	}
	
	public static Node create(int data)
	{
	    Node root = new Node(data);
	    return root;
	}
	
	public static Node add(Node root, int data)
	{
	    if(root==null)
    	    return new Node(data);
    	
    	if(root.data>data)
    	{
    	    root.left=add(root.left, data);
    	}
    	else if(root.data<data)
    	{
    	    root.right=add(root.right, data);
    	}
    	else
    	{
    	    System.out.println("Data already present!");
    	    return root;
    	}
    	return root;
	}
	
	public static void preorder(Node root)
	{
	    if(root==null)
	        return;
	    System.out.println(root.data+" ");
	    preorder(root.left);
	    preorder(root.right);
	}
	
	public static void inorder(Node root)
	{
	    if(root==null)
	        return;
	    
	    inorder(root.left);
	    System.out.println(root.data+" ");
	    inorder(root.right);
	}
	public static void postorder(Node root)
	{
	    if(root==null)
	        return;
	    
	    postorder(root.left);
	    postorder(root.right);
	    System.out.println(root.data+" ");
	}
	
	public static boolean search(Node root, int data)
	{
	    if(root==null)
	        return false;
	    if(root.data==data)
	        return true;
	    return (search(root.left, data) || search(root.right, data));
	}
	
	public static Node delete(Node root, int data)
	{
	    if(root == null)
	        return null;
	    if(root.data>data)
	        root.left=delete(root.left, data);
	    else if(root.data<data)
	        root.right=delete(root.right, data);
	    else
	    {
	        if(root.right==null) return root.left;
	        else if(root.left==null) return root.right;
	        else
	        {
	            Node succ = getSucc(root);
	            root.data=succ.data;
	            root.right=delete(root.right, succ.data);
	        }
	        return root;
	    }
	    return root;
	}
	
	public static Node getSucc(Node root)
	{
	    Node temp = root.right;
	    while(temp.left!=null)
	    {
	        temp=temp.left;
	    }
	    return temp;
	}
	
}


class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data=data;
    }
}
