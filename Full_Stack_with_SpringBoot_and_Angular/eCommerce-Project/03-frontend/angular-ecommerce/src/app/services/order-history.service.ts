import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrderHistory } from '../common/order-history';

@Injectable({
  providedIn: 'root'
})
export class OrderHistoryService {

  private orderUrl: string = "http://localhost:8080/api/orders";

  constructor(private httpClient: HttpClient) { }

  getOrderHistory(email: string): Observable<GetResponseOrderHistory> {
      // need to build a URL based on customer URL
      const orderHistoryUrl: string = `${this.orderUrl}/search/findByCustomerEmail?email=${email}`;
      return this.httpClient.get<GetResponseOrderHistory>(orderHistoryUrl);
  }
}

interface GetResponseOrderHistory {
  _embedded: {
    orders: OrderHistory[];
  }
}
