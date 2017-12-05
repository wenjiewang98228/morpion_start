package morpion.model;

/**
 * 游戏类，包含棋盘和玩家信息
 *
 */
public class Game {
	/** list of two players */
	private Player[] players;
	/** 游戏棋盘 */
	private Board board;
	/** 当前游戏模式: 1-对战AI, 2-与人对战 */
	private int gameMode;
	/** 游戏是否已结束 */
	private boolean gameEnded;
	/** 当前玩家ID */
	private int current_pid;
	
	public Game(int size, int mode){
		this.gameMode = mode;
		this.gameEnded = false;
		
		// 根据游戏模式初始化玩家
		this.players = new Player[2];
		this.players[0] = new HumanPlayer("1", 1, 0);
		if(this.gameMode == 2){
			this.players[1] = new HumanPlayer("2", 2, 1);
		}
		else if(this.gameMode == 1){
			this.players[1] = new AIPlayer("2", 2, 1);
		}
		
		this.current_pid = 0;  // 设为第一个玩家
		
		this.board = new Board(size);
	}
	
	/**
	 * 检查当前棋盘状态，看是否已经产生赢家
	 * @return 返回-1:游戏继续； 返回-2:平局；否则，返回胜利玩家对应的ID（0或1）
	 */
	public int checkWinner(){
		int mark = board.checkConnectedMark();
		if(mark == -1) {
			if(board.isFull()) {
				return -2;
			}
			else { 
				return -1;
			}
		}
		return this.getPlayerByMark(mark).getPid();
	}
	
	/**
	 * 结束当前游戏，显示结果
	 * @param w_id 获胜玩家的ID，或者-2（平局）
	 */
	public void endGame(int w_id){
		if(w_id == -2){
			System.out.println("Draw game");
		}
		else{
			// say congrats to the winner
			System.out.println("Player "+this.players[w_id].getName()+" wins!");
		}
		// end the game
		this.gameEnded = true;
	}
	
	/**
	 * 返回当前玩家对象
	 * @return 返回当前玩家对象
	 */
	public Player getCurrentPlayer(){
		return this.players[this.current_pid];
	}
	
	/**
	 * 根据玩家对应的标记号返回玩家对象
	 * @param mark 标记编号（1或2）
	 * @return 玩家对象
	 */
	public Player getPlayerByMark(int mark){
		for(Player p : this.players){
			if(p.getMark() == mark)
				return p;
		}
		return null;
	}
	
	/**
	 * 根据玩家ID返回玩家对象
	 * @param w_id 玩家ID
	 * @return 玩家对象
	 */
	public Player getPlayerById(int w_id){
		return this.players[w_id];
	}
	
	/**
	 * 通过修改当前玩家ID切换当前玩家
	 */
	public void switchPlayer(){
		this.current_pid = this.current_pid == 1?0:1;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public boolean isGameEnded() {
		return gameEnded;
	}

	public void setGameEnded(boolean gameEnded) {
		this.gameEnded = gameEnded;
	}

	public int getGameMode() {
		return gameMode;
	}

	public void setGameMode(int gameMode) {
		this.gameMode = gameMode;
	}
	
	
	
}
