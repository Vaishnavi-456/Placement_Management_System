package tns.T050400946.application.services;

import tns.T050400946.application.entities.Certificate;

public interface CertificateService {
	
	Certificate addCertificate(Certificate certificate);
	Certificate updateCertificate(Certificate certificate);
	Certificate searchCertificate(long certificate_id);
	Certificate deleteCertificate(long certificate_id);


}
