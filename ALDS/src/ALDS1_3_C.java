import java.io.BufferedReader;
import java.io.InputStreamReader;

class Cell {
	 String data;
	 Cell prev;
	 Cell next;
}

class DLinkedList{
	private Cell first;
	private Cell last;
	
	DLinkedList(){
		this.first = new Cell();
		this.last = new Cell();
		this.first.next = this.last;
		this.last.prev = this.first;
	}
	
	public void insert(String str) {
		Cell cell = new Cell();
		cell.data = str;
		cell.next = this.first.next;
		cell.prev = this.first;
		this.first.next.prev = cell;
		this.first.next = cell;
	}
	
	public void delete(String str) {
		Cell dummy = this.first.next;
		while(dummy.data != null) {
			if(dummy.data.equals(str)) {
				dummy.prev.next = dummy.next;
				dummy.next.prev = dummy.prev;
				return;
			}
			dummy = dummy.next;
		}
	}
	
	public void deleteFirst() {
		this.first.next = this.first.next.next;
		this.first.next.prev = this.first;
	}
	
	public void deleteLast() {
		this.last.prev = this.last.prev.prev;
		this.last.prev.next = this.last;
	}
	
/*	public void printData() {
		PrintWriter out = new PrintWriter(System.out);
		Cell dummy = this.first.next;
		while(true) {
			out.print(dummy.data);
			if(dummy.next.data == null) {
				out.println();
				out.flush();
				return;
			}
			out.print(" ");
			dummy = dummy.next;
			
		}
	}
	}*/
	
	public void printData() {
		Cell c = this.first.next;
		while (c.next != null) {
			System.out.print(c.data + (c.next.next == null ? "\n" : " "));
			c = c.next;
		}
	}
	}

public class ALDS1_3_C {
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
	//	long endTime1;
	//	long endTime2;
	//	long endTime3;
	//	long startTime = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DLinkedList dll = new DLinkedList();
		String[] key = new String[2];
		
		
		try {
		int n = Integer.parseInt(br.readLine());
	//	endTime1 = System.currentTimeMillis();
	//	System.out.println(endTime1 - startTime);
		for(int i = 0; i < n; i++) {
			key = br.readLine().split(" ");

			if(key[0].equals("insert")){
				dll.insert(key[1]);
			} else if (key[0].equals("delete")){
				dll.delete(key[1]);
			} else if (key[0].equals("deleteFirst")){
				dll.deleteFirst();
			} else if (key[0].equals("deleteLast")){
				dll.deleteLast();
			}
			}
	//	endTime2 = System.currentTimeMillis();
	//	System.out.println(endTime2 - startTime);
	} catch (Exception e) {
	//	System.out.println("error");
	} finally {
		dll.printData();
	//	endTime3 = System.currentTimeMillis();
	//	System.out.println(endTime3 - startTime);
	}
	}
	}
