import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { OrderServiceExam } from '../models/order-service-exam';
import { Page } from '../models/page';

@Injectable({
  providedIn: 'root'
})
export class OrderServiceService {
  url = 'http://localhost:8080/api';


  constructor(private httpClient: HttpClient) { }


  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }


  getDoctors(): Observable<any> {
    return this.httpClient.get<any>(this.url + '/doctors')
      .pipe()
  }
  getExams(): Observable<any> {
    return this.httpClient.get<any>(this.url + '/exams')
      .pipe()
  }
  getPatients(): Observable<any> {
    return this.httpClient.get<any>(this.url + '/patients')
      .pipe()
  }
  getCollectionPosts(): Observable<any> {
    return this.httpClient.get<any>(this.url + '/collection-posts')
      .pipe()
  }

  getOrderServices(page: any, size: any): Observable<Page> {
    return this.httpClient.get<Page>(this.url + '/order-services/' + `?pag=${page}&size=${size}`)
      .pipe()
  }
  saveOrderService(OrderServiceExam: OrderServiceExam): Observable<OrderServiceExam> {
    return this.httpClient.post<OrderServiceExam>(this.url + '/order-services', JSON.stringify(OrderServiceExam), this.httpOptions)
      .pipe(

      )
  }





  handleError(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {

      errorMessage = error.error.message;
    } else {

      errorMessage = `Código do erro: ${error.status}, ` + `menssagem: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  };
}
