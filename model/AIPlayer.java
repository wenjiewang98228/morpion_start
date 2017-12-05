package morpion.model;

import java.util.Random;

/**
 * 代表AI玩家，目前只会随机下子
 *
 */
public class AIPlayer extends Player {
	/** 用于产生随机数 */
	private Random random;

	public AIPlayer(String n, int m, int id) {
		super(n, m, id);
		this.random = new Random();
	}

	@Override
	public void play(Board b) {
		// TODO 
		do{
			this.move_x = this.random.nextInt(b.getSize());
			this.move_y = this.random.nextInt(b.getSize());
		} while(0 != b.getBlock(this.move_x, this.move_y));
		
		b.setBlock(this.move_x, this.move_y, this.getMark());
	}

	@Override
	public void setMove(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
