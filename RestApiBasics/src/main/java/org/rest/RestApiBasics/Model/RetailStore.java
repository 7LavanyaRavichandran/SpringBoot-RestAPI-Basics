package org.rest.RestApiBasics.Model;

public class RetailStore {
    public int storeId;
    public String name;
    public String location;
    public long mobile;
    public String email;
    public int workers;

    public RetailStore(int storeId, String name, String location, long mobile, String email, int workers) {
        this.storeId = storeId;
        this.name = name;
        this.location = location;
        this.mobile = mobile;
        this.email = email;
        this.workers = workers;
    }

    public RetailStore() {
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getWorkers() {
        return workers;
    }

    public void setWorkers(int workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        return "StoreID:"+storeId+", Name:"+name+", Location: "+location+ ". Mobile: "+mobile+", Email: "+email+ ", Workers "+workers;
    }
}
