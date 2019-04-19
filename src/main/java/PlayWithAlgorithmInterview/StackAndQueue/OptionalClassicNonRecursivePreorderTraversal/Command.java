package PlayWithAlgorithmInterview.StackAndQueue.OptionalClassicNonRecursivePreorderTraversal;
/**
 * Author: bijiaha0
 * Date: 2019-02-19
 * Time: 8:55 PM
 * Email: clickgwas@gmail.com
 */
public class Command {
    public String s;
    public TreeNode node;
    public Command(){
    }
    public Command(String s, TreeNode node){
        this.s = s;
        this.node = node;
    }
}
