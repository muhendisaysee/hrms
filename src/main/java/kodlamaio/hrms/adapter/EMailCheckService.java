package kodlamaio.hrms.adapter;

import kodlamaio.hrms.entities.concretes.User;

public interface EMailCheckService {
	public boolean sendMail(User user);
	public boolean verificationCheckControl(User user);
}
