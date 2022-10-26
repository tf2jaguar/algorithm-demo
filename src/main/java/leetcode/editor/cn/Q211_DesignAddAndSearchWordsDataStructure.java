//请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。 
//
// 实现词典类 WordDictionary ： 
//
// 
// WordDictionary() 初始化词典对象 
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配 
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 
//'.' ，每个 . 都可以表示任何一个字母。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search",
//"search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 500 
// addWord 中的 word 由小写英文字母组成 
// search 中的 word 由 '.' 或小写英文字母组成 
// 最多调用 50000 次 addWord 和 search 
// 
// Related Topics 深度优先搜索 设计 字典树 字符串 👍 339 👎 0

package leetcode.editor.cn;

/**
 * title: 211 : 添加与搜索单词 - 数据结构设计
 * create: 2021-10-19 19:07:40
 */
public class Q211_DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
        WordDictionary solution = new Q211_DesignAddAndSearchWordsDataStructure().new WordDictionary();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class WordDictionary {
        //声明一个根节点
        TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            //拷贝一个根节点
            TrieNode parentNode = root;
            //遍历
            for (int i = 0; i < word.length(); i++) {
                //查询当前字符为父节点的哪一个子节点
                int index = word.charAt(i) - 'a';
                //查询当前子节点是否存在,如果不存在就创建出来
                if (parentNode.children[index] == null) {
                    parentNode.children[index] = new TrieNode();
                }
                //更新父节点
                parentNode = parentNode.children[index];
            }
            //标记为末位节点
            parentNode.isWord = true;
        }

        public boolean search(String word) {
            return find(word, 0, root);
        }

        private Boolean find(String word, int index, TrieNode node) {
            if (node == null) return false;
            if (index >= word.length()) return node.isWord;
            //得到当前节点字符
            char c = word.charAt(index);
            //判断是不是'.'
            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    if (find(word, index + 1, node.children[i])) {
                        return true;
                    }
                }
                //如果找了一圈还么有找到 就代表找不到了
                return false;
            } else {
                return find(word, index + 1, node.children[c - 'a']);
            }
        }

        class TrieNode {
            //定义节点类 使用数组对子节点进行模拟
            TrieNode[] children;
            // 标记是否是完整字符串
            boolean isWord;

            public TrieNode() {
                isWord = false; // 初始标记都不是终点
                children = new TrieNode[26]; //对应26个字符
            }
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}