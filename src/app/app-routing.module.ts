import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateDriveComponent } from './create-drive/create-drive.component'
import { ViewDriveComponent } from './view-drive/view-drive.component';
import { EditDriveComponent } from './editdrive/editdrive.component';
import { SecureGuarGuard } from './secure-guar.guard';
import { LoginFormComponent } from './login-form/login-form.component';


const routes: Routes = [
  {path:'create',component:CreateDriveComponent, canActivate : [SecureGuarGuard]},
  {path:'view',component:ViewDriveComponent, canActivate : [SecureGuarGuard]},
  {path:'edit/:id',component:EditDriveComponent,pathMatch:"full", canActivate : [SecureGuarGuard]},
  {path : 'login', component : LoginFormComponent, pathMatch : 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
