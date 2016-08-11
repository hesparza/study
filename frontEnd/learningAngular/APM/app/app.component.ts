import { Component } from 'angular2/core';
import { HTTP_PROVIDERS } from 'angular2/http';
import 'rxjs/Rx'; //Load all features
import { ROUTER_PROVIDERS, RouteConfig, ROUTER_DIRECTIVES } from 'angular2/router';

import { ProductListComponent } from './products/product-list.component';
import { WelcomeComponent } from './home/welcome.component'
import { ProductListService } from './products/product-list.service';

@Component({
    selector: 'pm-app',
    template: `
            <div>
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <a class="navbar-brand">{{ pageTitle }}</a>
                        <ul class="nav navbar-nav">
                            <li><a [routerLink]="['Welcome']">Home</a></li>
                            <li><a [routerLink]="['Products']">Product List</a></li>
                        </ul>
                    </div>
                </nav>
            </div>`,
    directives: [ROUTER_DIRECTIVES],
    providers: [ProductListService, HTTP_PROVIDERS, ROUTER_PROVIDERS]
})
@RouteConfig([
    { path: '/welcome', name: 'Welcome', component: WelcomeComponent, useAsDefault: true },
    { path: '/products', name: 'Products', component: ProductListComponent }
])
export class AppComponent {
    pageTitle: string = 'Acme Product Management'
}