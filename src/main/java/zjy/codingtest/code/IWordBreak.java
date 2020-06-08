package zjy.codingtest.code;

import java.util.List;
import java.util.Set;

import zjy.codingtest.util.WorkBreakUtil;

/**
 * strategy design pattern
 * 
 * @author zhaojy
 * @date 2020年6月7日
 */
public interface IWordBreak {

	/**
	 * get dictionary list
	 * 
	 * @param dict
	 * @return
	 */
	Set<String> getList(Set<String> dict);

	/**
	 * template design pattern
	 * 
	 * @param str
	 * @param dict
	 * @return
	 */
	default List<String> wordBreak(String str, Set<String> dict) {
		WorkBreakUtil solution = new WorkBreakUtil();
		Set<String> list = getList(dict);
		List<String> seq = solution.wordBreak(str, list);
		return seq;
	}

}
