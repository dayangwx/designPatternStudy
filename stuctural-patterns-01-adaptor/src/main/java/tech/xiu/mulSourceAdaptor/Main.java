package tech.xiu.mulSourceAdaptor;

public class Main {
    public static void main(String[] args) {
        UserDataProvider mysqlAdapter = new MySQLUserAdapter();
        UserDataProvider mongoAdapter = new MongoUserAdapter();
        UserDataProvider apiAdapter = new RestApiUserAdapter();

        System.out.println(mysqlAdapter.fetchUser("u001"));
        System.out.println(mongoAdapter.fetchUser("u002"));
        System.out.println(apiAdapter.fetchUser("u003"));
    }
}
