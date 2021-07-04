package com.au.ques2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    private int categoryId;

    @Column(name = "CategoryName")
    private String categoryName;

    @ManyToOne
    private Product productObj;

    @ManyToMany(mappedBy = "categoryList")
    private List<Supplier> supplierList = new ArrayList<>();

    public List<Supplier> getSupplierList() {
        return supplierList;
    }

    public void setSupplierList(List<Supplier> supplierList) {
        this.supplierList = supplierList;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Product getProductObj() {
        return productObj;
    }

    public void setProductObj(Product productObj) {
        this.productObj = productObj;
    }
}
