package  com.enn.decoration;


import com.enn.decoration.mealSettlement.BaseMeal;
import com.enn.decoration.mealSettlement.EggWithPaper;

/**
 * @author ennish
 * decoration pattern
 */
public class DecorationTest {
	public static void main(String[] args) {
		//0.9 + 1.0
		EggWithPaper f1 = new EggWithPaper(new BaseMeal());

		System.out.println(f1.cost());
	}
}
