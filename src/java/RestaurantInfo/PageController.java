package RestaurantInfo;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PageController implements Serializable {
 
	public String moveToPage(){
	    return "each"; //outcome
	}
}