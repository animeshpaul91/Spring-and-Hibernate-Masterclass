import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';
import { CartItem } from '../common/cart-item';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  cartItems: CartItem[] = [];
  totalPrice: Subject<number> = new BehaviorSubject<number>(0); // Behavior Subject requires a default value if not instantiated
  totalQuantity: Subject<number> = new BehaviorSubject<number>(0); // Behavior Subject requires a default value if not instantiated
  // Behavior subject sends the most recent event to all subscribers of this Subject. 
  constructor() { }

  addToCart(cartItem: CartItem) {
    // check if we already have the item in our cart
    let alreadyExistsInCart: boolean = false;
    let existingCartItem: CartItem = undefined;

    // find the item in the cart based on item id
    if (this.cartItems.length > 0) {
      existingCartItem = this.cartItems.find(tempCartItem => tempCartItem.id == cartItem.id);

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

  decrementQuantity(cartItem: CartItem) {
    cartItem.quantity--;
    if (cartItem.quantity == 0) {
      this.remove(cartItem)
    }
    else {
      this.computeCartTotals();
    }
  }

  remove(cartItem: CartItem) {
    // get index of item in array
    const itemIndex = this.cartItems.findIndex(tempCartItem => tempCartItem.id == cartItem.id);

    // if found, remove the item from the array at the given index
    if (itemIndex > -1) {
      this.cartItems.splice(itemIndex, 1);
      this.computeCartTotals();
    }
  }
}
