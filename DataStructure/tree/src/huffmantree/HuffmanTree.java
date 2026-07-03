package huffmantree;

import sun.nio.cs.ext.IBM037;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

//哈夫曼树：拥有最小带权路径长度的二叉树
public class HuffmanTree {
    private static Node root = null;
    private static Map<Byte, String> encodingTable = new HashMap<>();

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "i like like like java do you like a java";
        byte[] encode = encode(str);
        String string = decode(encode);
        System.out.println(string);
        //preOrder(root);
    }

    //获取节点集合
    public static List<Node> getNodeList(String str) throws UnsupportedEncodingException {
        ArrayList<Node> nodeList = new ArrayList<>();
        byte[] bytes = str.getBytes("UTF-8");
        HashMap<Byte, Integer> map = new HashMap<>();//键是字符，值是出现的次数
        for (int i = 0; i < bytes.length; i++) {
            byte ch = bytes[i];
            if (map.containsKey(ch)) {
                map.put(ch, (map.get(ch) + 1));
            } else {
                map.put(ch, 1);
            }
        }
        Set<Map.Entry<Byte, Integer>> entries = map.entrySet();
        for (Map.Entry<Byte, Integer> entry : entries) {
            nodeList.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodeList;
    }

    //构建哈夫曼树
    public static void buildHuffmanTree(String str) throws UnsupportedEncodingException {
        List<Node> nodeList = getNodeList(str);
        while (nodeList.size() > 1) {
            Collections.sort(nodeList);//升序排
            Node left = nodeList.remove(0);//取出最小的两个元素
            Node right = nodeList.remove(0);
            Node parent = new Node(null, left.weight + right.weight);//构造父节点，权值为左右子节点相加
            parent.left = left;
            parent.right = right;
            nodeList.add(parent);
        }
        root = nodeList.get(0);
    }

    //构造哈夫曼编码表
    public static Map<Byte, String> buildEncodingTable(Node root) {
        buildEncodingTableHelper(root, "", encodingTable);
        return encodingTable;
    }

    public static void buildEncodingTableHelper(Node node, String code, Map<Byte, String> encodingTable) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {//遍历到叶子节点，将节点代表的字符和对应的编码加到编码表
            encodingTable.put(node.ch, code);
            return;
        }
        buildEncodingTableHelper(node.left, code + "0", encodingTable);//向左递归遍历并拼接0
        buildEncodingTableHelper(node.right, code + "1", encodingTable);//向右递归遍历并拼接1
    }

    //对字符串进行哈夫曼编码转为字节数组
    public static byte[] encode(String str) throws UnsupportedEncodingException {
        buildHuffmanTree(str);
        Map<Byte, String> map = buildEncodingTable(root);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(map.get((byte) str.charAt(i)));
        }
        System.out.println(sb);
        int len;
        if (sb.length() % 8 == 0) {
            len = sb.length() / 8;
        } else {
            len = sb.length() / 8 + 1;
        }
        byte[] bytes = new byte[len];
        int index = 0;
        for (int i = 0; i < sb.length(); i += 8) {
            if (i + 8 > sb.length()) {
                bytes[index] = (byte) Integer.parseInt(sb.substring(i), 2);
            } else {
                bytes[index] = (byte) Integer.parseInt(sb.substring(i, i + 8), 2);
            }
            index++;
        }
        return bytes;
    }

    public static String byteToBinaryString(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp |= 256;//如果不是最后一个字节，需要补高位
        }
        String str = Integer.toBinaryString(temp);//返回的是temp的32位二进制补码，我们只需要低八位
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    //哈夫曼解码
    public static String decode(byte[] encode) {
        StringBuilder sb = new StringBuilder();
        int length = encode.length;
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                sb.append(byteToBinaryString(false, encode[i]));
            } else {
                sb.append(byteToBinaryString(true, encode[i]));
            }
        }
        String binaryString = sb.toString();
        sb.setLength(0);
        //反编码表，键位编码，值为字符
        HashMap<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : encodingTable.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        //将编码转为字符
        int startIndex = 0;
        for (int i = 1; i < binaryString.length(); i++) {
            String key = binaryString.substring(startIndex, i + 1);
            if (map.containsKey(key)) {
                sb.append((char) map.get(key).byteValue());
                startIndex = i + 1;
            }
        }
        return sb.toString();
    }

    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node);
        preOrder(node.left);
        preOrder(node.right);
    }
}
