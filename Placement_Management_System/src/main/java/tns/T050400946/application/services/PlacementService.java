package tns.T050400946.application.services;

import tns.T050400946.application.entities.Placement;

public interface PlacementService {
	
	Placement addPlacement(Placement placement);
	Placement updatePlacement(Placement placement);
	Placement searchPlacement(long id);
	boolean cancelPlacement(long id);

}
