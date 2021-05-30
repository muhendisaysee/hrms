package kodlamaio.hrms.adapter;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.User;

@Service
public class EMailCheckManager implements EMailCheckService{

	@Override
	public boolean sendMail(User user) {
		System.out.println("Email send : " + user.getEmail());
		return true;
	}

	@Override
	public boolean verificationCheckControl(User user) {
		System.out.println("Email verification : " + user.getEmail());
		return true;
		
	}

}
