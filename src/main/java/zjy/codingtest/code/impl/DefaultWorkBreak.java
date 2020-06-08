package zjy.codingtest.code.impl;

import java.util.Set;

import zjy.codingtest.code.IWordBreak;
import zjy.codingtest.code.WorkBreakContext;

/**
 * Default dictionary
 * 
 * @author zhaojy
 * @date 2020年6月7日
 */
public class DefaultWorkBreak implements IWordBreak {

	@Override
	public Set<String> getList(Set<String> dict) {
		return WorkBreakContext.defaultDict;
	}

}
