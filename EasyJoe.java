import java.util.Queue;
import java.util.LinkedList;

public class EasyJoe {

  private static Queue<Integer> q;

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
	
	q = new LinkedList<Integer>();
	init(n);
	//System.out.println(findSurvivor());
	System.out.println(findSurvivorFormula(n));
	
  }
	//[0, 0, 0, 0, 1]
	
	public static void init(int n){
		for(int i=0; i<n; i++){
			q.offer(i);
		}
	}
	
	//algorithmic starts at 0
	public static int findSurvivor(){
		//indicates first should be saved
		boolean s = false;
		while(q.size() != 1){
			Queue<Integer> tempq = new LinkedList<Integer>();
			/*
			if(s){
				while(q.size() > 1){
					tempq.offer(q.poll());
					q.poll();
				}
			}else{
				tempq.offer(q.poll());
				while(q.size() > 1){
					q.poll();
					tempq.offer(q.poll());
				}
			}
			*/
			if(!s){
				while(q.size()>2){
					tempq.offer(q.poll());
					q.poll();
				}
				if(q.size()==1){
					s = !s;
					tempq.offer(q.poll());
				}else{
					tempq.offer(q.poll());
					q.poll();
				}
			}else{
				while(q.size()>2){
					q.poll();
					tempq.offer(q.poll());
				}
				if(q.size()==1){
					s = !s;
					q.poll();
				}else{
					q.poll();
					tempq.offer(q.poll());
				}
			}
			System.out.println(tempq);
			q = tempq;
		}
		return q.poll();
		
	}
	
	public static int findSurvivorFormula(int n){
		//formulaic assumes it starts at 1
		int i;
		for(i=2; i<n; i*=2){
			
		}
		i/=2;
		System.out.println(i);
		return 1 + (2*(n-i));
	}
  
}
