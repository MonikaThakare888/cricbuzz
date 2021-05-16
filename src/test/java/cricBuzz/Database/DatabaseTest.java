package cricBuzz.Database;

import cricBuzz.models.Overs;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class DatabaseTest {
    Database repository = new Database();
    @Test
    void should_read_all_users_from_file() {
        List<Overs> overs = assertDoesNotThrow(() -> repository.getAllOvers());


        List<String> over  = overs.get(0).listOfBall;

        System.out.println("overs"+overs.get(0).listOfBall);
        System.out.println("getListOfBall");
        String[] array = over.toArray(new String[0]);
        System.out.println("array "+Arrays.toString(array));
        String[] getListOfBall =new String[] {};

        System.out.println(" getListOfBall ");
        String[] expectedListOfBallArray = new String[] { "0","WD", "1", "4", "0","0", "W",
                "6", "1", "2", "1", "LB", "0",
                "0", "1", "2", "CO", "4", "4",
                "2", "0", "6", "6", "LBW", "0",
                "6", "4", "0", "WD", "NB", "4", "0", "6"};
        assertArrayEquals(expectedListOfBallArray, array);
    }
}
