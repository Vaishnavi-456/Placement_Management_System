package tns.T050400946.application.services;

import java.util.List;

import tns.T050400946.application.entities.College;
import tns.T050400946.application.entities.Placement;
import tns.T050400946.application.entities.User;

public interface CollegeService  {
	
	College addCollege(College college);
	College updateCollege(College college);
	College searchCollege(long college_id);
	boolean deleteCollege(long college_id);
	boolean schedulePlacement(Placement placement);
	List<College> getAllColleges();

}
