package tns.T050400946.application.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tns.T050400946.application.entities.College;
import tns.T050400946.application.entities.Placement;
import tns.T050400946.application.repository.CollegeRespository;
import tns.T050400946.application.repository.PlacementRepository;

@Service
public class CollegeServiceImpl implements CollegeService {
	
	@Autowired
	CollegeRespository repo;
	PlacementRepository repo1;

	@Override
	public College addCollege(College college) {
		return repo.save(college);
		
	}

	@Override
	public College updateCollege(College college) {
		
		if (!repo.existsById(college.getCollege_id())) {
            throw new NoSuchElementException("Placement Information with ID " + college.getCollege_id() + " not found.");
        }
        return repo.save(college);
	}
	@Override
	public College searchCollege(long college_id) {
		
		try {
			
			return repo.findById(college_id).get();
			
		}catch(NoSuchElementException e) {
			
			System.out.println("No such college found.");
			return null;
		}
	}

	@Override
	public boolean deleteCollege(long college_id) {
		
		 if (repo.existsById(college_id)) {
		        repo.deleteById(college_id);
		        System.out.println("College with ID: " + college_id + " deleted successfully.");
		        return true; 
		    } else {
		        System.out.println("College with ID: " + college_id + " not found.");
		        return false; 
		    }
	   
	}

	@Override
	public boolean schedulePlacement(Placement placement) {
		
		 Placement savedPlacement = repo1.save(placement);
		    
		    if (savedPlacement != null) {
		        System.out.println("Placement is scheduled successfully.");
		        return true;  
		    } else {
		        System.out.println("Failed to schedule placement.");
		        return false; 
		    }
		
		
		
	}

	@Override
	public List<College> getAllColleges() {
		return repo.findAll();
	}

}
