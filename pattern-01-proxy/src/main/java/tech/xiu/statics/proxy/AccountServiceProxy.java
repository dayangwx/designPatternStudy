package tech.xiu.statics.proxy;


import tech.xiu.statics.service.AccountService;

public class AccountServiceProxy implements AccountService {

    private AccountService accountService;

    public AccountServiceProxy(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void addAccount() {
        System.out.println("proxy开始添加账户");
        accountService.addAccount();
        System.out.println("proxy结束添加账户");
    }

    @Override
    public void selectAccount() {
        System.out.println("proxy开始查询账户");
        accountService.selectAccount();
        System.out.println("proxy结束查询账户");
    }

    @Override
    public void updateAccount() {
        System.out.println("开始更新账户");
        accountService.updateAccount();
        System.out.println("结束更新账户");
    }

    @Override
    public void deleteAccount() {
        System.out.println("开始删除账户");
        accountService.deleteAccount();
        System.out.println("结束删除账户");
    }
}
