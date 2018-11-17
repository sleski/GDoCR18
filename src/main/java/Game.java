/**
 * Created by Slawomir Leski on 17-11-2018.
 */
public class Game {

	int edgeSize;
	int [] fields;

	public Game(int edgeSize){
		this.edgeSize = edgeSize;
		fields = new int[edgeSize * edgeSize];
	}

	public int[] getFields() {
		return fields;
	}

	public void addMarker(int index, int playerId){
		if(index < 0 || index > (edgeSize * edgeSize)){
			throw new RuntimeException("Out of index!");
		}
		if(fields[index] != 0){
			//field was taken
			return;
		}
		fields[index] = playerId;
		//check if someone wins
	}

	/**
	 *
	 * @return winner id, 0 - no winner.
	 */
	int winner() {
		for (int counter = 0; counter < 4; counter++) {
			if (fields[2 * counter] == fields[2 * counter + 1]) {
				return fields[2 * counter];
			}
		}
		return 0;
	}
}
