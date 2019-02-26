package DS;
import java.util.Scanner;

class circular_list{
	DNode head;
	DNode tail;
	public void print(){
		DNode temp=head;
		if(temp==null){
			System.out.println("List is empty");
		}
		else{
			System.out.print(temp.data + " ");
			temp=temp.next;
			while(temp!=head){
				System.out.print(temp.data + " ");
				temp=temp.next;
			}
		}
	}
	public void printAnti(){
		DNode temp=tail;
		if(temp==null){
			System.out.println("List is empty");
		}
		else{
			System.out.print(temp.data + " ");
			temp=temp.previous;
			while(temp!=tail){
				System.out.print(temp.data + " ");
				temp=temp.previous;
			}
		}
	}
	public void insert_end(int data){
		DNode node=new DNode(data);
		DNode temp;
		if(head==null){
			head=node;
			node.next=node;
			node.previous=node;
		}
		else{
			temp=head;
			while(temp.next!=head){
				temp=temp.next;
			}
			temp.next=node;
			node.next=head;
			head.previous=node;
			node.previous=temp;
			tail=node;
		}
	}
	public void insert_beg(int data){
		DNode node=new DNode(data);
		DNode temp;
		if(head==null){
			head=node;
			node.next=node;
			node.previous=node;
		}
		else{
			node.next=head;
			node.previous=head.previous;
			head.previous.next=node;
			head.previous=node;
			head=node;
		}
	}
	public void insert_pos(int data,int pos){
		DNode node=new DNode(data);
		
		int count=1;
		if(head==null){
			insert_beg(data);
		}
		else{
			DNode temp=head;
			while(count!=pos && temp.next!=head ){
				count++;
				temp=temp.next;
			}
			if(temp==tail){
				tail=node;
			}
			node.previous=temp.previous;
			node.next=temp;
			temp.previous.next=node;
			temp.previous=node;
		}
	}
	public void del_beg(){
		DNode temp=head;
		if(temp==null){
			System.out.println("List is empty");
		}
		else if(head.next==head){
			head=null;
			temp.next=null;
			temp.previous=null;
		}
		else{
			head.previous.next=head.next;
			head.next.previous=head.previous;
			head=head.next;
			temp.next=null;
			temp.previous=null;
		}
	}
	public void del_end(){
		DNode temp=head;
		if(temp==null){
			System.out.println("List is empty");
		}
		else if(head.next==head){
			head=null;
			temp.next=null;
			temp.previous=null;
		}
		else{
			temp=head.previous;
			temp.previous.next=temp.next;
			temp.next.previous=temp.previous;
			tail=temp.previous;
			temp.next=null;
			temp.previous=null;
			
		}
	}
	public void del_pos(int pos){
		int count=1;
		DNode temp=head;
		 if(head==null){
			System.out.println("List is empty");
		}
		 else if(pos==1){
				del_beg();
			}
		 else{
			while(count!=pos && temp.next!=head){
			temp=temp.next;
			count++;
			}
			if(temp.next==head &&count!=pos){
				System.out.println("Not enough nodes");
			}
			else{
				temp.previous.next=temp.next;
				temp.next.previous=temp.previous;
				if(temp.next==head){
					tail=temp.previous;
				}
				else if(temp==head){
					head=temp.next;
				}
				temp.next=null;
				temp.previous=null;
			
			}
		 }
	}
	
public void traverse_clock(){
	if(head==null){
		System.out.println("List is empty");
	}
	else{
		DNode temp=head.previous;
		System.out.print(temp.data+" ");
		temp=temp.next;
		while(temp!=tail){
			System.out.print( temp.data+" ");
			temp=temp.next;
		}
	}
	
	
}

public void traverse_anti(){
	if(head==null){
		System.out.println("List is empty");
	}
	else{
		DNode temp=head;
		System.out.print(temp.data+" ");
		temp=temp.previous;
		while(temp!=head){
			System.out.print( temp.data+" ");
			temp=temp.previous;
		}
	}
	
	
}


	
}

public class circular {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		circular_list list=new circular_list();
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		while(num!=0)
		{
			list.insert_beg(num);
			num=sc.nextInt();
		}
		list.print();
		System.out.println();
		list.del_end();list.del_beg();
		list.print();
		System.out.println();
		list.traverse_clock();
		System.out.println();
		list.traverse_anti();
		System.out.println();
		
		
		/*System.out.println("Enter position of node for deletion");
		list.del_pos(sc.nextInt());
		list.print();
		System.out.println();*/
	sc.close();
	}

}
