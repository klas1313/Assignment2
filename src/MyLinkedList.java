
/**
 *  MyLinkedList
 *
 * COMP 2140 SECTION D01
 * ASSIGNMENT    Assignment 2
 * @author       Jeongwon Park, 7821584
 * @version      2/17/2017
 *
 * PURPOSE:
 */
public class MyLinkedList {

    private Node firstNode;
    private int size;


    public MyLinkedList() {
//        Provide a default constructor that initializes an empty
//        Linked List, with a size of 0
        // firstNode = new Node(null);
       size = 0;
    }

    public void insert(Object data){
        Node tempNode = new Node(data);
       // System.out.println("The new nodes data is " + tempNode.getItem());
        // Initialize Node only incase of 1st element
        if (firstNode == null) {
            firstNode = tempNode;
           //firstNode.setNext(null);
        }
        else {
            tempNode.setNext(firstNode);
            firstNode = tempNode;
        }

        // increment the number of elements variable
        size++;
    }
//    public Object getHead(){
//        return firstNode.getItem();
//    }
//    public Object getSecond(){
//        Node secondNode = firstNode.getNext();
//        System.out.println("the second nodes item is "+secondNode.getItem());
//        return secondNode.getItem();
//    }
//    public Object getThird(){
//        Node thirdNode = firstNode.getNext().getNext();
//        return thirdNode.getItem();
//    }


    public Object get(int index) {
       // System.out.println("Got into here?");
        if (index < 0) {
            return null; //Here you could implement error handling to handle when someone passes a negative number
        }
        Node currentNode = firstNode;

        if (currentNode != null) {
            currentNode = firstNode;
           // System.out.println(currentNode.getItem());

            //System.out.println("got into the if before for?");

            for (int i=0; i<index; i++) {
               // System.out.println("This the for loop, index is " + i);
                if (currentNode.getNext() == null) {
                    return null;          //This if statement checks if they passed in an index higher than contained currently in the list, if they did, return null; b/c it doesn't exist!
                }
                currentNode = currentNode.getNext();
            }
            return currentNode.getItem(); //If they entered a valid index, will successfully go through for loop finding the last node from the index, return it's value
        }
        return currentNode;  //Return the node

    }


    public Object delete(Object data) {
        System.out.println("inside the delete method");
        System.out.println(data);
        System.out.println();
//        Delete the first instance of a given item, if
//        it exists in the list. Use the equals method of the Object class to compare two
//                Objects. Return a reference to the deleted item, or null if it was not found.
        //Node deletedNode = new Node(newString);
        Node currentNode = firstNode;
        Node prevNode = firstNode;
        if(firstNode != null){

            while(currentNode.getItem() != data){
                //System.out.println(currentNode.getNext());
                if(currentNode.getNext() == null){
                    System.out.println("Got in here?!?!?");      //handles if value not found in list.
                    return false;
                }
                prevNode = currentNode;
                currentNode = currentNode.getNext(); //Iterate to the next node.
            }
            System.out.println("removing the node now");
            Node nodeToReturn = currentNode;
            prevNode.setNext(prevNode.getNext().getNext());
            System.out.println("The node in front of the deleted one is ");
            System.out.println(currentNode.getNext().getItem());
            System.out.println();
            size--;
            return nodeToReturn.getItem();
        }

        return false;
    }

    public int getSize() {
//        Return the number of items in the list. In order to implement this
//        efficiently, you should keep a private instance variable that maintains a count of the
//        number of items in the list.
        return size;
    }

    public Object initTraversal() {
//        Initialize a private instance variable to point to the
//        first Node in the list (or null if the list is empty). Return the item in the first Node (if
//        the list is not empty) or else return null.
        if (firstNode.getNext() != null) {
            return firstNode.getItem();
        } else {
            return null;
        }
    }

    public Object traverse() {
//        Advance the instance variable from initTraversal to the next
//        node in the list (if it exists) or else set it to null if the end of the list has been reached.
//        Return the item pointed to (if the traversal variable is not null) or else return null
        if (firstNode.getNext() != null) {
            return firstNode.getNext().getItem();
        } else {
            return null;
        }

    }

//    public MyLinkedList reverse(){
////        Return a new MyLinkedList object which contains
////        the same items but in reverse order. This method should create a new empty list, and
////        then must call a private, recursive method named addRecursively(...) to add
////        elements to this new list. In other words, your reverse() method will call
////        addRecursively(...) and then addRecursively(...) will call itself a
////        sufficient number of times to correctly fill the new list. The parameters of the recursive
////        method are given as (…) to indicate that the list of parameters is up to you. The return
////                value, if any, is also for you to choose.
//
//    }

//    public String toString(){
////        Return a String representation of the list. Separate each
////        item with an underscore “_”, and enclose the items in braces, e.g. {anItem_78_5.9_z}.
////        This public method must call a private, recursive method named
////        toStringItem(...) to generate the underscore-separated list of items (you may
////                add the braces in the public method though). As was the case for reverse(), the
////        choice of parameters and return type, if any, are up to you.
//
//        //add braces here.
//
//
//    }

    public String toStringItem(Object theItem) {

        theItem = firstNode.getItem();
        String itemToString = theItem.toString();

        if (firstNode == null) {
            return theItem.toString();
        } else {
            return toStringItem(itemToString + "_");
        }
    }


    private class Node {  //need to implement my own. This must store "object"
        Object item;
        Node next;

        public Node(Object insertItem) { //initial Node
            item = insertItem;
            next = null;
        }

        public Node(Object item, Node next) {//in case, I need a specific node
            this.item = item;
            this.next = next;
        }

        public Object getItem() {
            return item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}