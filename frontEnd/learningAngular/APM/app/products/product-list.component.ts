import { Component, OnInit } from 'angular2/core';
import { ROUTER_DIRECTIVES } from 'angular2/router'

import { IProduct } from './product';
import { ProductListFilterPipe } from './product-list-filter.pipe'
import { StarComponent } from '../shared/star.component'
import { ProductListService } from './product-list.service'

@Component({
    templateUrl: "app/products/product-list.component.html",
    styleUrls: ['app/products/product-list.component.css'],
    pipes: [ProductListFilterPipe],
    directives: [StarComponent, ROUTER_DIRECTIVES]
})

export class ProductListComponent implements OnInit {
    pageTitle: string = 'Product List';
    imageWidth: number = 50;
    imageMargin: number = 2;
    showImage: boolean = false;
    btnImageTxt: string = 'Show Image';
    products: IProduct[] = null;
    listFilter: string = '';
    errorMessage: string = '';

    constructor(private _productListService: ProductListService) {

    }

    toggleImage(): void {
        this.showImage = !this.showImage;
        this.btnImageTxt = this.showImage ? 'Hide Image' : 'Show Image';
    }

    onRatingClicked(message: string): void {
        this.pageTitle = 'Product List: ' + message;
        console.log('rating click captured');
    }

    ngOnInit(): void {
        this._productListService.getProducts()
        .subscribe(
            responseData => this.products = responseData,
            error => this.errorMessage = <any>error);
    } 
 } 