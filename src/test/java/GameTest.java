import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Slawomir Leski on 17-11-2018.
 */
public class GameTest {

	private Game game;

	private int edgeSize;

	@Before
	public void setUp() throws Exception {
		edgeSize = ThreadLocalRandom.current().nextInt(3, 10);
		game = new Game(edgeSize);
	}

	@Test
	public void shouldGameBeInit() throws Exception {
		assertThat(edgeSize, is(notNullValue()));
		assertThat(game, is(notNullValue()));
	}

	@Test
	public void shouldCheckNumbersOfElements() throws Exception {
		assertThat(game.getFields(), is(edgeSize * edgeSize));
	}
}
