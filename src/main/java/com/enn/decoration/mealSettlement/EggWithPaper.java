package  com.enn.decoration.mealSettlement;

import com.enn.decoration.mealSettlement.MealCounter;

public class EggWithPaper implements MealCounter {
	
	MealCounter counter;
	@Override
	public float cost() {
		// TODO Auto-generated method stub
		return 0.9f + counter.cost();
	}
	public EggWithPaper(MealCounter counter) {
		super();
		this.counter = counter;
	}
	public EggWithPaper(){
		this.counter = counter;
	}
}
