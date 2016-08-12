import { Component } from 'angular2/core';
import { Router, RouteParams } from 'angular2/router'

import { ProductListService } from './product-list.service'
import { IProduct } from './product'

@Component({
    templateUrl: 'app/products/product-detail.component.html'
})

export class ProductDetailComponent {
    pageTitle: string = 'Product Details';
    product: IProduct;
    errorMessage: string;

    constructor(private _routeParams: RouteParams, private _router: Router,
                private _productListService: ProductListService) {
        let id = +this._routeParams.get('id');
        this.pageTitle += `: ${id}`;
    }

    onBack(): void {
        this._router.navigate(['Products']);
    }

    ngOnInit() {
        if (!this.product) {
            let id = +this._routeParams.get('id');
            // this.pageTitle += `: ${id}`;
            this.getProduct(id);
        }
    }

    getProduct(id: number) {
        this._productListService.getProductById(id)
            .subscribe(
            product => this.product = product,
            error => this.errorMessage = <any>error);
    }

}