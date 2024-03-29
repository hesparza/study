import { Injectable } from 'angular2/core';
import { Http, Response } from 'angular2/http';
import { Observable } from 'rxjs/Observable';

import { IProduct } from './product';


@Injectable()
export class ProductListService {
    private _getProductsUrl = 'api/products/productsa.json';
    private _errorMessage: string;

    constructor(private _http: Http) {

    }

    getProducts(): Observable<IProduct[]> {
        return this._http.get(this._getProductsUrl)
                   .map((response: Response) => <IProduct[]>response.json())
                   .do(data => console.log('All: ' + JSON.stringify(data)))
                   .catch(this.handleError);
    }

    getProduct(id: number): Observable<IProduct> {
        return this.getProducts()
                .map((products: IProduct[]) => products.find(p => p.productId === id));
    }

    private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error.json().error || 'Server error');
    }
}