import { NgModule, Pipe, PipeTransform } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateOrderComponent } from './order-service/create-order/create-order.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { HttpClientModule } from '@angular/common/http';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatTableModule} from '@angular/material/table';
import {MatFormFieldModule} from '@angular/material/form-field';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatRadioModule} from '@angular/material/radio';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { FlexLayoutModule } from '@angular/flex-layout';

import {MatSelectModule} from '@angular/material/select';
import { MatSelectFilterModule } from 'mat-select-filter';
import { SidebarComponent } from './sidebar/sidebar/sidebar.component';
import { ListOrderComponent } from './order-service/list-order/list-order.component';

@Pipe({ name: 'filter' })
export class FilterPipe implements PipeTransform {
  transform(value: any[], term: string) {
    if (!term) return value;

    return value.filter(item => item.value.toLowerCase().indexOf(term.toLowerCase()) !== -1);

  }
}


@NgModule({
  declarations: [
    AppComponent,
    CreateOrderComponent,
    SidebarComponent,
    FilterPipe,
    ListOrderComponent
  ],
  imports: [
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatIconModule,
    MatButtonModule,
    MatInputModule,
    MatCardModule,
    MatGridListModule,
    MatTableModule,
    MatFormFieldModule,
    MatCheckboxModule,
    MatRadioModule,
    MatPaginatorModule,
    MatSortModule,
    FlexLayoutModule,
    MatSelectModule,
    MatSelectFilterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
