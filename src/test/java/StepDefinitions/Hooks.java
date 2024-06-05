package StepDefinitions;

import Formation.Utils.BaseUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;


	public class Hooks  extends BaseUtils {
		public static BaseUtils base = new BaseUtils();
		 @Before
		    public static void setUp() {
			
				base.initializeDriver();
			
		    }

		    @After
		    public static void tearDown() {
		    	base.close();
		    }
}
