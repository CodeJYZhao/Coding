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
 * 策略模式上下文
 * 
 * @author zhaojy
 * @date 2020年6月7日
 */
public class WorkBreakContext {

	public static final Set<String> defaultDict = new HashSet<>(
			Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "man go", "and"));

	public static IWordBreak wordBreak(String WorkBreak, Set<String> dict, Boolean isMerge) {
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

	public static List<String> getSentences(String str, Set<String> dict, Boolean isMerge) {
		List<String> list = wordBreak(str, dict, isMerge).wordBreak(str, dict);
		Assert.isTrue(!CollectionUtils.isEmpty(list), "以目前字典的单词数量，不可拆解该字符串！");
		return list;
	}

}
