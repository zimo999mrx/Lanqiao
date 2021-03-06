package AlgorithmIsSoBeautiful._2_查找_排序_初级;

/**
 * 汉诺塔游戏
 * 思路：
 * 1到N-1从A移动到C，B为辅助
 * 把N从A移动到B
 * 1到N-1从C移动到B，A为辅助
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/27 下午 11:08
 */
public class _2_6_汉诺塔游戏 {
    public static void main(String[] args) {
        _2_6_汉诺塔游戏 c = new _2_6_汉诺塔游戏();
        c.printHanoiTower(3,"A","B","C");
    }

    /**
     *  把N个盘子从from 移动到to 的路径的打印
     * @param N 汉诺塔层数
     * @param from 从哪
     * @param to 到哪
     * @param help 以睡为辅助
     */
    public void printHanoiTower(int N,String from,String to,String help){
        if(N==1){
            System.out.printf("move %d from %s to %s\n",N,from,to);
            return;
        }
        printHanoiTower(N-1,from,help,to);
        System.out.printf("move %d from %s to %s\n",N,from,to);
        printHanoiTower(N-1,help,to,from);
    }
}
