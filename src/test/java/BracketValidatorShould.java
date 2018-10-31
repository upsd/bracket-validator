import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BracketValidatorShould {

    @Test
    public void return_valid_for_empty_string() {
        BracketValidator bracketValidator = new BracketValidator();


        Bracket validationResponse = bracketValidator.validate("");


        assertThat(validationResponse, is(Bracket.VALID));
    }
}
