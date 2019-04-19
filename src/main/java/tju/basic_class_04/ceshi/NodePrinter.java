package tju.basic_class_04.ceshi;

/**
 * Author: bijiaha0
 * Date: 2018-10-25
 * Time: 下午6:34
 * Email: clickgwas@gmail.com
 */
public class NodePrinter  implements INodeHandler {
    public void handle(Node n){
        System.out.print(n.data);  // 在控制台上打印出节点，无回车换行。
    }
}
