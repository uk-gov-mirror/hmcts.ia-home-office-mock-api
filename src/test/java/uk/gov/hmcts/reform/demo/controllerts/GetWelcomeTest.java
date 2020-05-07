package uk.gov.hmcts.reform.demo.controllerts;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import uk.gov.hmcts.reform.demo.controllers.WelcomeController;

public class GetWelcomeTest {

    private WelcomeController welcomeController = new WelcomeController();

    @Test
    public void should_get_expected_200_response() {

        final String expected = "Welcome to Home Office API";
        assertThat(welcomeController.welcome()).isNotNull();
        assertThat(welcomeController.welcome().getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
        assertThat(welcomeController.welcome().getBody())
            .isEqualTo(expected);
    }

}
