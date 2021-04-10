import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { CartItem } from '../common/cart-item';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  cartItems: CartItem[] = [];
  totalPrice: Subject<number> = new Subject<number>();
  totalQuantity: Subject<number> = new Subject<number>();

  constructor() { }

  addToCart(cartItem: CartItem) {
    // check if we already have the item in our cart
    let alreadyExistsInCart: boolean = false;
    let existingCartItem: CartItem = undefined;

    // find the item in the cart based on item id
    if (this.cartItems.length > 0) {
      for (let tempCartItem of this.cartItems) {
        if (tempCartItem.id == cartItem.id) {
          existingCartItem = tempCartItem;
          break;
        }
      }

      // check if we found it
      alreadyExistsInCart = (existingCartItem != undefined);
    }

    if (alreadyExistsInCart) { // if found increment quantity
      existingCartItem.quantity++;
    }
    else { // just push to array
      this.cartItems.push(cartItem);
    }

    this.computeCartTotals();

  }

  computeCartTotals() {
    let totalPriceValue: number = 0;
    let totalQuantityValue: number = 0;

    for (let cartItem of this.cartItems) {
      totalPriceValue += cartItem.quantity * cartItem.unitPrice;
      totalQuantityValue += cartItem.quantity;
    }

    // publish the new values .. all subscribers will receive the new data
    this.totalPrice.next(totalPriceValue);
    this.totalQuantity.next(totalQuantityValue); // .next method publishes/sends/emits the event

    // log cart data just for debugging purposes
    this.logCartData(totalPriceValue, totalQuantityValue);
  }

  logCartData(totalPriceValue: number, totalQuantityValue: number) {
    console.log('Contents of the Cart');
    for (let cartItem of this.cartItems) {
      const subTotalPrice: number = cartItem.quantity * cartItem.unitPrice;
      console.log(`name: ${cartItem.name}, quantity=${cartItem.quantity}, unitPrice=${cartItem.unitPrice}, subTotalPrice=${subTotalPrice}`);
    }

    console.log(`totalPrice: ${totalPriceValue.toFixed(2)}, totalQuantity: ${totalQuantityValue.toFixed(2)}`);
    console.log('-----------');
  }
}
