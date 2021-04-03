export class Product {
    // the property names should exactly match as is in the API returned data
    sku: string;
    name: string;
    description: string;
    unitPrice: string;
    imageUrl: string;
    active: boolean;
    unitsInStock: number;
    dateCreated: Date;
    dateUpdated: Date;
}
