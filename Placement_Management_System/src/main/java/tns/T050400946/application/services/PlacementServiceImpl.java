package tns.T050400946.application.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tns.T050400946.application.entities.Placement;
import tns.T050400946.application.repository.PlacementRepository;

@Service
public class PlacementServiceImpl implements PlacementService {
	
	@Autowired
	PlacementRepository repo;

	@Override
	public Placement addPlacement(Placement placement) {
		return repo.save(placement);
	}

	@Override
	public Placement updatePlacement(Placement placement) {
		
		if (!repo.existsById(placement.getId())) {
            throw new NoSuchElementException("Placement Information with ID " + placement.getId() + " not found.");
        }
        return repo.save(placement);  
		
	}

	@Override
	public Placement searchPlacement(long id) {
      try {
			
			return repo.findById(id).get();
			
		}catch(NoSuchElementException e) {
			
			System.out.println("No placement information found with ID: " + id);
			return null;
		}
	}

	@Override
	public boolean cancelPlacement(long id) {
		
		if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
            return true;
        } else {
            throw new NoSuchElementException("Placement with ID " + id + " not found.");
        }
	}

}
