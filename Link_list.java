package DS;
import java.util.Scanner;

 class Node{
	int data;
	Node next;
	
	Node(int data){
		this.data=data;
	}
}

 class link{
	 Node head;
	 
	 public void insertbeg(int data){
		 Node temp=new Node(data);
		 if(head==null){
			 head=temp;
			 temp.next=null;
		 }
		 else{
			 temp.next=head;head=temp;
		 }
		 
	 }
	 public void insertend(int data){
		 Node node=new Node(data);
		 Node temp=head;
		 if(head==null){
			 head=node;
		 }
		 else{
			 while(temp.next!=null){
				 temp=temp.next;
			 }
			 temp.next=node;
		 }
		 
	 }
	 
	 public void insert_posi(int pos,int data){
		 if(pos<0){
			 System.out.println("enter a valid number");
		 }
		 Node node=new Node(data);
		 int count=0;
		 Node temp=head;
		 
		 while(temp!=null){
			 count++;
			 if(count==pos-1){
				 node.next=temp.next;
				 temp.next=node;
				 break;
			 }
			 temp=temp.next;
		 }
		 if(count!=pos-1){
			 System.out.println("Invalid position");
		 }
	 }
	 public void print(){
		 Node temp=head;
		 while(temp!=null){
			 System.out.print(temp.data + " ");
			 temp=temp.next;
		 }
	 }
	 public void print1(){
		 print2(head);
	 }
	 public void print2( Node temp){
		 if(temp!=null){
			 System.out.print(temp.data + " ");
			 print2(temp.next);
		 }
	 }
	 
	 public void mid(){
		 if(head==null){
			 System.out.print("List is empty");
		 }
		 else if(head!=null&& head.next!=null){
		 Node p1=head;
		 Node p2=head.next;
		 while(p2.next!=null && p2!=null){
			 if(p2.next!=null){
				p2= p2.next;
				 p1=p1.next;
				 if(p2.next!=null){
					 p2=p2.next;
				 }
			 }
		 }
		 System.out.println("\n" +p1.data);
	 }
		 else{
			 System.out.print(head.data);
		 }
		 
		 }
	 public void del_beg(){
		 if(head==null){
			 System.out.println("List is empty");
		 }
		 else{
		 Node temp=head;
		 head=head.next;
		 temp.next=null;
		 
	 }
		 }
	 public void del_end(){
		 Node temp=head;
		 Node temp1=head;
		 if(head==null){
			 System.out.println("List is empty");
		 }
		 
		 else{
			 while(temp1.next!=null){
				 temp=temp1;
				 temp1=temp1.next;
			 }
			 if(temp==temp1){
				 head=null;
			 }
			 temp.next=null;
		 }
	 }
	 public void del_pos(int pos){
			int count=1;
			Node temp=head;
			Node temp1=head.next;
			
			 if(head==null){
				System.out.println("List is empty");
			}
			 else if(pos==1){
					del_beg();
				}
			else{
				while(count!=pos-1 && temp!=null){
					temp=temp.next;
					temp1=temp1.next;
					count++;
				}
				if(temp.next==null && temp!=null){
					del_end();
				}
				if(count==pos-1){
				temp.next=temp1.next;
				temp1.next=null;}
				
			}
		}
	 
 }
 
public class Link_list {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		link list=new link();
		list.insertbeg(sc.nextInt());
		list.insertbeg(sc.nextInt());
		list.insertbeg(sc.nextInt());
		list.insertbeg(sc.nextInt());
		list.insertend(sc.nextInt());
		System.out.println("Enter position and data respectively");
		list.insert_posi(sc.nextInt(),sc.nextInt());
		list.print1();
		list.mid();
		System.out.println("Enter the position you want to delete");
		list.del_pos(sc.nextInt());
		list.print();
		sc.close();
	}

}
