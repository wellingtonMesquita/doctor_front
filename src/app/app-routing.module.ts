import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateOrderComponent } from './order-service/create-order/create-order.component';
import { ListOrderComponent } from './order-service/list-order/list-order.component';

const routes: Routes = [

  { path: 'cadastrar',component: CreateOrderComponent },
  { path: '',component: ListOrderComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 


}
