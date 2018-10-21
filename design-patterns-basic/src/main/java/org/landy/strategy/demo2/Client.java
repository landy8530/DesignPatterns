package org.landy.strategy.demo2;

/**
 * @author landyl
 * @create 2:47 PM 05/12/2018
 */
public class Client {

    public static void main(String[] args) {
        Player player = new Player();
        player.buy(5000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
        player.buy(12000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
        player.buy(20000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
        player.buy(40000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
    }

}
