package jsanchez.solution.checkout.test;

import befaster.solutions.CHK.CheckoutSolution;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSolutionR2Test {

    private CheckoutSolution checkout;

    @Before
    public void setUp(){
        checkout = new CheckoutSolution();
    }

    @Test
    public void simpleTest(){
        // item A
        assertThat(checkout.checkout("AAAAA"), equalTo(200));
        assertThat(checkout.checkout("AAA"), equalTo(130));
        assertThat(checkout.checkout("AAAAAA"), equalTo(250));
        assertThat(checkout.checkout("AAAAAAAA"), equalTo(330));
        // item B
        assertThat(checkout.checkout("BBB"), equalTo(75));
        assertThat(checkout.checkout("BBBB"), equalTo(90));
        assertThat(checkout.checkout("BBBBBBBBB"), equalTo(210));
        // item C
        assertThat(checkout.checkout("CC"), equalTo(40));
        assertThat(checkout.checkout("CCC"), equalTo(60));
        // item D
        assertThat(checkout.checkout("DD"), equalTo(30));
        assertThat(checkout.checkout("DDDD"),equalTo(60));

    }

    @Test
    public void freeTest(){
        assertThat(checkout.checkout("ABEE"),equalTo(130));
    }

    @Test
    public void simpleCombinationItemsTest() {
        assertThat(checkout.checkout("ABCDE"), equalTo(155));
    }

    @Test
    public void combinationItemsTest() {
        assertThat(checkout.checkout("ABAAEACDAABAAEA"), equalTo(525));
    }

    @Test
    public void simpleCombinationSpecialOfferBFreeTest() {
        assertThat(checkout.checkout("BBEE"), equalTo(110));
    }
}



