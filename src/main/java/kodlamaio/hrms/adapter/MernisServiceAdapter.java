package kodlamaio.hrms.adapter;


import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements MernisService{
	
	@Override
	public  Boolean checkIfReelPerson(Candidate candidate){
		/*KPSPublicSoapProxy client = new KPSPublicSoapProxy();
			try {
				 client.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()),
				candidate.getFirstName().toUpperCase(),
				candidate.getLastName().toUpperCase(),
				candidate.getBirthYear());
			
			}
			catch (Exception e) {
			
			}*/
		return true;
	}
}
