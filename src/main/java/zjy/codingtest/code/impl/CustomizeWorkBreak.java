package zjy.codingtest.code.impl;

import java.util.Set;
import zjy.codingtest.code.IWordBreak;

/**
 * If user provide a customized dictionary of valid English words as additional
 * input, and the program will only find in the user customized dictionary
 * 
 * @author zhaojy
 * @date 2020年6月7日
 */
public class CustomizeWorkBreak implements IWordBreak {

	@Override
	public Set<String> getList(Set<String> dict) {
		return dict;
	}

}
