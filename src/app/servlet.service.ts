import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServletService {

  isValid  =  new BehaviorSubject<boolean>(false);
  constructor(private _http:HttpClient) { }

  register(u)
  {
    return this._http.post("http://localhost:8082/DriveProject_TQ/CreateDrive",u);
  }

  viewdata()
  {
    return this._http.get("http://localhost:8082/DriveProject_TQ/ViewData");
  }

  editData(id)
  {
    console.log("This is Edit !");
    return this._http.post("http://localhost:8082/DriveProject_TQ/EditData",id);
  }

  deleteData(cid)
  {
    return this._http.post("http://localhost:8082/DriveProject_TQ/DeleteData",cid);
  }

  // editData(id)
  // {
  //   return this._http.post("",id);
  // }

}
