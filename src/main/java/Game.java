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
}
