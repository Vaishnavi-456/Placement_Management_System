package tns.T050400946.application.services;

import tns.T050400946.application.entities.College;
import tns.T050400946.application.entities.Placement;

public interface CollegeService  {
	
	College addCollege(College college);
	College updateCollege(College college);
	College searchCollege(long college_id);
	boolean deleteCollege(long college_id);
	boolean schedulePlacement(Placement placement);

}
