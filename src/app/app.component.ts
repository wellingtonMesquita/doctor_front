
import { Component, OnDestroy, ChangeDetectorRef } from "@angular/core";



@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent implements OnDestroy {
  ngOnDestroy(): void {
    throw new Error("Method not implemented.");
  }
 
}
