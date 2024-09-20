package Interview.Collection.List.LinkedList;

public class CircularLinkedList {
    Node head=null;
    Node tail=null;

    void add(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
            tail.next=head; //sonuncu node ilk node-ile elaqelendirilir
        }
        else{
            tail.next=newNode; //evvelki tail-in next-elementine yeni elementi elave edir
            tail=newNode; //tail-e yeni element elave olunur
            tail.next=head; //dovriliyi temin etmek ucun tail head ile elaqelendirilir
        }
    }
    void printList() {
        if (head == null) return;

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}
