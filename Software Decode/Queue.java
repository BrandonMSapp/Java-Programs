//Brandon Sapp
import java.util.ArrayList;
public class Queue {

	ArrayList<Integer> queue = new ArrayList<Integer>(); 
	
		
		public boolean isEmpty()
		{
			return queue == null;
		}
		
		
		public void loadValue(int val)
		{
			queue.add(val);
		}
		
		
		public int nextValue()
		{
			if(queue.isEmpty())
			{
				return -1;
			}
			else
			{
				return queue.remove(0);
			}
		}
		
		
		
		public void normalize()
		{
			int firstval = queue.get(0);
			for (int i = 0; i < queue.size(); i++)
			{
				int realval = queue.get(i);
				int normalizedval = realval - firstval;
				queue.set(i,normalizedval);
			}
		}
		
		
		public int [] peek(int num)
		{
			int [] nextNumValues = new int[num];
			for(int i = 0; i < num; i++)
			{
				nextNumValues[i] = queue.get(i); 
			}
			return nextNumValues;
		}
		
		
		public int size()
		{
			return queue.size();
		}
		
		
		public void next()
		{
			queue.remove(0);
		}
		
		
		public int retrieve(int k)
		{
			return queue.get(k);
		}

}
