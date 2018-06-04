package us.onesquare.bastoji.dao;

import java.util.List;

import us.onesquare.bastoji.model.subscription.Registration;

public interface IRegistrationDao {
	

	/**
     * Used to Create the Registration Information
     * @param Registration
     * @return {@link Registration}
     */
    public Registration createRegistration(Registration registration);
   
    /**
     * Getting the Registration Information using Id
     * @param id
     * @return {@link registration}
     */
    public Registration getRegistration(int id);
    
    /**
     * Used to Update the Registration Information
     * @param Registration
     * @return {@link registration}
     */
    
    public Registration updateRegistration(Registration registration);
    
    /**
     * Deleting the Registration Information using Id
     * @param id
     */
    public void deleteRegistration(int id);
    
    /**
     * Getting the All Registration information
     * @return
     */
    public List<Registration> getAllRegistrations();
}
