package readandwrite.tools;

public class IDCardHelper {
	/**
	 * 判断是否是正确的身份证号码
	 * 
	 * @param sfzhm
	 * @return 是否是正确的身份证号码
	 * @throws Exception
	 */
	public boolean checkIdNo(String sfzhm) throws Exception {

		boolean b = false;

		if (sfzhm != null) {

			sfzhm = sfzhm.trim();
			sfzhm = sfzhm.toUpperCase();
			if (sfzhm.length() == 15) {

				String newId = this.zhsfzhm(sfzhm);
				if (newId != null && !"".equals(newId)) {
					if (!this.isDate(newId)) {
						return false;
					}
					b = true;
				}
			} else if (sfzhm.length() == 18) {

				// String newId = this.sfzhmzh(sfzhm);
				String newId = this.checkSfzhm_18(sfzhm);

				if (sfzhm.equals(newId)) {
					if (!this.isDate(newId)) {
						return false;
					}
					b = true;
				}
			}
		}
		return b;
	}

	// 把15位的身份证号码转换为18位
	private String zhsfzhm(String strobject1) {
		int l_l_jym[] = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2,
				1 };
		int l_l_total = 0;
		String last;
		String strobject = "";
		int lastnum = 0;
		int l_l_temp1 = 0;
		if (strobject1 == null) {
			strobject1 = "";
		}
		if (strobject1.length() == 15) {
			strobject = strobject1.substring(0, 6) + "19"
					+ strobject1.substring(6, 15);
			for (int i = 0; i < strobject.length(); i++) {
				try {
					l_l_temp1 = Integer.parseInt(strobject.substring(i, i + 1))
							* l_l_jym[i];
				} catch (Exception ex) {
					return "";
				}

				l_l_total += l_l_temp1;
			}
			l_l_total--;
			lastnum = l_l_total % 11;// 最后一位
			if (lastnum == 0) {
				last = "0";
			} else {
				if (lastnum == 1) {
					last = "X";
				} else {
					last = Integer.toString(11 - lastnum);
				}
			}
			strobject = strobject + last;
			return strobject;
		} else {
			return strobject1;
		}
	}

	/**
	 * 判断身份证号码中的日期是否正确
	 * 
	 * @param sfzhm
	 * @return
	 */
	private boolean isDate(String sfzhm) {
		try {
			int[] iaMonthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30,
					31 };
			int year, month, day;
			// System.out.println(sfzhm);

			if (sfzhm == null) {
				return false;
			}
			if (sfzhm.length() < 18) {
				return false;
			}
			// System.out.println(sfzhm.substring(6,10));
			// System.out.println(sfzhm.substring(10,12));
			// System.out.println(sfzhm.substring(12,14));

			year = Integer.parseInt(sfzhm.substring(6, 10));
			month = Integer.parseInt(sfzhm.substring(10, 12));
			day = Integer.parseInt(sfzhm.substring(12, 14));

			// System.out.println(year);
			// System.out.println(month);
			// System.out.println(day);

			if (year < 1900 || year > 2100) {
				return false;
			}
			if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
				iaMonthDays[1] = 29;
			}
			if (month < 1 || month > 12) {
				return false;
			}
			if (day < 1 || day > iaMonthDays[month - 1]) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * 检查18位身份证号码是否校验身份证是否正确
	 * 
	 * @param strobject1
	 * @return
	 */
	private String checkSfzhm_18(String strobject1) {
		int l_l_jym[] = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2,
				1 };
		int l_l_total = 0;
		String last;
		String strobject = "";
		int lastnum = 0;
		int l_l_temp1 = 0;
		if (strobject1 == null) {
			strobject1 = "";
		}
		if (strobject1.length() == 18) {
			// strobject = strobject1.substring(0,6) + "19" +
			// strobject1.substring(6,15);
			strobject = strobject1.substring(0, 17);
			for (int i = 0; i < strobject.length(); i++) {
				try {
					l_l_temp1 = Integer.parseInt(strobject.substring(i, i + 1))
							* l_l_jym[i];
				} catch (Exception ex) {
					return "";
				}

				l_l_total += l_l_temp1;
			}
			l_l_total--;
			lastnum = l_l_total % 11;// 最后一位
			if (lastnum == 0) {
				last = "0";
			} else {
				if (lastnum == 1) {
					last = "X";
				} else {
					last = Integer.toString(11 - lastnum);
				}
			}
			strobject = strobject + last;
			return strobject;
		} else {
			return "";
		}
	}
	
	
	/**
	 * 转换身份证号码为18位
	 * @param sfzhm
	 * @return 18位身份证号码
	 * @throws Exception
	 */
	public String get18ID(String sfzhm) throws Exception {
		String result = "";
		if(sfzhm==null){
			return result;
		}
		sfzhm  = sfzhm.trim();
		sfzhm = sfzhm.toUpperCase();
		if(sfzhm.length()!=18&&sfzhm.length()!=15){
			return result;
		}
		if(sfzhm.length()==18){
			if(this.checkIdNo(sfzhm)){
				result = sfzhm;
			}
			return result;
		}
		if(sfzhm.length()==15){
			if(this.checkIdNo(sfzhm)){
				sfzhm = this.zhsfzhm(sfzhm);
				result = sfzhm;
			}
			return result;
		}
		if (!this.isDate(result)){
			return "";
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(new IDCardHelper().zhsfzhm("111111111111111"));
	}

	public static String getYear(String sfzhm) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String getMonth(String sfzhm) {
		// TODO Auto-generated method stub
		return null;
	}
}
