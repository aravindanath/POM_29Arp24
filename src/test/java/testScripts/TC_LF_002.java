package testScripts;

import org.testng.annotations.Test;
import pages.HomePage;

public class TC_LF_002 extends BaseTest {

    /**
     * @author: Arvind
     * TC_LF_002
     * Validate logging into the Application using invalid credentials
     * (i.e. Invalid email address and Invalid Password)
     */

    @Test
    public void TC_LF_002(){

        HomePage hp = new HomePage(driver);
        hp.navigateToLoginPage();
    }

}
