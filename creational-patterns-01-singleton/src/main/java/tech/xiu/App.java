package tech.xiu;

import tech.xiu.eager.EagerPerson;
import tech.xiu.lazy.LazyPerson;

import java.util.Map;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        // eager
//        EagerPerson instance = EagerPerson.getInstance();
//
//        EagerPerson instance1 = EagerPerson.getInstance();
//        System.out.println(instance == instance1); // true
//        System.out.println( "Hello World!" );



        // lazy 如何保证线程安全？
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                LazyPerson instance2 = LazyPerson.getInstance("lazy person - "+ Thread.currentThread().getName());
//                System.out.println("LazyPerson instance: " + instance2);
//            }).start();
//        }


        // 拿到所有的环境变量。电脑上配置的环境变量
        Map<String, String> envs = System.getenv();
        System.out.println("Environment Variables:" + envs);


        Properties properties = System.getProperties();
        System.out.println(properties);
    }
}
