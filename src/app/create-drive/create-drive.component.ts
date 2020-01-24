import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl,Validators } from '@angular/forms';
import { ServletService } from '../servlet.service';


@Component({
  selector: 'app-create-drive',
  templateUrl: './create-drive.component.html',
  styleUrls: ['./create-drive.component.css']
})
export class CreateDriveComponent implements OnInit {

   driveform:FormGroup;

   constructor(private _servletService:ServletService){}
    
  ngOnInit()
  {
    this.driveform=new FormGroup({
    companyname:new FormControl('',[Validators.required]),
    resource: new FormControl('',[Validators.required]),
    exp:new FormControl('',[Validators.required]),
    ctc:new FormControl('',[Validators.required]),
    position:new FormControl('',[Validators.required]),
    joining:new FormControl('',[Validators.required]),
    education:new FormControl('',[Validators.required]),
    followup: new FormControl('',[Validators.required]),
    bond:new FormControl('',[Validators.required]),
    });
  }

  submit() { 
    alert("Data Added Successfully !!");
    this._servletService.register(this.driveform.value).subscribe(e => { this.driveform.reset(); });
    // console.log(this.driveform.value); 
    // this._servletService.register(this.driveform.value)
    //           .subscribe(response => console.log("Success!!!",response),
    //           error=>console.error("Errrror!!!",error)); 
    }
}
