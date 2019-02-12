package Package1;

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
	
	public void remove(){
		int i=1,j=i;
		int flag=0;
		DNode cur=head;
		DNode in=head.next;
		while(cur!=null){
			flag=0;
			j=i+1;
			while(in!=null && flag==0){
				if((cur.data+in.data)==0){
					del_pos(j);
					del_pos(i--);
					in=cur.next;
					flag=1;	
				}
				j++;
				in=in.next;
			}
			cur=cur.next;
			i++;
		}
		
		}
	
}

public class Question1 {

	public static void main(String[] args) {
		DoublyList list=new DoublyList();
		Scanner sc=new Scanner(System.in);
		int num =sc.nextInt();
		while(num!=0){
		list.insert_end(num);
		num=sc.nextInt();
		}
		list.remove();
		list.print();
		sc.close();
	}

}
