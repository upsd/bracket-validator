import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BracketValidatorShould {

    private BracketValidator bracketValidator;

    @BeforeEach
    public void setUp() {
        bracketValidator = new BracketValidator();
    }

    @ParameterizedTest
    @CsvSource({
            "\"\"",
            "[]",
            "{}"
    })
    void return_whether_input_is_valid(String input) {
        Bracket validationResponse = bracketValidator.validate(input == null ? "" : input);


        assertThat(validationResponse, is(Bracket.VALID));
    }

    @ParameterizedTest
    @CsvSource({
            "[[, INVALID",
            "]], INVALID",
            "[[[, INVALID",
            "{, INVALID",
            "([)], INVALID"
    })
    void return_whether_input_is_invalid(String input, Bracket expectedValidationResponse) {
        Bracket validationResponse = bracketValidator.validate(input == null ? "" : input);


        assertThat(validationResponse, is(expectedValidationResponse));
    }
}
