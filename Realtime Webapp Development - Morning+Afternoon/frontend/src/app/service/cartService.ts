import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})

export class cartService {
  totalCart:any
  products:any =[{
          itemId:1,
          name : "Shampoo",
          price: 100,
          image : "August 23",
          totalItems:10
      },
      {
        itemId:2,
          name : "Soap",
          price: 200,
          image : "August 23",
          totalItems:10
      },
      {
        itemId:3,
          name : "Hair Band",
          price: 300,
          image : "August 23",
          totalItems:10
      },
    ]
  cart:any =[
    ]
  constructor(private http: HttpClient) {}
  addToCart(product:any){
    for (let x in this.cart) {
        if (this.cart.hasOwnProperty(x) && this.cart[x].itemId=== product.itemId) {
            alert("Item ALready Present in Cart!!!")
            return;
        }
    }
    this.cart.push({...product,itemQuantity:1})
    this.updateResult()
  }
     addItem(product: any) {
     this.cart.forEach((item, index) => {
      if (item.itemId== product.itemId) {
        if(this.cart[index].itemQuantity < item.totalItems)
         this.cart[index].itemQuantity++
        else
         alert(`No More ${product.name} Available`);
      }
    });
    this.updateResult()
  }
   deleteItem(product: any) {
     this.cart.forEach((item, index) => {
      if (item.itemId== product.itemId) {
        if(this.cart[index].itemQuantity>=1)
        this.cart[index].itemQuantity--
      }
    });
    this.updateResult()
  }
  updateResult(){
    let totalItems=0;
    let totalPrice=0;
    this.cart.forEach((item,index)=>{
        totalItems=totalItems+item.itemQuantity;
        totalPrice=totalPrice+(item.itemQuantity*item.price)
    })
    this.totalCart={
      totalPrice:totalPrice,
      totalItems:totalItems
    }
    return this.totalCart;
  }
}
