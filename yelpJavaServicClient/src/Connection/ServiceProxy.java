package Connection;

public class ServiceProxy implements Connection.Service {
  private String _endpoint = null;
  private Connection.Service service = null;
  
  public ServiceProxy() {
    _initServiceProxy();
  }
  
  public ServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceProxy();
  }
  
  private void _initServiceProxy() {
    try {
      service = (new Connection.ServiceServiceLocator()).getService();
      if (service != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)service)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (service != null)
      ((javax.xml.rpc.Stub)service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public Connection.Service getService() {
    if (service == null)
      _initServiceProxy();
    return service;
  }
  
  public Connection.Review[] getAllReviews(java.lang.String name) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getAllReviews(name);
  }
  
  public boolean deleteReview(java.lang.String fname, java.lang.String lname, java.lang.String name) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.deleteReview(fname, lname, name);
  }
  
  public boolean insertReview(java.lang.String name, java.lang.String rating, java.lang.String review, java.lang.String fname, java.lang.String lname, java.lang.String description) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.insertReview(name, rating, review, fname, lname, description);
  }
  
  public boolean updateReview(java.lang.String description, java.lang.String rating, java.lang.String review, java.lang.String fname, java.lang.String lname, java.lang.String name) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.updateReview(description, rating, review, fname, lname, name);
  }
  
  public Connection.Category[] getCatNames(java.lang.String category) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getCatNames(category);
  }
  
  public boolean signIn(java.lang.String email, java.lang.String pswd) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.signIn(email, pswd);
  }
  
  public boolean signUp(java.lang.String fname, java.lang.String lname, java.lang.String email, java.lang.String pswd) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.signUp(fname, lname, email, pswd);
  }
  
  public boolean setLastLoginTime(java.lang.String email, java.lang.String time) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.setLastLoginTime(email, time);
  }
  
  public Connection.Review[] getUserReviews(java.lang.String fname, java.lang.String lname) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getUserReviews(fname, lname);
  }
  
  public Connection.UserDetails getUserDetails(java.lang.String email, java.lang.String pswd) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getUserDetails(email, pswd);
  }
  
  public java.lang.String getLastLoginTime(java.lang.String email) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getLastLoginTime(email);
  }
  
  public boolean insertCategoryName(java.lang.String category, java.lang.String name) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.insertCategoryName(category, name);
  }
  
  public boolean updateLastLoginTime(java.lang.String email, java.lang.String dateTime) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.updateLastLoginTime(email, dateTime);
  }
  
  public boolean isCategoryExists(java.lang.String category, java.lang.String name) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.isCategoryExists(category, name);
  }
  
  public java.lang.String[] getDistinctCategories() throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getDistinctCategories();
  }
  
  public boolean insertLastLoginTime(java.lang.String email, java.lang.String dateTime) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.insertLastLoginTime(email, dateTime);
  }
  
  
}