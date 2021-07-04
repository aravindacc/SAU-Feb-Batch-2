package com.au.ques2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    private int productId;

    @Column(name = "ProductName")
    private String productName;

    @OneToMany(mappedBy = "productObj")
    private List<Category> categoryList = new ArrayList<>();

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


}
