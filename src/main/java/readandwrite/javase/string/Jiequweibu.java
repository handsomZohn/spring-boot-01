package readandwrite.javase.string;

public class Jiequweibu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jiequweibu();
	}

	public static void jiequweibu(){
		String str = "关于石景山区1家社会公益性就业组织安置张丽军118人申请公益性岗位补贴的请示";
		//System.out.println(str.substring(str.indexOf("等")+1, str.indexOf("人")));
		//System.out.println(str.indexOf("等"));
		if (str.indexOf("等")==-1) {
			//人数
			//1个人
		}else{
			//人数
			System.out.println(str.substring(str.indexOf("等")+1, str.indexOf("人")));
		}
	}
	
	public static void ascii(){
		String str = "关于石景山区11101";//7个
		
	}
}

class DwmdVB{
	
	private String xlfs;

	public String getXlfs() {
		return xlfs;
	}

	public void setXlfs(String xlfs) {
		this.xlfs = xlfs;
	}
	
	public static void main(String[] args) {
		System.out.println(new DwmdVB().getXlfs()==null?"yes":"nono");;
	}
}

