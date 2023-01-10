import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CretransacRoutingModule } from './cretransac-routing.module';
import { CretransacComponent } from './cretransac.component';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatDialogModule} from '@angular/material/dialog';
import {MatInputModule} from '@angular/material/input';
import {MatNativeDateModule} from '@angular/material/core';
import {MatDatepickerModule} from '@angular/material/datepicker';

@NgModule({
  declarations: [
    CretransacComponent
  ],
  imports: [
    CommonModule,
    CretransacRoutingModule, 
    RouterModule,
    FormsModule,
    NgbModule,
    MatToolbarModule,
    MatDialogModule,
    MatButtonModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule
  ]
})
export class CretransacModule { }
