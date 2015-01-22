import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Data{
	private float price;
	private int normalTime;
	private int deadLine;
	
	public Data(float price, int needTime, int deadLine){
		this.price = price;
		this.normalTime = needTime;
		this.deadLine = deadLine;
	}
	
	public void setPrice(float price){
		this.price = price;
	}
	public float getPrice(){
		return price;
	}
	
	public void setNormalTime(int normalTime){
		this.normalTime = normalTime;
	}
	public int getNormalTime(){
		return normalTime;
	}
	public void setDeadline(int deadline){
		this.deadLine = deadline;
	}
	public int getDeadline(){
		return deadLine;
	}
	public String toString(){
		return "price "+ price + " needTime " + normalTime + " deadLine " + deadLine;
	}
}
public class LazyProgrammer {
	Queue<Data> toDoWorks = null;
	Queue<Data> finishedWorks = null;
	Comparator<Data> deadLineCompare = null;
	Comparator<Data> priceCompare = null;
	private int startTime = 0;
	private float extraCost = 0;
	
	public LazyProgrammer(){
		initialDeadLineCompare();
		initialPriceCompare();
		toDoWorks = new PriorityQueue<Data>(100, deadLineCompare);
		finishedWorks = new PriorityQueue<Data>(100, priceCompare);
	}
	
	private void initialDeadLineCompare(){
		deadLineCompare = new Comparator<Data>(){
			@Override
			public int compare(Data o1, Data o2) {
				int deadline1 = o1.getDeadline();
				int deadline2 = o2.getDeadline();
				if(deadline1 > deadline2) return 1;
				if(deadline1 < deadline2) return -1;
				if(o1.getPrice() > o2.getPrice()) return -1;
				if(o1.getPrice() < o2.getPrice()) return 1;
				return 0;
			}		
		};
	}
	private void initialPriceCompare(){
		priceCompare = new Comparator<Data>(){
			@Override
			public int compare(Data o1, Data o2) {
				float price1 = o1.getPrice();
				float price2 = o2.getPrice();
				if(price1 > price2) return -1;
				if(price1 < price2) return 1;
				return 0;
			}	
		};
	}
	
	public static void main(String[] args){
		LazyProgrammer lazyProgrammer = new LazyProgrammer();
		lazyProgrammer.initialWorkQueue();
		float minCost = lazyProgrammer.getExtraCostForFinishWork();
		System.out.format("Extra cost is: %.2f ", minCost);
	}

	private float getExtraCostForFinishWork() {
		Data toDo = null;
		while(toDoWorks.size() > 0){
			toDo = toDoWorks.poll();
			doWork(toDo);
		}
		return extraCost;
	}
	private void doWork(Data toDo){
		int normalTime = toDo.getNormalTime();
		int deadline = toDo.getDeadline();
		finishedWorks.add(toDo);
		int extraTime = (normalTime + startTime) - deadline;
		if(extraTime > 0){
			Data d = finishedWorks.peek();
			while(extraTime >= d.getNormalTime()){
				extraCost += d.getNormalTime()/d.getPrice();
				startTime -= d.getNormalTime();	
				finishedWorks.poll();
				d = finishedWorks.peek();
				extraTime = (normalTime + startTime) - deadline;
			}
			extraCost += extraTime/d.getPrice();
			startTime = d.getDeadline();
			d.setNormalTime(d.getNormalTime() - extraTime);
		}
		else{
			startTime += toDo.getNormalTime();
		}
	}
	public void initialWorkQueue(){
		Data d1 = new Data(100, 100, 100);
		Data d2 = new Data(200, 100, 100);
		Data d3 = new Data(50, 50, 50);
		Data d4 = new Data(20, 200, 200);
		toDoWorks.add(d1);
		toDoWorks.add(d2);
		toDoWorks.add(d3);
		toDoWorks.add(d4);
		
	}
}


