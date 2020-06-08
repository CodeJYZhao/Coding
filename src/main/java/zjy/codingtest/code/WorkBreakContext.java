package zjy.codingtest.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import zjy.codingtest.code.impl.CustomizeWorkBreak;
import zjy.codingtest.code.impl.DefaultWorkBreak;
import zjy.codingtest.code.impl.MergeWorkBreak;

/**
 * context
 * 
 * @author zhaojy
 * @date 2020年6月7日
 */
public class WorkBreakContext {

	public static final Set<String> defaultDict = new HashSet<>(
			Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "man go", "and"));

	/**
	 * Get policy subclass
	 * 
	 * @param dict
	 * @param isMerge
	 * @return
	 */
	public static IWordBreak wordBreak(Set<String> dict, Boolean isMerge) {
		IWordBreak wordBreak = null;
		if (CollectionUtils.isEmpty(dict)) {
			wordBreak = new DefaultWorkBreak();
		} else if (!CollectionUtils.isEmpty(dict) && !isMerge) {
			wordBreak = new CustomizeWorkBreak();
		} else if (!CollectionUtils.isEmpty(dict) && isMerge) {
			wordBreak = new MergeWorkBreak();
		}
		return wordBreak;
	}

	/**
	 * wordBreak
	 * 
	 * @param str
	 *            Sentences
	 * @param dict
	 *            Customize dictionary
	 * @param isMerge
	 *            only find in the user customized dictionary:false find all the
	 *            valid words in the both dictionaries:true
	 * @return
	 */
	public static List<String> getSentences(String str, Set<String> dict, Boolean isMerge) {
		List<String> list = wordBreak(dict, isMerge).wordBreak(str, dict);
		Assert.isTrue(!CollectionUtils.isEmpty(list),
				"The current number of words in the dictionary cannot be disassembled!");
		return list;
	}

}
