package morpion.model;

/**
 * 代表人类玩家
 *
 */
public class HumanPlayer extends Player {
	
	public HumanPlayer(String n, int m, int id) {
		super(n, m, id);
	}
	
	@Override
	public void play(Board b) {
		// TODO
		b.setBlock(this.move_x, this.move_y, this.getMark());
	}
	
	@Override
	public void setMove(int x, int y){
		this.move_x = x;
		this.move_y = y;
	}
	
}
