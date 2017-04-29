/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author ANDRIAMIADANTSOA
 */
@Named(value = "languageManagedBean")
@SessionScoped
public class LanguageManagedBean implements Serializable {

    private String localeCode;

    private static final Map<String,Object> countries;
    static{
	countries = new LinkedHashMap<>();
	countries.put("Anglais", Locale.ENGLISH); //label, value
	countries.put("Français", Locale.FRANCE);
    } 
    
    public Map<String, Object> getCountriesInMap() {
		return countries;
	}


    public String getLocaleCode() {
	return localeCode;
    }


    public void setLocaleCode(String localeCode) {
	this.localeCode = localeCode;
    }
    
    public void countryLocaleCodeChanged(ValueChangeEvent e){

	String newLocaleValue = e.getNewValue().toString();

		//loop country map to compare the locale code
        for (Map.Entry<String, Object> entry : countries.entrySet()) {

            if(entry.getValue().toString().equals(newLocaleValue)){
                FacesContext.getCurrentInstance()
        	.getViewRoot().setLocale((Locale)entry.getValue());

            }
        }
    }
    
}
