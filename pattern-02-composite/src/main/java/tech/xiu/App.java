package tech.xiu;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        OrgGroup company = new OrgGroup("总部");
        OrgGroup tech = new OrgGroup("技术部");

        tech.add(new Department("开发组"));
        tech.add(new Department("测试组"));

        company.add(tech);
        company.add(new Department("市场部"));

        company.print();

    }
}
