package eu.kudljo.aopdemo;

import eu.kudljo.aopdemo.dao.AccountDAO;
import eu.kudljo.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		return runner -> {
//			demoTheBeforeAdvice(accountDAO, membershipDAO);
			demoTheAfterReturningAdvice(accountDAO);
		};
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
		List<Account> accounts = accountDAO.findAccounts();

		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("----");

		System.out.println(accounts);

		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		Account myAccount = new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Platinum");

		accountDAO.addAccount(myAccount, true);
		accountDAO.doWork();

		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();

		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
	}

}
