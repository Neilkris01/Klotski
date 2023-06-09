public class Block {
	String name;
	int id;
	int area;
	int height;
	int width;
	Type type;
	
	public enum Type{
		SINGLE,DOUBLE_WIDE,DOUBLE_TALL,QUAD
	}
	
	public Block(int i, int h, int w, String n){
		this.name = n;
		this.height = h;
		this.width = w;
		this.area = h * w;
		this.id = i;
	}
	
	@Override public String toString(){
		return "{ name: " + this.name + " Size:(" + this.width + "," + this.height + ") area: " + this.area + " }";
	}
}
