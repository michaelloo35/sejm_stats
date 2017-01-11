package sejm_stats;

import java.io.IOException;

import org.junit.Test;

public class ParserTest {

	@Test(expected = IOException.class)
	public void test1() throws IOException {
		Parser test = new Parser();
		String[] arg = new String[]{"info","Ewa","Kopacz","2"};
		test.parse(arg);
	}
	
	@Test(expected = IOException.class)
	public void test2() throws IOException {
		Parser test = new Parser();
		String[] arg = new String[]{"info","Ewa","Kopacz"};
		test.parse(arg);
	}
	@Test(expected = IOException.class)
	public void test3() throws IOException {
		Parser test = new Parser();
		String[] arg = new String[]{"info","Ewa"};
		test.parse(arg);
	}
	@Test(expected = IOException.class)
	public void test4() throws IOException {
		Parser test = new Parser();
		String[] arg = new String[]{"info","Ewa","Kopacz","7","43"};
		test.parse(arg);
	}
	@Test(expected = IOException.class)
	public void test5() throws IOException {
		Parser test = new Parser();
		String[] arg = new String[]{"info"};
		test.parse(arg);
	}
	@Test(expected = IOException.class)
	public void test6() throws IOException {
		Parser test = new Parser();
		String[] arg = new String[]{};
		test.parse(arg);
	}
	@Test(expected = IOException.class)
	public void test7() throws IOException {
		Parser test = new Parser();
		String[] arg = new String[]{"7","info","Kopacz","7","43"};
		test.parse(arg);
	}
	@Test(expected = IOException.class)
	public void test8() throws IOException {
		Parser test = new Parser();
		String[] arg = new String[]{"update","info","Kopacz","7","43"};
		test.parse(arg);
	}
	@Test(expected = IOException.class)
	public void test9() throws IOException {
		Parser test = new Parser();
		String[] arg = new String[]{"updatez"};
		test.parse(arg);
	}
	@Test(expected = IOException.class)
	public void test10() throws IOException {
		Parser test = new Parser();
		String[] arg = new String[]{"update","8"};
		test.parse(arg);
	}
	@Test(expected = IOException.class)
	public void test11() throws IOException {
		Parser test = new Parser();
		String[] arg = new String[]{"Ewa", "Kopacz"};
		test.parse(arg);
	}

}
