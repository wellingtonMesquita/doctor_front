import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { OrderServiceService } from 'src/app/services/order-service.service';


@Component({
  selector: 'app-create-order',
  templateUrl: './create-order.component.html',
  styleUrls: ['./create-order.component.css']
})
export class CreateOrderComponent implements OnInit {

  public doctors = [{ name: '' }];
  public exams = [{ name: '' }];
  public collectionPosts = [{ name: '' }];
  public patients = [{ name: '' }];

  public filteredListDoctors = this.doctors.slice();
  public filteredListExams = this.exams.slice();
  public filteredListCollectionPosts = this.collectionPosts.slice();
  public filteredListPatients = this.patients.slice();

  orderServiceForm: FormGroup;
  covenant = new FormControl('', [Validators.required]);
  data = new FormControl('', [Validators.required])
  collectionPost = new FormControl('', [Validators.required]);
  doctor = new FormControl('', [Validators.required])
  examlist = new FormControl('', [Validators.required])
  patient = new FormControl('', [Validators.required])
  getErrorMessage() {
    if (this.covenant.hasError('required')) {
      return 'Convenio necessário';
    }
    if (this.data.hasError('required')) {
      return 'Data necessário';
    }
    if (this.collectionPost.hasError('required')) {
      return 'Posto de Coleta necessário';
    }
    if (this.doctor.hasError('required')) {
      return 'Medico necessário';
    }
    if (this.examlist.hasError('required')) {
      return 'Exame necessário';
    }

    return '';

  }

  constructor(fb: FormBuilder, private orderService: OrderServiceService, private router: Router) {
    this.orderServiceForm = fb.group({
      covenant: this.covenant,
      data: this.data,
      collectionPost: this.collectionPost,
      doctor: this.doctor,
      examlist: this.examlist,
      patient:this.patient
    });
  }

  saveorderServices(orderService: any) {
    this.orderService.saveOrderService(orderService).subscribe(() => {
      this.router.navigateByUrl('')
      console.log("sucesso");
    })
  }

  getDoctors() {
    this.orderService.getDoctors().subscribe(data => {
      this.filteredListDoctors = data.slice();
      this.doctors = data;


      console.log(this.doctors);
      console.log("sucesso");
    })
  }
  getExams() {
    this.orderService.getExams().subscribe(data => {
      this.exams = data;
      this.filteredListExams = this.exams.slice();
      console.log("sucesso");
    })
  }
  getPatients() {
    this.orderService.getPatients().subscribe(data => {
      this.patients = data;
      this.filteredListPatients = this.patients.slice();
      console.log("sucesso");
    })
  }
  getCollectionPost() {
    this.orderService.getCollectionPosts().subscribe(data => {
      this.collectionPosts = data;
      this.filteredListCollectionPosts = this.collectionPosts.slice();
      console.log("sucesso");
    })
  }
  submit() {
    let orderServiceExam = {
      orderOfService:{
        covenant: '',
        data: '',
        collectionPost: '',
        doctor: '',
        patient:''
      },
      examlist:[]
     
    };
    orderServiceExam.orderOfService.covenant = this.orderServiceForm.get('covenant')?.value;
    orderServiceExam.orderOfService.data = this.orderServiceForm.get('data')?.value;
    orderServiceExam.orderOfService.collectionPost = this.orderServiceForm.get('collectionPost')?.value;
    orderServiceExam.examlist = this.orderServiceForm.get('examlist')?.value;
    orderServiceExam.orderOfService.doctor = this.orderServiceForm.get('doctor')?.value;
    orderServiceExam.orderOfService.patient = this.orderServiceForm.get('patient')?.value;
    this.saveorderServices(orderServiceExam);
  }
  ngOnInit(): void {
    this.getCollectionPost();
    this.getDoctors();
    this.getExams();
    this.getPatients();
    this.orderServiceForm.get('status')?.setValue('false');
  }

}



