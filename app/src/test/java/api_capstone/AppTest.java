/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package api_capstone;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class AppTest {
    @Test public void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
