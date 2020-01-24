import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { ServletService } from './servlet.service';
@Injectable({
  providedIn: 'root'
})
export class SecureGuarGuard implements CanActivate {
constructor(private serOb : ServletService){}
  canActivate()
  {
    return this.serOb.isValid;
  }
}
