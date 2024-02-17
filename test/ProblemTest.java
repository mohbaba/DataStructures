import ProblemAndPersons.Person;
import ProblemAndPersons.Problem;
import ProblemAndPersons.Type;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProblemTest {

    @Test
    public void testPersonCanAddToProblems(){
        Person person = new Person();
        person.addProblem("school fees", Type.FINANCIAL);
        assertEquals(1,person.countProblems());

    }

    @Test
    public void testPersonCanSolveProblem(){
        Person person = new Person();
        person.addProblem("school fees", Type.FINANCIAL);
        person.solveProblem("school fees");

        assertEquals(0,person.countProblems());
    }
}
