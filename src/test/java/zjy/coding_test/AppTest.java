package zjy.coding_test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.junit.Test;

import junit.framework.TestCase;
import zjy.codingtest.code.WorkBreakContext;

/**
 * test
 * @author zhaojy
 * @date  2020年6月7日
 */
public class AppTest extends TestCase {
	@Test
	public void testDefault() {
		System.out.println("---------testDefault---------");
		List<String> sentences = WorkBreakContext.getSentences("ilikesamsungmobile", null, false);
		sentences.stream().forEach(t -> System.out.println(t));
		assertTrue(sentences.contains("i like sam sung mobile")&&sentences.contains("i like samsung mobile") && Objects.equals(sentences.size(), 2));

		sentences = WorkBreakContext.getSentences("ilikeicecreamandmango", null, false);
		sentences.stream().forEach(t -> System.out.println(t));
		assertTrue(sentences.contains("i like ice cream and man go") && Objects.equals(sentences.size(), 1));

	}

	@Test
	public void testCustomize() {
		System.out.println("--------testCustomize--------");
		Set<String> set = new HashSet<String>(
				Arrays.asList("i", "like", "sam", "sung", "mobile", "icecream", "man go", "mango", "and"));
		List<String> sentences = WorkBreakContext.getSentences("ilikesamsungmobile", set, false);
		sentences.stream().forEach(t -> System.out.println(t));
		assertTrue(sentences.contains("i like sam sung mobile") && Objects.equals(sentences.size(), 1));
	}

	@Test
	public void testMerge() {
		System.out.println("----------testMerge----------");
		Set<String> set = new HashSet<String>(
				Arrays.asList("i", "like", "sam", "sung", "mobile", "icecream", "man go", "mango"));
		List<String> sentences = WorkBreakContext.getSentences("ilikesamsungmobile", set, true);
		sentences.stream().forEach(t -> System.out.println(t));
		assertTrue(sentences.contains("i like sam sung mobile") && sentences.contains("i like samsung mobile")&& Objects.equals(sentences.size(), 2));
	}
}
