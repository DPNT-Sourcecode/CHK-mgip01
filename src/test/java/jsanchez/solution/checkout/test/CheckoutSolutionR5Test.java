package jsanchez.solution.checkout.test;

import befaster.solutions.CHK.CheckoutSolution;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSolutionR5Test {
    private CheckoutSolution checkout;

    @Before
    public void setUp(){
        checkout = new CheckoutSolution();
    }

    @Test
    public void combinationTest(){
        assertThat(checkout.checkout("STX"), equalTo(45));
        assertThat(checkout.checkout("TXY"), equalTo(45));
        assertThat(checkout.checkout("XSY"), equalTo(45));
        assertThat(checkout.checkout("YZT"), equalTo(45));
        // impossible, depends of the combination of items!!
        //assertThat(checkout.checkout("YZTSYX"), equalTo(90));
        // impossible, the order in the definition is important
        //assertThat(checkout.checkout("YZTSYXX"), equalTo(107));
    }
    @Test
    public void isolateTest(){
        // impossible with the combination offer, because the patter is met!
        //assertThat(checkout.checkout("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),equalTo(853));
        //assertThat(checkout.checkout("X"), equalTo(17));
        //assertThat(checkout.checkout("YZTSYX"), equalTo(90));
        assertThat(checkout.checkout("KK"), equalTo(120));
        assertThat(checkout.checkout("KKKK"), equalTo(240));
        assertThat(checkout.checkout("KKK"), equalTo(190));
    }

    @Test
    public void bigTest() {
        assertThat(checkout.checkout("NNNMM"), equalTo(135));
        assertThat(checkout.checkout("RRRQQ"), equalTo(180));
        assertThat(checkout.checkout("UUUU"), equalTo(120));
        assertThat(checkout.checkout("KK"), equalTo(120));
        assertThat(checkout.checkout("KKKK"), equalTo(240));
        assertThat(checkout.checkout("KKK"), equalTo(190));
        assertThat(checkout.checkout("HHHHHHHHHH"), equalTo(80));
        assertThat(checkout.checkout("HHHHHHHHHHHHHHH"), equalTo(125));
        assertThat(checkout.checkout("P"), equalTo(50));
        //assertThat(checkout.checkout("ABCDEFGHIJKLMNOPQRSTUVWXYZ"), equalTo(853));
        // impossible with the combination offer, because the patter is met!
        //assertThat(checkout.checkout("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),equalTo(853));
        assertThat(checkout.checkout("P"), equalTo(50));
        assertThat(checkout.checkout("SSS"), equalTo(60));
        //assertThat(checkout.checkout("STX"), equalTo(45));
        //assertThat(checkout.checkout("STXSTX"), equalTo(90));
        assertThat(checkout.checkout("SSSZ"), equalTo(81));
        assertThat(checkout.checkout("VVVVV"), equalTo(220));
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
