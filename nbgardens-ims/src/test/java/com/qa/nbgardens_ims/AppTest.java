<<<<<<< HEAD
package test.java.com.qa.nbgardens_ims;
=======
package src.test.java.com.qa.nbgardens_ims;
>>>>>>> c8cfc72ff40b2afca401a1f759e16d97d6e29f36

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	System.out.println("Hello");
        assertTrue( true );
    }
}
