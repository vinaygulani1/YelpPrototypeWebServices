/**
 * Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Connection;

public interface Service extends java.rmi.Remote {
    public Connection.Review[] getAllReviews(java.lang.String name) throws java.rmi.RemoteException;
    public boolean deleteReview(java.lang.String fname, java.lang.String lname, java.lang.String name) throws java.rmi.RemoteException;
    public boolean insertReview(java.lang.String name, java.lang.String rating, java.lang.String review, java.lang.String fname, java.lang.String lname, java.lang.String description) throws java.rmi.RemoteException;
    public boolean updateReview(java.lang.String description, java.lang.String rating, java.lang.String review, java.lang.String fname, java.lang.String lname, java.lang.String name) throws java.rmi.RemoteException;
    public Connection.Category[] getCatNames(java.lang.String category) throws java.rmi.RemoteException;
    public boolean signIn(java.lang.String email, java.lang.String pswd) throws java.rmi.RemoteException;
    public boolean signUp(java.lang.String fname, java.lang.String lname, java.lang.String email, java.lang.String pswd) throws java.rmi.RemoteException;
    public boolean setLastLoginTime(java.lang.String email, java.lang.String time) throws java.rmi.RemoteException;
    public Connection.Review[] getUserReviews(java.lang.String fname, java.lang.String lname) throws java.rmi.RemoteException;
    public Connection.UserDetails getUserDetails(java.lang.String email, java.lang.String pswd) throws java.rmi.RemoteException;
    public java.lang.String getLastLoginTime(java.lang.String email) throws java.rmi.RemoteException;
    public boolean insertCategoryName(java.lang.String category, java.lang.String name) throws java.rmi.RemoteException;
    public boolean updateLastLoginTime(java.lang.String email, java.lang.String dateTime) throws java.rmi.RemoteException;
    public boolean isCategoryExists(java.lang.String category, java.lang.String name) throws java.rmi.RemoteException;
    public java.lang.String[] getDistinctCategories() throws java.rmi.RemoteException;
    public boolean insertLastLoginTime(java.lang.String email, java.lang.String dateTime) throws java.rmi.RemoteException;
}
