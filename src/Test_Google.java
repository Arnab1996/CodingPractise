import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 *
 * @author saarnab
 * 
 *         Given a raw Mark down String, write a function that returns the text
 *         formatted using html.
 *
 * 
 *         INPUT: Hello I’m a **text in bold** and I am a text in _Italic_ .
 *         **I’m in bold *and Italic*** *2\*3=6*
 *
 * 
 *         OUTPUT: Hello I’m a <b>text in bold</b>and I am a text in
 *         <i>Italic</i> . <b> I’m in bold <i>and Italic</i></b> <i>2*3=6</i>
 * 
 *         ** → bold
 * 
 *         __ → bold
 * 
 *         * → italic
 * 
 *         _ → italic
 * 
 * 
 *         Optional:
 * 
 *         \ -> escaping character
 * 
 *         ``` ->
 * 
 *         <pre>
 *         <code>
 * 
 *         ` -> <code>
 * 
 *         dict ** -> BOLD...
 * 
 *         * -> ITALIC
 *
 *         **AA**
 * 
 *         getTag(i, string) { // i=0, string= **AA** | out: <b>
 * 
 *         hashmap.keys[0] == string.substring(i, hashmap.keys[0].length)
 * 
 *         if(string.charAt(i+1).isCharacter())
 * 
 *         return dict.get('*');
 * 
 *         else
 * 
 *         return dict.get('**');
 * 
 *         }
 * 
 *         /*
 * 
 *         1. If we * check for next char, - append to startTag value
 * 
 *         {BOLD, <bold>}
 * 
 *         {IT, <italic>}
 * 
 * 
 */

/**
 * 
 * 
 * @author saarnab
 * 
 * 
 * 
 *         123 => |234| + |345| + 1
 * 
 *         234 = |456| + |789| + 1
 * 
 * 
 * 
 *         Base [] => 1
 * 
 *         f[k] = sum f[f[Ai]] + 1
 * 
 * 
 * 
 *         {
 * 
 *         "123": ["234", "345"],
 * 
 *         "234": ["456", "789"],
 * 
 *         "345":[],
 * 
 *         "456":[],
 * 
 *         "789":[]
 * 
 *         }
 * 
 * 
 * 
 *         int arr[] = new int[5];
 * 
 *         arr[0]= arr[1] + arr[2] + 1;
 * 
 *         arr[1] = arr[3] + arr[4] + 1;
 * 
 *         arr[2] = arr[3] = arr[4] = 1;
 * 
 * 
 * 
 *         "123" = 3 + 1 + 1 = 4
 * 
 *         "234" = 1 + 1 + 1 = 3
 * 
 *         "345", "456", "789" = 1
 *
 * 
 *         T = O(n^2)
 * 
 *         S = O(n)
 * 
 * 
 */

public class Test_Google {

	public static void main(String[] args) {
		System.out.println(parseMarkdown(
				"Hello I’m a **text in bold** and I am a text in _Italic_ .**I’m in bold *and Italic*** *2*3=6*"));

	}

	// 2 maps - startTag, endTag
	// index where a particular tag(a value the dict) is starting/ending

	public static String parseMarkdown(String markdownString) {

		// Stack<Integer> st = new Stack<>();
		markdownString += "`";
		boolean boldFlag = false;
		boolean italicFlag = false;
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>\n" + "<html>\n" + "<head>\n"
				+ "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n"
				+ "  <title> Text Conversion </title>\n" + "</head>\n<body>\n");

		for (int i = 0, len = markdownString.length(); i < len; i++) {

			if (i + 1 == len) {
				break;
			}

			switch (markdownString.charAt(i)) {
			case '\n':
				i++;
				break;
			case '\r':
				i++;
				break;
			case '\t':
				sb.append("    ");
				i++;
				break;
			case '*':
				if (i != 0 && markdownString.charAt(i + 1) != '`' && Character.isDigit(markdownString.charAt(i - 1))
						&& Character.isDigit(markdownString.charAt(i + 1))) {
					sb.append("*");
				} else if (markdownString.charAt(i + 1) != '`' && markdownString.charAt(i + 1) == '*') {
					i++;
					if (boldFlag) {
						sb.append("</b>");
						boldFlag = false;
					} else {
						sb.append("<b>");
						boldFlag = true;
					}
				} else {
					if (italicFlag) {
						sb.append("</i>");
						italicFlag = false;
					} else {
						sb.append("<i>");
						italicFlag = true;
					}
				}
				break;

			case '_':
				if (markdownString.charAt(i + 1) != '`' && markdownString.charAt(i + 1) == '_') {
					i++;
					if (boldFlag) {
						sb.append("</b>");
						boldFlag = false;
					} else {
						sb.append("<b>");
						boldFlag = true;
					}

				} else {
					if (italicFlag) {
						sb.append("</i>");
						italicFlag = false;
					} else {
						sb.append("<i>");
						italicFlag = true;
					}
				}
				break;

			default:
				sb.append(markdownString.charAt(i));
				break;
			}
		}

		sb.append("\n</body>\n</html>\n");

		return sb.toString();
	}

	void computeScore(ArrayList<ArrayList<String>> G, String employee) {
		int arr[] = new int[G.size()];
		helper(G, employee, arr, 0);
		System.out.println(arr[0]);
	}

	int helper(ArrayList<ArrayList<String>> G, String employee, int arr[], int index) {

		if (G.get(index).size() == 0) {
			arr[index] = 1;
			return 1;
		}

		ArrayList<String> temp = G.get(index);
		int sum = 0;

		for (int i = 0, len = temp.size(); i < len; i++) {
			sum = helper(G, temp.get(i), arr, i);
		}

		sum += 1;
		arr[index] = sum;
		return sum;
	}

}
