import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springinaction.knights.Knight;


public class SpringInitializer {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("knight.xml");
		Knight knight = (Knight) context.getBean("knight");
		knight.embarkOnQuest();
	}

}
