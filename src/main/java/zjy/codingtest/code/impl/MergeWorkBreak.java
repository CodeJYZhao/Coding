package zjy.codingtest.code.impl;

import java.util.Set;

import zjy.codingtest.code.IWordBreak;
import zjy.codingtest.code.WorkBreakContext;

/**
 * If user provide a customized dictionary of valid English words as additional
 * input, and the program will find all the valid words in the both dictionaries
 * 
 * @author zhaojy
 * @date 2020年6月7日
 */
public class MergeWorkBreak implements IWordBreak {

	@Override
	public Set<String> getList(Set<String> dict) {
		dict.addAll(WorkBreakContext.defaultDict);
		return dict;
	}

}
