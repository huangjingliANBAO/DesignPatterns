package danlimoshi;

/**
 * 懒汉式单例
 * 该模式的特点是类加载时没有生成单例
 * 只有当第一次调用 getlnstance 方法时才去创建这个单例
 */
public class LazySingleton {
    //保证instance在所有线程中同步
    //volatile并发 关键字 https://juejin.cn/post/6844903520760496141
    private static volatile LazySingleton instance = null;
    private LazySingleton(){

    }
    public static synchronized LazySingleton getInstance(){
        if (instance == null){
           instance = new LazySingleton();
        }
        return instance;
    }
}
