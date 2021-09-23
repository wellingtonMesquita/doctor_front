import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { OrderServiceExam } from 'src/app/models/order-service-exam';
import { OrderServiceService } from 'src/app/services/order-service.service';

@Component({
  selector: 'app-list-order',
  templateUrl: './list-order.component.html',
  styleUrls: ['./list-order.component.css']
})
export class ListOrderComponent implements OnInit {

  public pageOfItems: Array<OrderServiceExam> = [];
  public dataSource!: MatTableDataSource<OrderServiceExam>;
  public displayedColumns: string[] = ['data', 'paciente', 'convenio', 'postodecoleta', 'medico', 'price'];
  public totalDeElementos = 0;
  public pageInit = 0;
  public pageSize = 10;


  constructor(private service: OrderServiceService) {
    this.service.getOrderServices(this.pageInit, this.pageSize).subscribe(data => {
      this.totalDeElementos = data.totalElements;
      this.dataSource = new MatTableDataSource(data.content);


    });
  }
  ngOnInit() {

  }
  onChangePage(event: any) {
    this.service.getOrderServices(event.pageIndex, event.pageSize).subscribe(data => {
      console.log(event);
      this.dataSource = new MatTableDataSource(data.content);


    });
  }
  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}
