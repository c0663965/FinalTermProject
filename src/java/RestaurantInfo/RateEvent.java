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
import javax.faces.component.behavior.Behavior;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.AjaxBehaviorListener;
import javax.faces.event.FacesListener;
public class RateEvent extends AjaxBehaviorEvent {

	private Object rating;
	
	public RateEvent(UIComponent component, Behavior behavior, Object rating) {
		super(component, behavior);
		this.rating = rating;
	}

	@Override
	public boolean isAppropriateListener(FacesListener faceslistener) {
		return (faceslistener instanceof AjaxBehaviorListener);
	}

	@Override
	public void processListener(FacesListener faceslistener) {
		((AjaxBehaviorListener) faceslistener).processAjaxBehavior(this);
	}
	
	public Object getRating() {
		return rating;
    }
}
