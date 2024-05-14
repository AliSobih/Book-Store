import { Component, OnInit } from '@angular/core';
import { ProudectService } from '../../services/proudect.service';
import { Product } from '../../common/product';

@Component({
  selector: 'app-product-list',
  // templateUrl: './product-list.component.html',
  templateUrl: './product-listgrid.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent implements OnInit{
  products: Product[] = [];
  constructor(private productService: ProudectService){}
  ngOnInit(): void {
    this.listProducts();
  }

  listProducts() {
    this.productService.getProductList().subscribe(
      products => this.products = products
    )
  }
}
