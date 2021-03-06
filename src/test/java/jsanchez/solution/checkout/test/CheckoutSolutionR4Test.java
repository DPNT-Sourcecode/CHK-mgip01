package jsanchez.solution.checkout.test;

import befaster.solutions.CHK.CheckoutSolution;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSolutionR4Test {
    private CheckoutSolution checkout;

    @Before
    public void setUp(){
        checkout = new CheckoutSolution();
    }

    @Test
    public void isolateTest(){
        assertThat(checkout.checkout("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),equalTo(965));
        assertThat(checkout.checkout("X"), equalTo(90));
    }

    @Test
    public void bigTest() {
        assertThat(checkout.checkout("NNNMM"), equalTo(135));
        assertThat(checkout.checkout("RRRQQ"), equalTo(180));
        assertThat(checkout.checkout("UUUU"), equalTo(120));
        assertThat(checkout.checkout("KK"), equalTo(150));
        assertThat(checkout.checkout("HHHHHHHHHH"), equalTo(80));
        assertThat(checkout.checkout("HHHHHHHHHHHHHHH"), equalTo(125));
        assertThat(checkout.checkout("P"), equalTo(50));
        //assertThat(checkout.checkout("ABCDEFGHIJKLMNOPQRSTUVWXYZ"), equalTo(853));
        assertThat(checkout.checkout("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),equalTo(965));
        assertThat(checkout.checkout("P"), equalTo(50));
        assertThat(checkout.checkout("SSS"), equalTo(90));
        //assertThat(checkout.checkout("STX"), equalTo(45));
        //assertThat(checkout.checkout("STXSTX"), equalTo(90));
        assertThat(checkout.checkout("SSSZ"), equalTo(140));
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
    public void simpleItemFTest() {
        assertThat(checkout.checkout("FF"), equalTo(20));
        assertThat(checkout.checkout("FFFF"), equalTo(30));
        assertThat(checkout.checkout("FFFFFF"), equalTo(40));
        assertThat(checkout.checkout("FFFFFFF"), equalTo(50));
        assertThat(checkout.checkout("FFFFFFFF"), equalTo(60));
        assertThat(checkout.checkout("FFFFFFFFF"), equalTo(60));
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
