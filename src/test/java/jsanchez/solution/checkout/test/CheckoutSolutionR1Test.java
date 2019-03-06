package jsanchez.solution.checkout.test;

import befaster.solutions.CHK.CheckoutSolution;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSolutionR1Test {

    private CheckoutSolution checkout;

    @Before
    public void setUp(){
        checkout = new CheckoutSolution();
    }

    @Test
    public void simpleTest(){
        // item A
        assertThat(checkout.checkout("AAA"), equalTo(130));
        assertThat(checkout.checkout("AAAAAA"), equalTo(230));
        assertThat(checkout.checkout("AAAAA"), equalTo(230));
        // item B
        assertThat(checkout.checkout("BB"), equalTo(45));
        assertThat(checkout.checkout("BBBB"), equalTo(90));
        assertThat(checkout.checkout("BBB"), equalTo(75));
        // item C
        assertThat(checkout.checkout("CC"), equalTo(40));
        assertThat(checkout.checkout("CCC"), equalTo(60));
        // item D
        assertThat(checkout.checkout("DD"), equalTo(30));
        assertThat(checkout.checkout("DDDD"),equalTo(60));
    }
}
