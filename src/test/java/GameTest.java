import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
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
		edgeSize = 3;
		game = new Game(edgeSize);
	}

	@Test
	public void shouldGameBeInit() throws Exception {
		assertThat(edgeSize, is(notNullValue()));
		assertThat(game, is(notNullValue()));
	}

	@Test
	public void shouldCheckNumbersOfElements() throws Exception {
		assertThat(game.getFields().length, is(edgeSize * edgeSize));
	}

	@Test
	public void shouldFieldsBeInitializeWithZeroValue() throws Exception {
		int numberOfElements = game.getFields().length;
		for (int current = 0; current < numberOfElements; current++) {
			assertThat(game.fields[current], is(0));
		}
	}

	@Test
	public void shouldAddNewElementToFields() throws Exception {
		int index = 1;
		assertThat(game.fields[index], is(0));
		game.addMarker(index, 1);
		assertThat(game.fields[index], is(not(0)));
		assertThat(game.fields[index], is(1));
	}

	@Test(expected = RuntimeException.class)
	public void shouldCheckIfIndexIsCorrect() throws Exception {
		int index = edgeSize * edgeSize + 1;
		game.addMarker(index, 1);
	}

	@Test
	public void shouldNotAllowedToReUseTakenField() throws Exception {
		int index = 3;
		assertThat(game.fields[index], is(0));
		game.addMarker(index, 1);
		assertThat(game.fields[index], is(not(0)));
		assertThat(game.fields[index], is(1));
		game.addMarker(index, 2);
		assertThat(game.fields[index], is(not(2)));
		assertThat(game.fields[index], is(1));
	}

	@Test
	public void shouldBeNoWinner() throws Exception {
		assertThat(game.winner(), is(0));
	}
}
