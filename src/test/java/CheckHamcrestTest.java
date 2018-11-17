import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.notNullValue;


/**
 * Created by Slawomir Leski on 16-11-2018.
 */
public class CheckHamcrestTest {

	@Test
	public void shouldCheckName() throws Exception {
		String name = RandomStringUtils.randomAlphanumeric(10);

		assertThat(name, is(notNullValue()));
	}
}
