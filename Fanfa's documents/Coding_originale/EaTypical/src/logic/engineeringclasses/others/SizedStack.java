package logic.engineeringclasses.others;
import java.util.LinkedList;

//stack class that represent how the back button works
public class SizedStack {

	private static SizedStack instance=null;
	private LinkedList<String> stack;
	private int maxSize=100;
	private int currentSize;
	private String firstPage;
	
	protected SizedStack() {				//contructor of the SINGLETON class
		this.currentSize=0;
		this.stack=new LinkedList<String>();
		this.firstPage="/logic/view/standalone/ChooseRestaurant/ItalianViewCity.fxml";
	}
	
	public void push(String page)			//push of a page in the stack 
	{
		if(instance.currentSize==instance.maxSize+1)
		{
			instance.stack.removeFirst();
			instance.currentSize--;
		}
		instance.stack.addLast(page);
		instance.currentSize++;
	}
	
	public String pop()						//pop of a page from the stack, last inserted or homepage if the stack is empty
	{
		if(instance.currentSize<=1)
		{
			return firstPage;
		}
		currentSize--;
		instance.stack.removeLast();
		return instance.stack.getLast();
	}
	
	public synchronized static SizedStack getSizedStack()	//the getter of the singleton instance
	{
		if(SizedStack.instance==null)
			SizedStack.instance=new SizedStack();
		return instance;
	}	
	
}
