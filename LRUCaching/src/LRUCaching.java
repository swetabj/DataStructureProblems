import java.util.HashMap;
import java.util.Map;

public class LRUCaching {
	int size;
	NodeDLL head;
	NodeDLL tail;

	public LRUCaching(int size) {
		this.size = size;
		head = null;
		tail = null;
	}
	Map<String,NodeDLL> keyHash = new HashMap<>();

	public boolean hasSpaceToAddEleInHashMap(){
		if(keyHash.keySet().size()<size) {
			return true;
		}
		return false;
	}

	public void getFunc(String key) {
		//check if element exists
		if(keyHash.containsKey(key)) {
			NodeDLL tempNode = keyHash.get(key);
			System.out.println("GOT " + tempNode.value);
		}
		else {
			System.out.println("NOT FOUND");
		}

	}

	public void setFunc(String key, String value){
		//check if element exists
		if(keyHash.containsKey(key)) {
			//delete the element in linked list and add at head
			NodeDLL tempNode = keyHash.get(key);
			tempNode.value = value;
			if(tempNode!=head) {
				insertEleAtHead(tempNode);
				keyHash.put(key,tempNode);
				if(tempNode == tail) {
					deleteAtTail();
				}
				else {
					tempNode.next.prev = tempNode.prev;
					tempNode.prev = tempNode.next;
				}
			}
		}
		else {
			//if element doesnot exist in Hashmap and check if the hash map has size

			NodeDLL newNode = new NodeDLL(key,value);
			if(!hasSpaceToAddEleInHashMap()) {
				//delete element at the tail since it will be least recently used
				NodeDLL tempNode = tail;
				keyHash.remove(tempNode.key);
				deleteAtTail();
			}
			insertEleAtHead(newNode);
			keyHash.put(key, newNode);
		}
		System.out.println("SET OK");
	}

	public void insertEleAtHead(NodeDLL newNode) {
		if(head==null) {
			head = newNode;
			tail = head;
		}
		else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}
	public void deleteAtTail() {
		tail = tail.prev;
		tail.next = null;
	}

	public void displayEleInLinkedList() {
		NodeDLL curNode = head;
		while(curNode!=null) {
			System.out.println("key: " + curNode.key + " value: " + curNode.value);
			curNode= curNode.next;
		}
	}

}
