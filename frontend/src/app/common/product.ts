export class Product {
  constructor(
    public sku: string,
    public name: string,
    public description: string,
    public imageUrl: string,
    public active: boolean,
    public unitsInStock: number,
    public unitPrice: number,
    public dateCreated: Date,
    public lastUpdated: Date
  ){}
}
