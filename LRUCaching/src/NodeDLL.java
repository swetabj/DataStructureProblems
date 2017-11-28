
public class NodeDLL {

	String key = null;
	String value = null;
	NodeDLL next = null;
	NodeDLL prev = null;

	public NodeDLL(String key,String value) {
		this.key = key;
		this.value = value;
		next = null;
		prev = null;
	}
}
