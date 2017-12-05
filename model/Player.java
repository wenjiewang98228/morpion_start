package morpion.model;

/**
 * 玩家抽象类，包含玩家的基本信息
 *
 */
public abstract class Player {
	/** 玩家的名字，一个固定的代号（1或2） */
	private String name;
	/** 玩家对应的棋子标记（1-O or 2-X） */
	private int mark;
	/** 玩家的ID */
	private int pid;
	/** 玩家的当前下子位置所在的列 */
	protected int move_x;
	/** 玩家的当前下子位置所在的行 */
	protected int move_y;
	
	public Player(String n, int m, int id){
		this.name = n;
		this.mark = m;
		this.pid = id;
	}

	/**
	 * 根据玩家当前下子位置修改棋盘内容
	 * @param b 棋盘引用
	 */
	public abstract void play(Board b);
	
	/**
	 * 设置玩家当前下子位置，在play方法前被调用（AI玩家不需要调用该方法）
	 * @param x 棋盘格列号
	 * @param y 棋盘格行号
	 */
	public abstract void setMove(int x, int y);

	public int getMark() {
		return mark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

}
