package com.es2.bridge;

import java.util.HashMap;

public class APIRequest {
    protected HashMap<String, APIServiceInterface> services = new HashMap<>();
    int count = 0;

    public APIRequest(){ }

    public String addService(APIServiceInterface service){
        String serviceID = "service ID " + count;
        this.services.put(serviceID, service);
        count++;
        return serviceID;
    }

    public String getContent(String serviceId, String contentId) throws ServiceNotFoundException{
        APIServiceInterface service = services.get(serviceId);

        if(service == null){
            throw new ServiceNotFoundException("A service with the given ID doesn't exist!");
        }

        return service.getContent(contentId);
    }

    public String setContent(String serviceId, String content) throws ServiceNotFoundException {
        APIServiceInterface service = services.get(serviceId);

        if(service == null){
            throw new ServiceNotFoundException("A service with the given ID doesn't exist!");
        }

        return service.setContent(content);
    }
}
