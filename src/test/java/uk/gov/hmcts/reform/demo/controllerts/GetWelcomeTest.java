package uk.gov.hmcts.reform.demo.controllerts;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import uk.gov.hmcts.reform.demo.controllers.RootController;

public class GetWelcomeTest {

    private RootController rootController = new RootController();

    @Test
    public void should_get_expected_200_response() {

        final String expected = "Welcome to Home Office API";
        assertThat(rootController.welcome()).isNotNull();
        assertThat(rootController.welcome().getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
        assertThat(rootController.welcome().getBody())
            .isEqualTo(expected);
    }

}
