package com.northwind.customerservice.api;

import com.northwind.customerservice.domain.Customer;

class CustomerMapper {

    private CustomerMapper() {}

    public static CustomerModel toModel(Customer entity) {
        CustomerModel model = new CustomerModel();
        model.setId(entity.getId());
        model.setCompanyName(entity.getCompanyName());
        model.setContactName(entity.getContactName());
        model.setContactTitle(entity.getContactTitle());
        model.setCustomerNo(entity.getCustomerNo());
        model.setFax(entity.getFax());
        model.setPhone(entity.getPhone());
        model.setVersion(entity.getVersion());

        Link addressLink = new Link();
        addressLink.setHref(String.format("/customers/%d/addresses", entity.getId()));
        model.getLinks().add(addressLink);
        return model;
    }

    /**
     * Used for creating new customers
     * @param model
     * @return
     */
    public static Customer toEntity(CustomerModel model) {
        Customer entity = new Customer(model.getCompanyName());
        entity.setId(model.getId());
        entity.setCompanyName(model.getCompanyName());
        entity.setContactName(model.getContactName());
        entity.setContactTitle(model.getContactTitle());
        entity.setCustomerNo(model.getCustomerNo());
        entity.setFax(model.getFax());
        entity.setPhone(model.getPhone());
        return entity;
    }

    /**
     * Used tp merge for updates
     * @param model
     * @param entity
     * @return
     */
    public static Customer toEntity(CustomerModel model, Customer entity) {
        entity.setCompanyName(model.getCompanyName());
        entity.setContactName(model.getContactName());
        entity.setContactTitle(model.getContactTitle());
        entity.setCustomerNo(model.getCustomerNo());
        entity.setFax(model.getFax());
        entity.setPhone(model.getPhone());
        entity.setVersion(model.getVersion());
        return entity;
    }
}
