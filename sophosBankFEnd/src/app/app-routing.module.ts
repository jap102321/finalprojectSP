import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreatetransacComponent } from './transactions/createtransac.component';
const routes: Routes = [
 { path: '', loadChildren: () => import('./landing/landing.module').then(m => m.LandingModule) },
 { path: 'accounts', loadChildren: () => import('./account/account.module').then(m => m.AccountModule) },
 { path: 'clients', loadChildren: () => import('./clientlists/clientlists.module').then(m => m.ClientlistsModule) }, 
 { path: 'transactions', loadChildren: () => import('./transactions/transactions.module').then(m => m.TransactionsModule) },
 { path: 'devinfo', loadChildren: () => import('./devinfo/devinfo.module').then(m => m.DevinfoModule) },
 { path: 'cretra/:id', loadChildren: () => import('./transactions/cretransac.module').then(m => m.CretransacModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
   exports: [RouterModule]
})
export class AppRoutingModule { }
