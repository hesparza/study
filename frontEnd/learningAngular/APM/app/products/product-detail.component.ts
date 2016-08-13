import { Component } from 'angular2/core';
import { Router, RouteParams } from 'angular2/router';
import { Observable } from 'rxjs/Observable';

import { ProductListService } from './product-list.service';
import { IProduct } from './product';
import { StarComponent } from '../shared/star.component';

@Component({
    templateUrl: 'app/products/product-detail.component.html',
    directives: [StarComponent]
})

export class ProductDetailComponent {
    pageTitle: string = 'Product Details';
    product: IProduct;
    errorMessage: string;

    constructor(private _routeParams: RouteParams, private _router: Router,
                private _productListService: ProductListService) {
    }

    onBack(): void {
        this._router.navigate(['Products']);
    }

    ngOnInit() {
        if(!this.product) {
            let id = +this._routeParams.get('id');
            // this.pageTitle += `: ${id}`;
            this.getProduct(id);
        }
    }

    getProduct(id: number) {
        console.log('the id: ' + id);
        // this._productListService.getProducts()
        //     .subscribe(
        //     product => this.product = product,
        //     error => this.errorMessage = <any>error);

        // this._productListService.getProducts()
        //     .subscribe(function(result: IProduct[]) {
        //         console.log('.......gathering the result......');
        //         this.product = result[0];
        //         console.log('And this is the product: ' + this.product);
        //     },
        //     error => this.errorMessage = <any>error);

        this._productListService.getProduct(id)
            .subscribe(
                product => this.product = product,
                error => this.errorMessage = <any>error);
    }

}