package jsanchez.solution.hello.test;

import befaster.solutions.HLO.HelloSolution;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HelloSolutionTest {

    private HelloSolution hello;

    @Before
    public void setUp(){
        hello = new HelloSolution();
    }

    @Test
    public void helloTest(){
        //assertThat(hello.hello("anything"), equalTo("Hello, World!"));
        assertThat(hello.hello("Jordi"), equalTo("Hello, Jordi!"));
    }
}
