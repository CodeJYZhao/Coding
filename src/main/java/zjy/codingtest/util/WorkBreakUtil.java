package zjy.codingtest.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class WorkBreakUtil {
	public List<String> wordBreak(String s, Set<String> dict) {
		List<String> list = new ArrayList<String>();
		List<String> ret = new ArrayList<String>();
		rec(s, dict, list, ret);
		return ret;
	}

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

	public boolean isBreak(String s, Set<String> dict) {
		boolean[] canBreak = new boolean[s.length() + 1];
		canBreak[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			boolean flag = false;
			for (int j = 0; j < i; j++) {
				if (canBreak[j] && dict.contains(s.substring(j, i))) {
					flag = true;
					break;
				}
			}
			canBreak[i] = flag;
		}
		return canBreak[s.length()];
	}

}