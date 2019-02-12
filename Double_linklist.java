package DS;
import java.util.Scanner;



class DNode{
	int data;
	DNode next;
	DNode previous;
	DNode(int data){
		this.data=data;
		this.previous=null;
		this.next=null;
	}
}

class DoublyList{
	DNode head;
	DNode tail;
	public void insert_beg(int data){
		DNode node=new DNode(data);
		if(head==null){
			head=node;
			tail=node;
		}
		else{
			node.next=head;
			head.previous=node;
			head=node;
		}
	}
	public void insert_end(int data){
		DNode node=new DNode(data);
		if(head==null){
			head=node;
			tail=node;
		}
		else{
		DNode temp=head;
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=node;
		node.previous=temp;
		tail=node;
		}
	}
	public void traverse(){
		if(head==null){
			System.out.println("List is empty");
		}
		else{
			DNode temp=head;
			while(temp!=null){
				System.out.print(temp.data);
				temp=temp.next;
			}
		}
	}
	public void traverseReverse(){
		if(tail==null){
			System.out.println("List is empty");
		}
		else{
			DNode temp=tail;
			while(temp!=null){
				System.out.print(temp.data);
				temp=temp.previous;
			}
		}
	}
	public void mid(){
		if(head==null){
			System.out.println("List is empty");
		}
		else if(head.next==null){
			System.out.println(head.data);
		}
		else{
			DNode p1=head;
			DNode p2=head.next;
			while(p2.next!=null && p2!=null){
				if(p2.next!=null){
					p2=p2.next;
					p1=p1.next;
					if(p2.next!=null){
						p2=p2.next;
					}
				}
			}
			System.out.println(p1.data);
		}
		
	}
	public void del_beg(){
		if(head==null){
			System.out.println("List is empty");
		}
		else{
		DNode temp=head;
		head=temp.next;
		temp.next=null;
	}
		}
	public void del_end(){
		if(head==null){
			System.out.println("List is empty");
		}
		else{
			DNode temp=head;
			if(temp.next==null){
				head=null;	
			}
			else{
				
				while(temp.next.next!=null){
					temp=temp.next;
				}
				temp.next=null;
				tail=temp;
			}
		}
	}
	public void insert_posi(int pos,int data){
		DNode node=new DNode(data);
		DNode temp=head;
		int count=1;
		if(pos==1){
			insert_beg(data);
		}
		else{
		while(count!=pos-1 && temp!=null){
			temp=temp.next;
		}
		if(temp==null){
			System.out.println("Enter valis position not enough elements in list");
		}
		else{
		node.next=temp.next;
		node.previous=temp;
		temp.next=node;
		node.next.previous=node;
	
		}}
		
	}
	public void print(){
		DNode temp=head;
		if(head!=null){
		while(temp!=null){
			System.out.print(temp.data + " ");
			temp=temp.next;
		}
		}
	}
	public void del_pos(int pos){
		int count=1;
		DNode temp=head;
		DNode temp1=head.next;
		
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
				temp1.next=null;
				temp1.previous=null;}
				
			}
	}
	
}

public class Double_linklist {

	public static void main(String[] args) {
		DoublyList list=new DoublyList();
		Scanner sc=new Scanner(System.in);
		list.insert_beg(sc.nextInt());
		list.insert_beg(sc.nextInt());
		list.insert_beg(sc.nextInt());
		list.insert_beg(sc.nextInt());
		list.insert_end(sc.nextInt());
		System.out.println("enter position an data respectively");
		list.insert_posi(sc.nextInt(), sc.nextInt());
		list.print();
		System.out.println();
		list.mid();
		list.del_beg();list.del_end();
		list.print();
		System.out.println("Enter the position you want to delete");
		list.del_pos(sc.nextInt());
		list.print();
		sc.close();
	}

}
