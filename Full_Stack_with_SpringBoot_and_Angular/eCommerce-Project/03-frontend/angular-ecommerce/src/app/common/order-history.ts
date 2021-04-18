export class OrderHistory {
    // all items that we want to display in order history table
    id: string;
    orderTrackingNumber: string;
    totalPrice: number;
    totalQuantity: number;
    dateCreated: Date;

    // We only want to display these items on the UI, there are a ton of other items in the REST GET response.
}
