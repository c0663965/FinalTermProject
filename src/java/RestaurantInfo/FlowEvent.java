/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestaurantInfo;

/**
 *
 * @author gurvinder singh
 */
import javax.faces.component.UIComponent;
import javax.faces.event.FacesEvent;
import javax.faces.event.FacesListener;

public class FlowEvent extends FacesEvent {
	
	private String oldStep;
	
	private String newStep;

	public FlowEvent(UIComponent component, String oldStep, String newStep) {
		super(component);
		this.oldStep = oldStep;
		this.newStep = newStep;
	}

	@Override
	public boolean isAppropriateListener(FacesListener listener) {
		return false;
	}

	@Override
	public void processListener(FacesListener listener) {
		throw new UnsupportedOperationException();
	}
	
	public String getOldStep() {
		return oldStep;
	}

	public String getNewStep() {
		return newStep;
	}
}