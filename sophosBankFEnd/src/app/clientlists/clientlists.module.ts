import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { ClientlistsRoutingModule } from './clientlists-routing.module';
import { ClientlistsComponent } from './clientlists.component';
import { UpdateclientComponent } from './updateclient.component';
import { CreateclientComponent } from './createclient.component';
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
    ClientlistsComponent,
    UpdateclientComponent,
    CreateclientComponent,
  ],
  imports: [
    CommonModule,
    ClientlistsRoutingModule,
    RouterModule,
    FormsModule,
    NgbModule,
    MatToolbarModule,
    MatDialogModule,
    MatButtonModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  providers:[
    MatDatepickerModule,
    MatNativeDateModule
  ]
})
export class ClientlistsModule { }
