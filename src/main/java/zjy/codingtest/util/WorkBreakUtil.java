package zjy.codingtest.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * work Break Util
 * @author zhaojy
 * @date  2020年6月7日
 */
public class WorkBreakUtil {
	
	/**
	 * wordBreak
	 * @param s		sentence
	 * @param dict	dictionary
	 * @return
	 */
	public List<String> wordBreak(String s, Set<String> dict) {
		List<String> list = new ArrayList<String>();
		List<String> ret = new ArrayList<String>();
		rec(s, dict, list, ret);
		return ret;
	}

	/**
	 * recursive call
	 * @param s		sentence 
	 * @param dict	dictionary
	 * @param list	
	 * @param ret	resultList
	 */
	public void rec(String s, Set<String> dict, List<String> list, List<String> ret) {
		if (s.length() == 0) {
			String concat = "";
			for (int i = 0; i < list.size(); i++) {
				concat += list.get(i);
				if (i != list.size() - 1) {
					concat += " ";
				}
			}
			ret.add(concat);
			return;
		}
		for (String cur : dict) {
			String temp = cur.replace(" ", "");
			if (temp.length() > s.length()) {
				continue;
			}
			String substr = s.substring(0, temp.length());
			if (substr.equals(temp)) {
				list.add(cur);
				rec(s.substring(temp.length()), dict, list, ret);
				list.remove(list.size() - 1);
			}
		}
	}


}