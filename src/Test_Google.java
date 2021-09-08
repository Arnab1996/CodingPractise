import java.util.ArrayList;

/**
 * @author saarnab
 * <p>
 * Given a raw Mark down String, write a function that returns the text
 * formatted using html.
 * <p>
 * <p>
 * INPUT: Hello I’m a **text in bold** and I am a text in _Italic_ .
 * **I’m in bold *and Italic*** *2\*3=6*
 * <p>
 * <p>
 * OUTPUT: Hello I’m a <b>text in bold</b>and I am a text in
 * <i>Italic</i> . <b> I’m in bold <i>and Italic</i></b> <i>2*3=6</i>
 * <p>
 * ** → bold
 * <p>
 * __ → bold
 * <p>
 * * → italic
 * <p>
 * _ → italic
 * <p>
 * <p>
 * Optional:
 * <p>
 * \ -> escaping character
 * <p>
 * ``` ->
 *
 * <pre>
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

    /**
     *
     * Write a function to return the maximum sum from root to leaf of a binary
     * tree.
     *
     * Input - 2 8 4 3 4 5 6
     *
     * Output: 14
     *
     * T -> O(n) // n -> no. of nodes
     *
     * S -> O(1)
     *
     */

    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }

        // hashCode()
        // equals()
        // toString()

    }

    class Result {
        int max;
        TreeNode answer;

        Result(int max, TreeNode node) {
            this.max = max;
            this.answer = node;
        }

        // hashCode()
        // equals()
        // toString()

    }

    // From main function populate this root to create the tree
    TreeNode root = new TreeNode(2);

    TreeNode leaf = null;

    Result res = new Result(Integer.MIN_VALUE, root);

    Result maxSumPath(TreeNode root) {
        if (root == null)
            return null;
        // Throw a custom no tree available exception

        getSumUptoLeaf(root, 0);
        constructTree(leaf);
        return res;
    }

    void constructTree(TreeNode leaf) {
        if (leaf == null)
            return;

        TreeNode temp = res.answer;

        while (temp.left != null)
            temp = temp.left;

        temp.left = leaf;

    }

    void getSumUptoLeaf(TreeNode node, int sum) {

        if (node == null)
            return;

        sum += node.data;

        // leaf encountered
        if (node.left == null && node.right == null) {
            if (sum > res.max) {
                res.max = sum;
                leaf = node;
            }
        }

        getSumUptoLeaf(node.left, sum);
        getSumUptoLeaf(node.right, sum);

    }

}
