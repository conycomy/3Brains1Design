package store;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {

    @Test
    public void run() {

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
