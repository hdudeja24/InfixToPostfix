//Start of StackLinkedList class

public class StackLinkedList

{

    //Basic information required in our nodes for the linked-list/stack -> Reference to node, and data (char)

    public class Node {

        char data; // char data to save in stack

        Node link; // Reference variable, used to point to node

    }


    Node top;


    //Create stack with empty top

    StackLinkedList()

    {

        this.top = null;

    }


    //Start of push function -> Creates new node and inserts char as data

    public void push(char c) // insert at the beginning

    {


        Node temp   = new Node(); //Create new node

        temp.data   = c;          //Save char c as data of the node

        temp.link   = top;        //Links current top and new node

        top         = temp;             //Saves new node in top of the stack

    }


    // Utility function to check if the stack is empty or not

    public boolean isEmpty()

    {

        return top == null; //Returns true if no nodes are found in the linkedlist

    }   //End of isEmpty()


    //Start of top function -> gets current top node in stack

    public int top()

    {

        //If stack is not empty then return current node's data(char)

        if (!isEmpty()) return top.data;


        //If stack is empty return -1

        else return -1;

    }   //End of top()


    //Start of pop function -> removes first node in linked list/ removes top node in stack

    public void pop() // remove at the beginning

    {

        // check for stack underflow

        if (top == null) {

            System.out.print("\nStack Underflow");

            return;

        }


        // update the top pointer to point to the next node

        top = (top).link;

    }   //End of pop()


    //Size function() -> traverse through linkedlist and returns size, if empty returns 0

    public int size ()

    {

        int size = 0;

        Node current = top; //Get top/first node in linked-list/stack


        if (current == null) return size;   //If top node is empty return 0


        //Iterate through the loop until we reach the end of the linked-list/stack

        while (current != null)

        {

            size +=1 ; //Add one to the size for every time we go through the while loop

            current = current.link;

        }

        return size;    //Return size of linked-list/stack

    }   //End of size()


}   //End of StackLinkedList class
