/**
 * Created by Jeongwon Park on 2/14/2017.
 */
public class Driver {
    public static void main(String[] args) {
        MyLinkedList test = new MyLinkedList();

        String testString = "I want to test this";
        String testString2 = "I don't want to test this";
        String testString3 = "I am flying!";

        Node newNode = new Node(testString);

        test.insert(testString,newNode);
        test.insert(testString2,newNode);
        test.insert(testString3,newNode);
        System.out.println(test.getSize());

        test.delete(testString3);
        test.delete(testString2);
        test.delete(testString);
        System.out.println(test.getSize());

        System.out.println(test.initTraversal());
        System.out.println(test.traverse());
        System.out.print(newNode.getItem());
        //System.out.println(test.toStringItem(testString));
    }
}
